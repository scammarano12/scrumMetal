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
import java.util.Objects;
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

   
    @Override
    public void setCollision(Collision c) {
        /*
        SolidObject subject = c.getSubject();
        if(c.getSubject().getId().equals("player")){
          int health = ((Character) subject).getHealth();
          ((Character) subject).setHealth(health-damage);
        }
        if(c.getSubject().getId().equals("enemy")){
            int health = ((Character) subject).getHealth();
            ((Character) subject).setHealth(health-damage);
        }
        */
        
        Drawer.removeFromDraw(this);
        CollisionSystem.removeCollisionObject(this);
        
        active = false;
        
    }

   
    @Override
    public Image getDraw() {
        return this.images.get(currentDir);
        //return getHitbox();
    }

    
    
    
    //Per la classe WeaponTest
    @Override
    public boolean equals(Object obj){
        //Point position, int width, int heigth, String id, boolean isVisible,int damage,Direction currentDir
        
        Bullet b = ((Bullet)obj);
        if(this.position.x != b.position.x || this.position.y != b.position.y)
            return false;
        if(this.width != b.width)
            return false;
        if(this.heigth != b.heigth)
            return false;
        if(this.id != b.id)
            return false;
        if(!(this.isVisible()==true && b.isVisible()==true || this.isVisible()==false && b.isVisible()==false))
            return false;
        if(this.damage!=b.damage)
            return false;
        if(this.currentDir!=b.currentDir)
            return false;
        
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.damage;
        hash = 71 * hash + (this.active ? 1 : 0);
        hash = 71 * hash + Objects.hashCode(this.images);
        return hash;
    }
   

    
}
