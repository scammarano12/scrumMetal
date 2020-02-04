/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.character.boss;

import game.GameSettings;
import game.character.AereoBossEnemy;
import game.character.boss.BossEnemy;
import game.character.CharacterController;
import game.character.enemy.Enemy;
import game.character.boss.BossStopLeft;
import game.character.enemy.EnemyStopLeft;
import game.character.enemy.EnemyStopRight;
import game.character.enemy.EnemyWalkLeft;
import game.character.enemy.EnemyWalkRight;
import game.collisions.Collision;
import game.character.Bullet;
import game.objects.movable.Direction;
import game.objects.movable.Movable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author luca pomposelli
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
    


