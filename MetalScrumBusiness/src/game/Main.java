/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.frame.Application;
import game.state.StartMenuState;
import game.listeners.GameListener;
import game.listeners.PlayLevelOverListener;
import game.listeners.PlayListener;
import game.listeners.PlayStageListener;
import game.listeners.QuitListener;
import game.listeners.RestartListener;
import game.listeners.ResumeListener;
import game.menu.MenuGameOver;
import game.menu.MenuLevelTerminated;
import game.menu.MenuPause;
import game.menu.MenuStageTerminated;
import game.menu.MenuStart;


/**
 *
 * @author albc
 */
public class Main {
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
        */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
                Application app = new Application();
                MenuStart start = initStartMenu(app);
                MenuPause pause = initPauseMenu(app);
                MenuLevelTerminated levelOver = initLevelOverMenu(app);
                MenuStageTerminated stageOver = initStageOverMenu(app);
                MenuGameOver gameOver = initGameOverMenu(app);
                app.setStart(start);
                app.setPause(pause);
                app.setGameOver(gameOver);
                app.setLevelOver(levelOver);
                app.setStageOver(stageOver);
                app.setStatus(new StartMenuState(start));
                app.setVisible(true);
                app.initMusic();
 
                app.run();
        
                
         
    }
    
         
            
     private static MenuStart initStartMenu(Application context){
        MenuStart start = new MenuStart();
        start.setPlay(new PlayListener(context));
        
        context.getContentPane().add(start);
        start.setSize(GameSettings.FrameDimension.width,GameSettings.FrameDimension.height);
        start.setVisible(false);
        return start;
    }
      private static MenuPause initPauseMenu(Application context){
        MenuPause pause = new MenuPause();
        GameListener gameListener = new GameListener(context);
        pause.setResume(new ResumeListener(context,gameListener));
        pause.setRestart(new RestartListener(context));
        pause.setQuit(new QuitListener(context));
       
        context.getContentPane().add(pause);
        pause.setSize(GameSettings.FrameDimension.width,GameSettings.FrameDimension.height);
        pause.setVisible(false);
        return pause;
    }
      
       private static MenuGameOver initGameOverMenu(Application context){
        MenuGameOver gameOver= new MenuGameOver();
        gameOver.setQuit(new QuitListener(context));
        gameOver.setPlay(new PlayListener(context));
        context.getContentPane().add(gameOver);
        gameOver.setSize(GameSettings.FrameDimension.width,GameSettings.FrameDimension.height);
        gameOver.setVisible(false);
        return gameOver;
    }
       private static MenuStageTerminated initStageOverMenu(Application context){
        MenuStageTerminated stageOver= new MenuStageTerminated();
        stageOver.setPlay(new PlayStageListener(context));
        context.getContentPane().add(stageOver);
        stageOver.setSize(GameSettings.FrameDimension.width,GameSettings.FrameDimension.height);
        stageOver.setVisible(false);
        return stageOver;
    }
       private static MenuLevelTerminated initLevelOverMenu(Application context){
        MenuLevelTerminated levelOver= new MenuLevelTerminated();
        levelOver.setPlay(new PlayLevelOverListener(context));
        context.getContentPane().add(levelOver);
        levelOver.setSize(GameSettings.FrameDimension.width,GameSettings.FrameDimension.height);
        levelOver.setVisible(false);
        return levelOver;
    }
     
     
}
