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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

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
        checkStatus();
        
        
        
    }
    
  
    
    public void checkStatus(){
        gameStatus = GameStatus.getGameStatus();
        switch(gameStatus){
            case 1:
                Drawer.setScene(new Scene());
                super.setSize(1280, 720);
                super.setResizable(false);
                super.setContentPane(Drawer.getScene());
               
                Drawer.getScene().setFocusable(true);
                initLevel(1);
                
                super.getContentPane().addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ESCAPE ){
                    if(GameStatus.getGameStatus()==0){
                        GameStatus.setGameStatus(2);
                    }
                    else if(GameStatus.getGameStatus()==2){
                        GameStatus.setGameStatus(0);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
                });
                
                GameStatus.setGameStatus(0);
                clock.start();
            break;
            case 0:
                CollisionSystem.checkCollision();
            
            for(CharacterController c :controllers){
                c.updatePositions();
            }
            repaint();
                System.out.println("in game");
                 
                break;
            case 2:
                System.out.println("pause");
                
                break;
            case 3:
               
                break;
            case 4:
                System.out.println("GameOver");
                break;
        
        }
    }
    
    public void initLevel(int levelNumber){
        CollisionSystem.setCollisionController(new CollisionController());
        List<Point> l = LevelBuilder.createStage(levelNumber, 1);
        initPlayer(l.remove(0));

        initEnemy(l);
        
             
    }
    
    public void initPlayer(Point position){
        Player player = new Player(position,50,45,"player",true,1,Direction.RIGHT,new Weapon(2));
        PlayerController controller = new PlayerController();
       
        controllers.add(controller);
        
        controller.addMovable(player);
        this.getContentPane().addKeyListener(controller);
       
        Drawer.addToDraw(player);
        CollisionSystem.addCollisionSubject(player);
        CollisionSystem.addCollisionObject(player);
        
    }
    
    
    //aggiunto SSS
    public synchronized void initEnemy(List<Point> positions){
        
        //da spostare, magari, in quale classe apposita a fare ciò!
 
        
        
        
        for(int i=0; i<positions.size(); i++){
            //Aggiunto SSS
            Enemy enemy = new Enemy(positions.get(i),50,45,"enemy",true,4,Direction.RIGHT,new Weapon(2));
            
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
    
    private Timer clock = new Timer(5,this);
    private List<CharacterController> controllers = new LinkedList<>();
    private int gameStatus;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clock){
            checkStatus();
            
            
        }
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
