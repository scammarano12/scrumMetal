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
public class Bullet extends SolidObject implements Runnable,Cloneable,Movable,Drawable{
    private int damage;
    private boolean active;
    private Direction d;
    private HashMap<Direction,Image> images;
    private final static String LEFT_BULLET = "src/resources/leftbullet.png";
    private final static String RIGHT_BULLET = "src/resources/rightbullet.png";
    

    public Bullet(Point position, int width, int heigth, String id, boolean isVisible,int damage,Direction d) {
        super(position, width, heigth, id, isVisible);
        this.damage=damage;
        active = true;
        this.d=d;
        this.images = new HashMap<>();
        images.put(Direction.LEFT,super.loadImage(LEFT_BULLET));
        images.put(Direction.LEFT,super.loadImage(RIGHT_BULLET));
        
    }

    @Override
    public void move(int dx, int dy) {
         position.translate(dx, 0);
    }

    @Override
    public Bullet clone() throws CloneNotSupportedException {
         Bullet clone = (Bullet) super.clone();
         return clone;
    }

   
    @Override
    public void setCollision(Collision c) {
        
        SolidObject subject = c.getSubject();
        if(c.getSubject().getId().equals("player")){
          int health = ((Character) subject).getHealth();
          ((Character) subject).setHealth(health-damage);
        }
        if(c.getSubject().getId().equals("enemy")){
            int health = ((Character) subject).getHealth();
            ((Character) subject).setHealth(health-damage);
        }
        
        if(c.getObject()!=null){
        Drawer.removeFromDraw(this);
        CollisionSystem.removeCollisionObject(this);
        CollisionSystem.removeCollisionSubject(this);
        active = false;
        }
    }

   

    @Override
    public void run() {
        while(active){
            try {
                Thread.sleep(3);
                
                    if(d == Direction.LEFT){
                        move(-1,0);
                    }
                else if(d == Direction.RIGHT){
                    move(1,0);
                }
                
            } //To change body of generated methods, choose Tools | Templates.
            catch (InterruptedException ex) {
                Logger.getLogger(Bullet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Image getDraw() {
        return this.images.get(currentDir);
        //return getHitbox();
    }
    
   
    
    
}
