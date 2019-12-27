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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stefano
 */
public class Bullet extends SolidObject implements Cloneable,Movable,Drawable{
    private int damage;
    private boolean active;
    private Direction d;
    
    private final static String bullet = "src/resources/leftbullet.png";
    
    

    public Bullet(Point position,String id, int damage, Direction d) {
        
        super(position, 0, 0, id);
        
        this.image = SolidObject.loadImage(bullet);
        super.setWidth(GameSettings.BulletDimension.width);
        super.setHeigth(GameSettings.BulletDimension.height);
        this.damage=damage;
        active = true;
        this.d=d;
        
        
        CollisionController.getInstance().addObject(this);
        
        
        
    }
    
    

    @Override
    public synchronized void move(int dx, int dy) {
         position.translate(dx, 0);
    }

    @Override
    public Bullet clone() throws CloneNotSupportedException {
         Bullet clone = (Bullet) super.clone();
         return clone;
    }

    public boolean isActive() {
        return active;
    }
    
    public void setActive(boolean active){
        this.active = active;
    }
    
    public Direction getDirection(){
        return d;
    }

   
    @Override
    public void setCollision(Collision c) {
        
        SolidObject so =c.getSubject();
        String id = so.getId();
        if(id.equals("player") || id.equals("enemy" ) ){
           
            Character p = (Character) so;
            int currentHealth = p.getHealth();
            p.setHealth(currentHealth-damage);
        }
        
        unDraw();
        CollisionController.getInstance().removeObject(this);
        active = false;
        
    }
    

   
    @Override
    public Image getDraw() {
      
        
        return image;
        //return getHitbox();
    }

    
    
    
    
   
    
    
}
