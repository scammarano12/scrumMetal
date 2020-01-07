/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.character.controller;

import game.GameSettings;
import game.character.Enemy;
import game.character.state.FlyingEnemyState.*;

import game.collisions.Collision;
import game.objects.Bullet;
import game.objects.movable.Direction;
import game.objects.movable.Movable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author stefano
 */
public class FlyingEnemyController extends CharacterController implements ActionListener {
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
    
 
    
    public FlyingEnemyController(int rangeMin, int rangeMax){
        this.stopLeft = new FlyingEnemyStopLeft();
        this.stopRight = new FlyingEnemyStopRight();
        this.walkLeft = new FlyingEnemyWalkLeft();
        this.walkRight = new FlyingEnemyWalkRight();
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
        
        if (characters.isEmpty())
            isActive=false;
        for (Movable m : characters) {  //si può togliere il foreach
            Enemy e = (Enemy) m;
            
            if(e.isAlive()){
                if(shoot){
                    e.shoot();
                    shoot=false;
                }

            if( e.getCurrentDir()==Direction.RIGHT ){
                
                if(count < this.distance){
                    dx = 1;
                    count++;
                    
                    //System.out.print("DX ");
                   //System.out.println(count);
                    
                } else{
                    dx = -1;
                    count--;
                    e.setState(walkLeft);
                    //System.out.print("DX ");
                    //System.out.println(count);
                }    
            }
            
            
            if( e.getCurrentDir()==Direction.LEFT ){
                if( count>0 ){ //dx==((Enemy)m).getDistance()
                    dx = -1;
                    count--;
                    //System.out.print("SX ");
                    //System.out.println(count);
                } else{
                    dx = 1;
                    count++;
                    e.setState(walkRight);
                    //System.out.print("SX ");
                    //System.out.println(count);
                }
            }
            
            
            
            
            Collision collision=e.getCollision();
            
            
            if (dx>0 && !collision.isRigth() || dx<0 && !collision.isLeft()){ 
                
                e.move(dx,0);
            }
            
            if(collision.isDown())
                dy=0;
            else 
                dy=gravitylv;
            
            
            if( dy>0 && !collision.isDown() ){
                
                e.move(0, dy) ;
            }
            
            for(Bullet b : e.getFiredBullets()){
                if(b.getHitbox().y >GameSettings.FrameDimension.height){
                    
                    b.setActive(false);
                    b.unDraw();
                    b.stopCollision();
                }
                else if(b.getDirection() == Direction.LEFT){
                        b.move(-10,0);
                    }
                else if(b.getDirection() == Direction.RIGHT){
                    b.move(10,0);
                } else if(b.getDirection() == Direction.DOWN){
                    b.move(0,5);
                }
                
            }

            }
            else{
                timer.stop();
                this.characters.remove(e);
                e.getFiredBullets().forEach((b) -> {b.unDraw();b.stopCollision();});
                e.unDraw();
                e.stopCollision();
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==timer){
            Random rand = new Random();
            timer.setDelay(rand.nextInt(2000));
        for (Movable m : characters) {
            shoot=true;
            
        }
        
        }
    }
    
    public void stopShoot(){
        timer.stop();
    }
    public void startShoot(){
        timer.start();
    }
}
