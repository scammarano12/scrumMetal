/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalscrum;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.Timer;
import testmenu.*;

/**
 *
 * @author stefano
 */
public class Application extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form Application
     */
    
    private static State gameStatus;
    
    public Application() {
        
        
        
        
        
        initComponents();        
        clock=new Timer(5,this);
        setSize(1280, 720);
        setResizable(false);
        initStartMenu();
        initPauseMenu();
        initGameOverMenu();
        initStageOverMenu();
        initLevelOverMenu();
        initScene();
        initCollisionController();
        initMusic();
        //sc = Scene.getInstance();
        
        //CollisionSystem.setCollisionController(new CollisionController());
        //cc = CollisionController.getInstance();
        
        //pause = new MenuPause();
        //start = new MenuStart();
        
        //pause.setResume(new ResumeListener());
        //start.setPlay(new PlayListener());
        //start.setVolumeOff(new VolumeOffListener());
        //start.setVolumeOn(new VolumeOnListener());
        //pause.setRestart(new RestartListener());
        //pause.setQuit(new QuitListener());
        //pause.setVolumeOff(new VolumeOffListener());
        //pause.setVolumeOn(new VolumeOnListener());
        //gameOver= new MenuGameOver();
        //gameOver.setQuit(new QuitListener());
        //gameOver.setPlay(new PlayListener());
        //stageOver= new MenuStageTerminated();
        //stageOver.setPlay(new PlayStageListener());
        //levelOver= new MenuLevelTerminated();
        //levelOver.setPlay(new PlayLevelOverListener());
        
        //getContentPane().add(gameOver);
        //getContentPane().add(stageOver);
        //getContentPane().add(start);
        //getContentPane().add(pause);
        //getContentPane().add(levelOver);
        //getContentPane().add(sc);
        
        //sc.setSize(1280, 720);
        
        //gameOver.setSize(1280, 720);
        //stageOver.setSize(1280, 720);
        //pause.setSize(1280, 720);
        //start.setSize(1280, 720);
        //levelOver.setSize(1280,720);
        //pause.setVisible(false);
        //start.setVisible(false);
        //gameOver.setVisible(false);
        //stageOver.setVisible(false);
        //levelOver.setVisible(false);
        
        //sc.setVisible(false);
        
        //controllers = new LinkedList<>();
        //checkStatus();
       // setStatus(new StartMenuState(start));
        gameStatus=new StartMenuState(start);
        clock.start();
        
    }
    
    private void initStartMenu(){
        start = new MenuStart();
        start.setPlay(new PlayListener());
        start.setVolumeOff(new VolumeOffListener());
        start.setVolumeOn(new VolumeOnListener());
        getContentPane().add(start);
        start.setSize(1280, 720);
        start.setVisible(false);
    }
    
    private void initPauseMenu(){
        pause = new MenuPause();
        pause.setResume(new ResumeListener());
        pause.setRestart(new RestartListener());
        pause.setQuit(new QuitListener());
        pause.setVolumeOff(new VolumeOffListener());
        pause.setVolumeOn(new VolumeOnListener());
        getContentPane().add(pause);
        pause.setSize(1280, 720);
        pause.setVisible(false);
    }
    
    private void initGameOverMenu(){
        gameOver= new MenuGameOver();
        gameOver.setQuit(new QuitListener());
        gameOver.setPlay(new PlayListener());
        getContentPane().add(gameOver);
        gameOver.setSize(1280, 720);
        gameOver.setVisible(false);
    }
    
    private void initStageOverMenu(){
        stageOver= new MenuStageTerminated();
        stageOver.setPlay(new PlayStageListener());
        getContentPane().add(stageOver);
        stageOver.setSize(1280, 720);
        stageOver.setVisible(false);
    }
    
    private void initLevelOverMenu(){
        levelOver= new MenuLevelTerminated();
        levelOver.setPlay(new PlayLevelOverListener());
        getContentPane().add(levelOver);
        levelOver.setSize(1280,720);
        levelOver.setVisible(false);
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
    
    private static State getStatus(){
        return gameStatus;
    }
    
    private static void setStatus(State newState){
        gameStatus = newState;
    } 
    
    private Player getCurrentPlayer(){
        return gameStatus.getPlayer();
    }
    
    private GameLevel getCurrentGameLevel(){
        return gameStatus.getGameLevel();
    }
    
    private List<CharacterController> getCurrentControllers(){
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
                Application app = new Application();
                app.setVisible(true);
            }
        });
    }
    
    private Timer clock ;
    
    //private List<CharacterController> controllers;
//    private int gameStatus;
    
    private MenuPause pause ;
    private MenuStart start;
    private MenuGameOver gameOver;
    private MenuStageTerminated stageOver;
    private MenuLevelTerminated levelOver;
    private MediaPlayer mp;
    
    //private GameLevel gl=null;
    //private Player player;
    
    private CollisionController cc;
    private Scene sc;
    
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

     public class StartMenuState implements State{
        private MenuStart start;

        public StartMenuState(MenuStart start) {
            this.start = start;
        }
        
        
        public void execute(){
            
            if(!start.isVisible()){
                start.setVisible(true);
                start.requestFocusInWindow();
                     
        }
            
            /*
            if(!start.isVisible()){
                     initLevel();
                      //player = new Player(new Point(0,0),50,45,"player",true,3,Direction.RIGHT,new Weapon(2));
                     start.setVisible(true);
                     start.requestFocusInWindow();
                }
*/
        }

        @Override
        public void escape() {
            
        }

        @Override
        public void end() {
            if(start.isVisible())
               start.setVisible(false);
        }

        @Override
        public void setListener(EndStateListener listener) {
            
        }

        @Override
        public Player getPlayer() {
            return null;
        }

        @Override
        public GameLevel getGameLevel() {
            return null;
        }

        @Override
        public List<CharacterController> getControllers() {
            return null;
        }
    }
    
     private class PlayListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            gameStatus.end();
            State s=new LoadingLevelState();
            s.setListener(new LoadedLevelListener());
            gameStatus=s;
            //start.setVisible(false);
            //gameOver.setVisible(false);
            //GameStatus.setGameStatus(-1);
        }
    
    }
    
     public class LoadingLevelState implements State{
        private GameLevel gl;
        private Player player;
        private EndStateListener listener;
        
        
        public void initLevel(){
            this.gl= new GameLevel(1,3);
        }
        
        public void execute(){
            initLevel();
            this.player = new Player(new Point(0,0),50,45,"player",true,3,Direction.RIGHT,new Weapon(2));
            //GameStatus.setGameStatus(1);
            listener.stateEnded();
            
        }

        @Override
        public void escape() {
            
        }

        @Override
        public void end() {
            
        }

        @Override
        public void setListener(EndStateListener listener) {
            this.listener=listener;
        }

        @Override
        public Player getPlayer() {
            return player;
        }

        @Override
        public GameLevel getGameLevel() {
            return gl;
        }

        @Override
        public List<CharacterController> getControllers() {
            return null;
        }
    }
    
     private class LoadedLevelListener implements EndStateListener{

        @Override
        public void stateEnded() {
            
            State s=new LoadingStageState(getCurrentGameLevel(),getCurrentPlayer(),new LinkedList<CharacterController>());
            s.setListener(new LoadedStageListener());
            gameStatus=s;
        }
        
    }
     
     public class LoadingStageState implements State{
        private Scene sc;
        private CollisionController cc;
        private Player player;
        private List<CharacterController> controllers;
        private GameLevel gl;
        
        private EndStateListener listener;
        public LoadingStageState(GameLevel gl,Player player,List<CharacterController> controllers) {
            this.sc = Scene.getInstance();
            this.cc= CollisionController.getInstance();
            this.gl=gl;
            this.player=player;
            this.controllers=controllers;
            
        }
        public void initPlayer(Point position,Player player){
             player.setPosition(position);

             PlayerController controller = new PlayerController();
             controller.setListener(new PlayerListener());
             controllers.add(controller);

             controller.addMovable(player);
             sc.addKeyListener(controller);
             player.draw();
             cc.addSubject(player);
             cc.addObject(player);  
    }
        public void initEnemy(List<Point> positions){
        
        //da spostare, magari, in quale classe apposita a fare ciò!
 
        
        
        
            for(int i=0; i<positions.size(); i++){
                //Aggiunto SSS
                Enemy enemy = new Enemy(positions.get(i),50,45,"enemy",true,2,Direction.LEFT,new Weapon(2));

                EnemyController controller = new EnemyController(100,300);

                controllers.add(controller);

                controller.addMovable(enemy);
                //associare all'enemy un timer per spostarsi e sparare!
                enemy.draw();
                enemy.activeCollision();
                //CollisionSystem.addCollisionObject(enemy);
            }
        
        
        }
        public void initStage(){
            controllers = new LinkedList<>();


            List<Point> l = gl.createStage();
            initPlayer(l.remove(0),player);
            initEnemy(l);
        
             
    }
        public void execute(){
            sc.reset();
            cc.reset();

            controllers.forEach(c-> c.deActive());
            System.out.println("loading");

            initStage();

            

            //GameStatus.setGameStatus(0);

            sc.setVisible(true);
            sc.requestFocusInWindow();
            listener.stateEnded();
            
            
        }

        @Override
        public void escape() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void end() {
            
        }

        @Override
        public void setListener(EndStateListener listener) {
            this.listener=listener;
        }

        @Override
        public Player getPlayer() {
            return player;
        }

        @Override
        public GameLevel getGameLevel() {
            return gl;
        }

        @Override
        public List<CharacterController> getControllers() {
            return controllers;
        }
    }
     
    private class LoadedStageListener implements EndStateListener{

        @Override
        public void stateEnded() {
            State s= new InGameState(getCurrentControllers(),getCurrentGameLevel(),getCurrentPlayer());
            s.setListener(new EndGameListener());
            gameStatus=s;
        }
        
    }
    
    public class InGameState implements State{
        private Scene sc;
        private CollisionController cc;
        private List<CharacterController> controllers;
        private GameLevel gl;
        private EndStateListener listener;
        private GameListener gameListener;
        private Player player;

        public InGameState(List<CharacterController> controllers,GameLevel gl,Player player) {
            this.sc = Scene.getInstance();
            this.cc= CollisionController.getInstance();
            this.controllers=controllers;
            this.gl=gl;
            this.gameListener=new GameListener();
            this.player=player;
            sc.addKeyListener(gameListener);
        }
        
        public void execute(){
            cc.checkCollision();
                int enemyCounter=-1;
                for(CharacterController c :controllers){
                    c.updatePositions();
                    if(c.isActive)
                        enemyCounter++;
                }
                gl.setResumeEnemies(enemyCounter);
                
            
               
                if(enemyCounter==0)
                    listener.stateEnded();
                    //GameStatus.setGameStatus(5);          
                 
               
        }

        @Override
        public void escape() {
            
        }

        @Override
        public void end() {
            sc.setVisible(false);
            sc.removeKeyListener(gameListener);
        }

        @Override
        public void setListener(EndStateListener listener) {
            this.listener=listener;
        }

        @Override
        public Player getPlayer() {
            return player;
        }

        @Override
        public GameLevel getGameLevel() {
            return gl;
        }

        @Override
        public List<CharacterController> getControllers() {
            return controllers;
        }
        
    }
    
    private class GameListener implements KeyListener{
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ESCAPE ){
                    /*if(GameStatus.getGameStatus()==0){
                        GameStatus.setGameStatus(2);
                    }*/                   
                    gameStatus.end();
                    gameStatus=new PauseMenuState(pause,getCurrentControllers(),getCurrentGameLevel(),getCurrentPlayer());

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
    }
    
    private class EndGameListener implements EndStateListener{

        @Override
        public void stateEnded() {
            gameStatus= new StageOverMenuState(stageOver,levelOver,getCurrentGameLevel(),getCurrentPlayer(),getCurrentControllers());
                
        }
        
    }
    
    public class StageOverMenuState implements State{
        
        private MenuStageTerminated stageOver;
        private MenuLevelTerminated levelOver;
        private GameLevel gl;
        private Scene sc;
        private Player player;
        private List<CharacterController> controllers;
        
        public StageOverMenuState(MenuStageTerminated stageOver, MenuLevelTerminated levelOver,GameLevel gl, Player player,List<CharacterController> controllers) {
            this.stageOver = stageOver;
            this.levelOver = levelOver;
            this.gl=gl;
            this.sc=Scene.getInstance();
            this.controllers=controllers;
            this.player=player;
        }
        
        
        public void execute(){
            if(!stageOver.isVisible() && !levelOver.isVisible()){
                gl.nextStage();
         
                sc.setVisible(false);
                if(gl.checkNextStage()){
                    stageOver.setVisible(true);
                    stageOver.requestFocusInWindow();
                }else{
                    levelOver.setVisible(true);
                    levelOver.requestFocusInWindow();
                    
                }
            }   
        }

        @Override
        public void escape() {
            
        }

        @Override
        public void end() {
            levelOver.setVisible(false);
            stageOver.setVisible(false);
        }

        @Override
        public void setListener(EndStateListener listener) {
            
        }

        @Override
        public Player getPlayer() {
            return player;
        }

        @Override
        public GameLevel getGameLevel() {
            return gl;
        }

        @Override
        public List<CharacterController> getControllers() {
            return controllers;
        }
    }
    
    private class PlayStageListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            
            gameStatus.end();
            State s=new LoadingStageState(getCurrentGameLevel(),getCurrentPlayer(),getCurrentControllers());
            s.setListener(new LoadedStageListener());
            gameStatus=s;
            
            //GameStatus.setGameStatus(1);
        }
    
    }
        
    private class PlayLevelOverListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            gameStatus.end();
            State s= new LoadingLevelState();
            s.setListener(new LoadedLevelListener());
            gameStatus=s;
//            GameStatus.setGameStatus(3);
            
        }
    
    }
    
    public class PauseMenuState implements State{
        private MenuPause pause;
        private List<CharacterController> controllers;
        private GameLevel gl;
        private Player player;

        public PauseMenuState(MenuPause pause, List<CharacterController> controllers, GameLevel gl, Player player) {
            this.pause = pause;
            this.gl=gl;
            this.controllers=controllers;
            this.player=player;
        }
        
        public void execute(){
            if(!pause.isVisible()){
                pause.setVisible(true);
                pause.requestFocusInWindow();
               }
        }

        @Override
        public void escape() {
//            
        }

        @Override
        public void end() {
            pause.setVisible(false);
        }

        @Override
        public void setListener(EndStateListener listener) {
            
        }

        @Override
        public Player getPlayer() {
            return player;
        }

        @Override
        public GameLevel getGameLevel() {
            return gl;
        }

        @Override
        public List<CharacterController> getControllers() {
            return controllers;
        }
    }
    
    
    
    private class ResumeListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            gameStatus.end();
            gameStatus= new InGameState(getCurrentControllers(), getCurrentGameLevel(),getCurrentPlayer());
            
            
            
        }
    
    }
    
    private class RestartListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            gameStatus.end();
            State s= new LoadingLevelState();
            s.setListener(new LoadedLevelListener());
            gameStatus=s;
            //GameStatus.setGameStatus(1);
            
        }
    
    }
    
    
    
    private class QuitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            gameStatus.end();
            gameStatus= new StartMenuState(start);
     
            
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
    
    public class GameOverMenu implements State{
        private MenuGameOver gameOver;

        public GameOverMenu(MenuGameOver gameOver) {
            this.gameOver = gameOver;
        }
        
        public void execute(){
        if(!gameOver.isVisible()){
                System.out.println("GameOver");
                
                gameOver.setVisible(true);
                gameOver.requestFocusInWindow();
                }
        }

        @Override
        public void escape() {
            
        }

        @Override
        public void end() {
            gameOver.setVisible(false);
            
        }

        @Override
        public void setListener(EndStateListener listener) {
            
        }

        @Override
        public Player getPlayer() {
            return null;
        }

        @Override
        public GameLevel getGameLevel() {
            return null;
        }

        @Override
        public List<CharacterController> getControllers() {
            return null;
        }
    }
    
    public class PlayerListener implements PlayerDeadListener{

        @Override
        public void playerDead() {
            gameStatus.end();
            gameStatus=new GameOverMenu(gameOver);
            
        }

        @Override
        public void playerHealthLevelEnded() {
            gameStatus.end();
            State s= new LoadingStageState(getCurrentGameLevel(), getCurrentPlayer(), getCurrentControllers());
            s.setListener(new LoadedStageListener());
            gameStatus=s;
        }
        
    }
    
    
    
    
   
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}


