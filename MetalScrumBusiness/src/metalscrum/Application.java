/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalscrum;

import java.awt.Container;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.JPanel;
import javax.swing.Timer;
import testmenu.Menu;
import testmenu.MenuGameOver;
import testmenu.MenuPause;
import testmenu.MenuStart;

/**
 *
 * @author stefano
 */
public class Application extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form Application
     */
    public Application() {
        
        initComponents();
        clock=new Timer(5,this);
        Drawer.setScene(new Scene());
        CollisionSystem.setCollisionController(new CollisionController());
        pause = new MenuPause();
        start = new MenuStart();
        setSize(1280, 720);
        setResizable(false);
        pause.setResume(new ResumeListener());
        start.setPlay(new PlayListener());
        start.setVolumeOff(new VolumeOffListener());
        start.setVolumeOn(new VolumeOnListener());
        pause.setRestart(new RestartListener());
        pause.setQuit(new QuitListener());
        pause.setVolumeOff(new VolumeOffListener());
        pause.setVolumeOn(new VolumeOnListener());
        gameOver= new MenuGameOver();
        gameOver.setQuit(new QuitListener());
        gameOver.setPlay(new PlayListener());
        getContentPane().add(gameOver);
        
        getContentPane().add(start);
        getContentPane().add(pause);
        getContentPane().add(Drawer.getScene());
        Drawer.getScene().setSize(1280, 720);
        gameOver.setSize(1280, 720);
        pause.setSize(1280, 720);
        start.setSize(1280, 720);
        pause.setVisible(false);
        start.setVisible(false);
        gameOver.setVisible(false);
        Drawer.getScene().setVisible(false);
        
        controllers = new LinkedList<>();
        mp=loadMusic("src/resources/music.mp3");
        mp.play();
        checkStatus();
        
        
    }
    
  
    
    public void checkStatus(){
        gameStatus = GameStatus.getGameStatus();
        switch(gameStatus){
            case 1:
                Drawer.resetScene();
                CollisionSystem.resetCollisionSystem();
                controllers.forEach(c-> c.deActive());
                System.out.println("loading");
                Drawer.getScene().setVisible(true);
                initLevel(1);
                Drawer.getScene().addKeyListener(new GameListener());
                Drawer.getScene().requestFocusInWindow();
                GameStatus.setGameStatus(0);
                clock.start();
                
            break;
            case 0:
                //in game
                
                CollisionSystem.checkCollision();
            
            for(CharacterController c :controllers){
                c.updatePositions();
            }
            repaint();
                
                 
                break;
                
            case 2:
                clock.stop();
                pause.setVisible(true);
                pause.requestFocusInWindow();
                
                
                
                
                break;
            case 3:
                start.setVisible(true);
                start.requestFocusInWindow();
                
               
                
                    
                break;
            case 4:
                System.out.println("GameOver");
                clock.stop();
                Drawer.getScene().setVisible(false);
                gameOver.setVisible(true);
                gameOver.requestFocusInWindow();
                
                break;
        
        }
    }
    
    public void initLevel(int levelNumber){
        controllers = new LinkedList<>();
        
        
        List<Point> l = LevelBuilder.createStage(levelNumber, 1);
        initPlayer(l.remove(0));
        initEnemy(l);
        
             
    }
    
    public void initPlayer(Point position){
        Player player = new Player(position,50,45,"player",true,1,Direction.RIGHT,new Weapon(2));
        PlayerController controller = new PlayerController();
       
        controllers.add(controller);
        
        controller.addMovable(player);
        Drawer.getScene().addKeyListener(controller);
       
        Drawer.addToDraw(player);
        CollisionSystem.addCollisionSubject(player);
        CollisionSystem.addCollisionObject(player);
        
    }
    
    
    //aggiunto SSS
    public synchronized void initEnemy(List<Point> positions){
        
        //da spostare, magari, in quale classe apposita a fare ciò!
 
        
        
        
        for(int i=0; i<positions.size(); i++){
            //Aggiunto SSS
            Enemy enemy = new Enemy(positions.get(i),50,45,"enemy",true,40,Direction.LEFT,new Weapon(2));
            
            EnemyController controller = new EnemyController(100,300);
        
            controllers.add(controller);

            controller.addMovable(enemy);
            //associare all'enemy un timer per spostarsi e sparare!
            Drawer.addToDraw(enemy);
            CollisionSystem.addCollisionSubject(enemy);
            //CollisionSystem.addCollisionObject(enemy);
        }
        
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 873, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
                new Application().setVisible(true);
            }
        });
    }
    
    private Timer clock ;
    private List<CharacterController> controllers;
    private int gameStatus;
    private MenuPause pause ;
    private MenuStart start;
    private MenuGameOver gameOver;
    private MediaPlayer mp;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clock){
            checkStatus();
            
            
        }
        
    }

    private MediaPlayer loadMusic(String path) {
         new JFXPanel();
        Media hit = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        return mediaPlayer;
    }
    
    private class ResumeListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Drawer.getScene().setVisible(true);
            Drawer.getScene().requestFocusInWindow();
            pause.setVisible(false);
            GameStatus.setGameStatus(0);
            clock.start();
        }
    
    }
    
    private class RestartListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            pause.setVisible(false);
            GameStatus.setGameStatus(1);
            checkStatus();
        }
    
    }
    
    private class PlayListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            start.setVisible(false);
            gameOver.setVisible(false);
            GameStatus.setGameStatus(1);
            checkStatus();
        }
    
    }
    
    private class QuitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            pause.setVisible(false);
            gameOver.setVisible(false);
            GameStatus.setGameStatus(3);
            checkStatus();
        }

}
    
    private class VolumeOffListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            mp.pause();
        }

}
    
    private class VolumeOnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            mp.play();
        }

}
    
    
    
    private class GameListener implements KeyListener{
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ESCAPE ){
                    if(GameStatus.getGameStatus()==0){
                        GameStatus.setGameStatus(2);
                    }
                    
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
                }
    
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
