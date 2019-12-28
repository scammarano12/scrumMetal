/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalscrum;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;

import java.util.Random;

/**
 *
 * @author SimonePadula
 */
public class Enemy extends Character {
    
    private long time;
    

    public Enemy(Point position, int width, int heigth, String id, int health, Weapon weapon) {
        super(position, width, heigth, id,health, weapon);
        
        time = System.currentTimeMillis();
        
        
    }
    
    
    
    

    
    
    
   
    
    
    @Override
    public void setCollision(Collision c){
        super.setCollision(c);
        
        SolidObject so =c.getObject();
        if(so!=null){
        String id = so.getId();
        if(id.equals("player") && System.currentTimeMillis()-time > 5000 ){
            time = System.currentTimeMillis();
           
           Character p = (Character) so;
            int currentHealth = p.getHealth();
            p.setHealth(currentHealth-1);
        }
    }
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
        Image i = state.nextImage();
        return i;
        //return getHitbox();
    }

    
    
    
    
}
