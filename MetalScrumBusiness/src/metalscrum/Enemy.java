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
    
    private final static String rightEnemy="src/resources/enemyLeft.png";
    private final static String leftEnemy="src/resources/enemyRight.png";
    private final static String shootingright="src/resources/enemyRight.png";
    private final static String shootingleft="src/resources/enemyLeft.png";
    private double time ;
    private Direction d;
    private HashMap<Direction,Image> images = new HashMap<>();

    public Enemy(Point position, int width, int heigth, String id, boolean isVisible, int health, Direction currentDir, Weapon weapon) {
        super(position, width, heigth, id,health, weapon);
        d=currentDir;
        images.put(Direction.RIGHT,loadImage(rightEnemy));
        images.put(Direction.LEFT,loadImage(leftEnemy));
        images.put(Direction.SHOOTING_RIGHT,loadImage(shootingright));
        images.put(Direction.SHOOTING_LEFT,loadImage(shootingleft));
        time = System.currentTimeMillis();
        
        
    }
    
    public void setCurrentDir(Direction d){
        this.d = d;
    }
    
    @Override
    public Direction getCurrentDir(){
        return d;
    }
    public void shoot(){
        
        Bullet b = weapon.shoot(position, getCurrentDir(),this.width,this.heigth);
        
        if(b!=null)
            bullets.add(b);
        
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
        Image i = images.get(currentDir);
        this.setHeigth(i.getHeight(null));
       this.setWidth(i.getWidth(null));
       return i;
        //return getHitbox();
    }

    
    
    
    
}
