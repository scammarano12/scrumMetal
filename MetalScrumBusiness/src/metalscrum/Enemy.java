/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalscrum;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import java.util.Random;

/**
 *
 * @author SimonePadula
 */
public class Enemy extends Character {
    
    private final static String rightEnemy="src/resources/enemyRight.png";
    private final static String leftEnemy="src/resources/enemyLeft.png";
    


    public Enemy(Point position, int width, int heigth, String id, boolean isVisible, int health, Direction currentDir, Weapon weapon) {
        super(position, width, heigth, id, isVisible, health, currentDir, weapon);
        images.put(Direction.RIGHT,loadImage(rightEnemy));
        images.put(Direction.LEFT,loadImage(leftEnemy));
        
    }
    
    
    
    @Override
    public void move(int dx, int dy) {
    
        if (dx>0 && !collision.isRigth() || dx<0 && !collision.isLeft()){ 
            if(dx>0)
                currentDir = Direction.RIGHT;
            else
                currentDir = Direction.LEFT;
                        
            getPosition().translate(dx,0);
        }
        
        if(dy<0 && !collision.isTop() || dy>0 && !collision.isDown() ){
               
                 getPosition().translate(0, dy) ;
        }
        
    }

    @Override
    public Image getDraw() {
        return images.get(currentDir);
        //return getHitbox();
    }
    
}
