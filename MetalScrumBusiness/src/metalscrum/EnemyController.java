/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalscrum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author SimonePadula
 */
public class EnemyController extends CharacterController implements ActionListener {

    private int count=0;
    private int rangeMin;
    private int rangeMax;
    
    private float distance;
    private Timer timer;
    
    
    @Override
    public void deActive(){
        timer.stop();
        super.deActive();
    }
    public EnemyController(int rangeMin, int rangeMax){
        this.rangeMin = rangeMin;
        this.rangeMax = rangeMax;
        Random rand = new Random();
        this.distance = rand.nextInt((this.rangeMax - this.rangeMin) + 1) + this.rangeMin;
        //System.out.println(this.distance);
        
        this.timer = new Timer(rand.nextInt(2000-1000)+1000, this);
        timer.start();
        
    }
        

    public int getRangeMin() {
        return rangeMin;
    }

    public void setRangeMin(int rangeMin) {
        this.rangeMin = rangeMin;
    }

    public int getRangeMax() {
        return rangeMax;
    }

    public void setRangeMax(int rangeMax) {
        this.rangeMax = rangeMax;
    }
    

    public float getDistance() {
        return distance;
    }
    
    
    @Override
    public void updatePositions() {
        
        
        for (Movable m : characters) {  //si può togliere il foreach
            Enemy e = (Enemy) m;
            if(e.isAlive()){
                if(shoot){
                    e.shoot();
                    shoot=false;
                }
                
 
            if( ((Enemy)m).getCurrentDir()==Direction.RIGHT ){
                if(count < this.distance){
                    dx = 1;
                    count++;
                    //System.out.print("DX ");
                    //System.out.println(count);
                    
                } else{
                    dx = -1;
                    count--;
                    ((Enemy)m).setCurrentDir(Direction.LEFT);
                    //System.out.print("DX ");
                    //System.out.println(count);
                }    
            }
            
            
            if( ((Enemy)m).getCurrentDir()==Direction.LEFT ){
                if( count>0 ){ //dx==((Enemy)m).getDistance()
                    dx = -1;
                    count--;
                    //System.out.print("SX ");
                    //System.out.println(count);
                } else{
                    dx = 1;
                    count++;
                    ((Enemy)m).setCurrentDir(Direction.RIGHT);
                    //System.out.print("SX ");
                    //System.out.println(count);
                }
            }
            
            
            
            Collision collision=((Enemy)m).getCollision();
            if (dx>0 && !collision.isRigth() || dx<0 && !collision.isLeft()){ 
               
                    
                m.move(dx,0);
            }
            if(collision.isDown())
                dy=0;
            else dy=gravitylv;
            
            if( dy>0 && !collision.isDown() ){
                
                m.move(0, dy) ;
            }
            
            for(Bullet b : ((Enemy)m).getFiredBullets()){
                if(b.getHitbox().x>1280 || b.getHitbox().x<0){
                    
                    b.setActive(false);
                    Drawer.removeFromDraw(b);
                    CollisionSystem.removeCollisionObject(b);
                }
                else if(b.getCurrentDir() == Direction.SHOOTING_LEFT){
                        b.move(-10,0);
                    }
                else if(b.getCurrentDir() == Direction.SHOOTING_RIGHT){
                    b.move(10,0);
                }
            }

            }
            else{
                timer.stop();
                this.characters.remove(e);
                e.getFiredBullets().forEach((b) -> {Drawer.removeFromDraw(b);CollisionSystem.removeCollisionObject(b);});
                Drawer.removeFromDraw(e);
                CollisionSystem.removeCollisionObject(e);
                CollisionSystem.removeCollisionSubject(e);
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==timer){
            
        for (Movable m : characters) {
            shoot=true;
            
        }
        
        }
    }
    

}
