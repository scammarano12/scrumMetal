/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.frame;


import game.state.State;
import game.menu.MenuGameOver;
import game.menu.MenuLevelTerminated;
import game.menu.MenuPause;
import game.menu.MenuStageTerminated;
import game.menu.MenuStart;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import game.collisions.CollisionController;
import game.levels.GameLevel;
import game.GameSettings;
import game.character.Player;
import game.character.controller.CharacterController;
import game.scene.Scene;

/**
 *
 * @author stefano
 */
public class Application extends javax.swing.JFrame {

    /**
     * Creates new form Application
     */
    
    private State gameStatus;
    private Timer clock ;
    private MenuPause pause ;
    private MenuStart start;
    private MenuGameOver gameOver;
    private MenuStageTerminated stageOver;
    private MenuLevelTerminated levelOver;
    private Clip clip;
    private CollisionController cc;
    private Scene sc;
    
    public Application() {
        
        initComponents();
        
         
        setSize(GameSettings.FrameDimension.width,GameSettings.FrameDimension.height);
        setResizable(false);
        initScene();
        initCollisionController();
        
        gameStatus=null;
        
    }
    
    public void run(){
        while(true){
            try {
               
                Thread.sleep(5);
                     
                         
                        execute();
                          
                
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                       
                        repaint(); 
                    //To change body of generated methods, choose Tools | Templates.
                    }
                }); 
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
   
    
   
    
   
    
    
    @Override
    public void setVisible(boolean isVisible){
        super.setVisible(isVisible);
        
    }
    
    
    private synchronized void initScene(){
        sc = Scene.getInstance();
        getContentPane().add(sc);
        sc.setSize(GameSettings.FrameDimension.width,GameSettings.FrameDimension.width);
        sc.setVisible(false);
        
    }
    
    private  void initCollisionController(){
        cc = CollisionController.getInstance();
    }
    
    public synchronized void initMusic() {
        try {
            clip = AudioSystem.getClip();
            
            
            
             AudioInputStream inputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("src/resources/GameSounds/music.wav")));
             BufferedInputStream bf = new BufferedInputStream(inputStream);
            
             inputStream = new AudioInputStream(bf,inputStream.getFormat(),inputStream.getFrameLength());
             clip.open(inputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            VolumeOnListener on = new VolumeOnListener();
            VolumeOffListener off = new VolumeOffListener();
          pause.setVolumeOff(off);
         pause.setVolumeOn(on);
          start.setVolumeOff(off);
          start.setVolumeOn(on);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
      
         
         
    }
   
    

    
    
    public synchronized void  setPause(MenuPause m){
        pause=m;
    }
    public synchronized void setStart(MenuStart m){
        start=m;
    }
    
    public synchronized void setGameOver(MenuGameOver m){
        gameOver=m;
    }
    public synchronized void setLevelOver(MenuLevelTerminated m){
        levelOver=m;
    }
    public void setStageOver(MenuStageTerminated m){
        stageOver=m;
    }
    
    public synchronized void execute(){
         
        gameStatus.execute();
        
    }
    
    public synchronized void end(){
        gameStatus.end();
    } 
    
    public synchronized MenuPause getPause(){
        return pause;
    }
    public synchronized MenuStart getStart(){
        return start;
    }
    public synchronized MenuGameOver getGameOver(){
        return gameOver;
    }
    public synchronized MenuLevelTerminated getLevelOver(){
        return levelOver;
    }
    public synchronized MenuStageTerminated getStageOver(){
        return stageOver;
    }
    
    
    
    
    
    public synchronized State getStatus(){
        return gameStatus;
    }
    
    public synchronized void setStatus(State newState){
        if(gameStatus!=null) 
            gameStatus.end();
        
        gameStatus = newState;
        
    } 
    
    public synchronized Player getCurrentPlayer(){
        return gameStatus.getPlayer();
    }
    
    public synchronized GameLevel getCurrentGameLevel(){
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

    
    
    
   
            
       
            
       
    
   
    
    
    
    
    
    private class VolumeOffListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(clip.isActive())
                clip.stop();
        }

}
    
    private class VolumeOnListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!clip.isActive())
                clip.start();
        }

}
}

    
   
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables



