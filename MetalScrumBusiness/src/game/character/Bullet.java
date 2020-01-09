/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.character;

import game.character.Character;
import java.awt.Image;
import java.awt.Point;
import game.collisions.Collision;
import game.collisions.CollisionController;
import game.objects.movable.Direction;
import game.scene.Drawable;
import game.GameSettings;
import game.objects.SolidObject;
import game.objects.movable.Movable;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author stefano
 */
public class Bullet extends SolidObject implements Cloneable,Movable,Drawable{
    private int damage;
    private boolean active;
    private Direction d;
    private Clip clip;
    private Clip damageSound;
    
    
    protected String bullet;
    
    

    public Bullet(Point position,String id, int damage, Direction d) {
        
        super(position, 0, 0, id);
        initMusic();
        bullet = "src/resources/objects/bullet.png";
        this.image = SolidObject.loadImage(bullet,game.GameSettings.BulletDimension.width,game.GameSettings.BulletDimension.height);
        super.setWidth(GameSettings.BulletDimension.width);
        super.setHeight(GameSettings.BulletDimension.height);
        this.damage=damage;
        active = true;
        this.d=d;
        
        
        CollisionController.getInstance().addObject(this);
        
        
        
    }
    
    public  void initMusic() {
        try {
            clip = AudioSystem.getClip();
           
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("src/resources/GameSounds/boom1.wav")));
             BufferedInputStream bf = new BufferedInputStream(inputStream);
            
             inputStream = new AudioInputStream(bf,inputStream.getFormat(),inputStream.getFrameLength());
             clip.open(inputStream);
             clip.start();
             
             damageSound = AudioSystem.getClip();
             inputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("src/resources/GameSounds/damage.wav")));
             bf = new BufferedInputStream(inputStream);
             inputStream = new AudioInputStream(bf,inputStream.getFormat(),inputStream.getFrameLength());
             damageSound.open(inputStream);
             
             
            
             
             
             
             
             
             
             
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    
    }
    
        
      
         
         
    
    
    

    @Override
    public synchronized void move(int dx, int dy) {
         position.translate(dx, dy);
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
        String idDamaged = so.getId();
        if(idDamaged.equals("player")){
            if(id.equals("bulletenemy")|| id.equals("bulletboss")){
                damageSound.start();
                Character p = (Character) so;
                int currentHealth = p.getHealth();
                p.setHealth(currentHealth-damage);
        
            }
                
        }else if(idDamaged.equals("enemy") || idDamaged.equals("boss")){
            
            if(id.equals("bulletplayer")){
                damageSound.start();
                Character p = (Character) so;
                int currentHealth = p.getHealth();
                p.setHealth(currentHealth-damage);
        
            }
                
        
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
