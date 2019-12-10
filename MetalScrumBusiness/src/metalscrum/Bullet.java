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
    private HashMap<Direction,Image> images;
    private final static String LEFT_BULLET = "src/resources/leftbullet.png";
    private final static String RIGHT_BULLET = "src/resources/rightbullet.png";
    

    public Bullet(Point position, int width, int heigth, String id, boolean isVisible,int damage,Direction currentDir) {
        super(position, width, heigth, id, isVisible);
        this.damage=damage;
        active = true;
        this.currentDir=currentDir;
        this.images = new HashMap<>();
        images.put(Direction.SHOOTING_LEFT,super.loadImage(LEFT_BULLET));
        images.put(Direction.SHOOTING_RIGHT,super.loadImage(RIGHT_BULLET));
        
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

   
    @Override
    public void setCollision(Collision c) {
        SolidObject so =c.getSubject();
        String id = so.getId();
        if(id.equals("player") || id.equals("enemy" )){
            Character p = (Character) so;
            int currentHealth = p.getHealth();
            p.setHealth(currentHealth-damage);
        }
        
        Drawer.removeFromDraw(this);
        CollisionSystem.removeCollisionObject(this);
        active = false;
        
    }
    

   
    @Override
    public Image getDraw() {
        return this.images.get(currentDir);
        //return getHitbox();
    }
    
   
    
    
}
