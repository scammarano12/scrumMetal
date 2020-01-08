/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.character.controller;

import game.GameSettings;
import game.character.AereoBossEnemy;
import game.character.BossEnemy;
import game.character.Enemy;
import game.character.state.FlyingEnemyState.AereoBossStopLeft;
import game.character.state.enemyState.BossStopLeft;
import game.character.state.enemyState.EnemyStopLeft;
import game.character.state.enemyState.EnemyStopRight;
import game.character.state.enemyState.EnemyWalkLeft;
import game.character.state.enemyState.EnemyWalkRight;
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
 * @author lucap
 */
public class AereoBossEnemyController extends CharacterController implements ActionListener{
    
   
   
    
 
    private Timer timer;
    
    
    @Override
    public void deActive(){
        timer.stop();
        super.deActive();
    }
    
 
    
    public AereoBossEnemyController(){ 
        stopLeft = new BossStopLeft();
        this.timer = new Timer(2000, this);
        timer.start();
         
    }
    
    public void addMovable(Movable m){
        AereoBossEnemy c = (AereoBossEnemy) m;
        c.setState(stopLeft);
        super.addMovable(m);
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
                    e.shoot();
                    e.shoot();
                    e.shoot();
                    shoot=false;
                }

            for(Bullet b : e.getFiredBullets()){
                if(b.getHitbox().x>GameSettings.FrameDimension.width|| b.getHitbox().x<0){
                    
                    b.setActive(false);
                    b.unDraw();
                    b.stopCollision();
                
                } else if(b.getDirection() == Direction.DOWN){
                    b.move(0,8);
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
        
       
        for (Movable m : characters) {
            shoot=true;
            
        }
        
        
    }
    
  
    }
    


