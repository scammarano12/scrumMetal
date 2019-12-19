/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalscrum;

import gameState.InGameState;
import gameState.LoadingLevelState;
import gameState.StartMenuState;
import menu.MenuGameOver;
import menu.MenuLevelTerminated;
import menu.MenuPause;
import menu.MenuStageTerminated;
import menu.MenuStart;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.Timer;
import listeners.LoadedLevelListener;
import listeners.PlayLevelOverListener;
import listeners.PlayStageListener;

/**
 *
 * @author stefano
 */
public class Application extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form Application
     */
    
    private State gameStatus;
    private Timer clock ;
    public MenuPause pause ;
    public MenuStart start;
    public MenuGameOver gameOver;
    public MenuStageTerminated stageOver;
    public MenuLevelTerminated levelOver;
    private MediaPlayer mp;
    private CollisionController cc;
    private Scene sc;
    
    public Application() {
        
        initComponents();
        
        
        clock=new Timer(5,this);
        setSize(1280, 720);
        setResizable(false);
        initScene();
        initCollisionController();
        //initMusic();
        //gameStatus=new StartMenuState(start);
        
    }
    
   
    
   
    
   
    
    
    @Override
    public void setVisible(boolean isVisible){
        super.setVisible(isVisible);
        clock.start();
    }
    
    
    private void initScene(){
        sc = Scene.getInstance();
        getContentPane().add(sc);
        sc.setSize(1280, 720);
        sc.setVisible(false);
        
    }
    
    private void initCollisionController(){
        cc = CollisionController.getInstance();
    }
    
    private void initMusic() {
         new JFXPanel();
        String path=("src/resources/music.mp3");
        
        Media hit = new Media(new File(path).toURI().toString());
        mp = new MediaPlayer(hit);
        mp.play();
    }
    
    public  State getStatus(){
        return gameStatus;
    }
    
    public  void setStatus(State newState){
        gameStatus = newState;
    } 
    
    public Player getCurrentPlayer(){
        return gameStatus.getPlayer();
    }
    
    public GameLevel getCurrentGameLevel(){
        return gameStatus.getGameLevel();
    }
    
    public List<CharacterController> getCurrentControllers(){
        return gameStatus.getControllers();
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

    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clock){
            clock.stop();
            //checkStatus(); 
            gameStatus.execute();
            System.out.println(gameStatus.getClass());
            repaint();
            clock.start();
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
    
   
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}


