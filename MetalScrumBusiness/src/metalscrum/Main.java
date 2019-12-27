/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalscrum;

import gameState.StartMenuState;
import listeners.GameListener;
import listeners.buttonListeners.PlayLevelOverListener;
import listeners.buttonListeners.PlayListener;
import listeners.buttonListeners.PlayStageListener;
import listeners.buttonListeners.QuitListener;
import listeners.buttonListeners.RestartListener;
import listeners.buttonListeners.ResumeListener;
import menu.MenuGameOver;
import menu.MenuLevelTerminated;
import menu.MenuPause;
import menu.MenuStageTerminated;
import menu.MenuStart;


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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Application app = new Application();
                
                
                MenuStart start = initStartMenu(app);
                MenuPause pause = initPauseMenu(app);
                MenuLevelTerminated levelOver = initLevelOverMenu(app);
                MenuStageTerminated stageOver = initStageOverMenu(app);
                MenuGameOver gameOver = initGameOverMenu(app);
                app.start=start;
                app.pause=pause;
                app.gameOver=gameOver;
                app.levelOver=levelOver;
                app.stageOver=stageOver;
                app.setStatus(new StartMenuState(start));
                app.setVisible(true);
            }
        });
    }
     private static MenuStart initStartMenu(Application context){
        MenuStart start = new MenuStart();
        start.setPlay(new PlayListener(context));
        //start.setVolumeOff(new Application.VolumeOffListener());
        //start.setVolumeOn(new Application.VolumeOnListener());
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
       // pause.setVolumeOff(new Application.VolumeOffListener(context));
       // pause.setVolumeOn(new VolumeOnListener(context));
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
