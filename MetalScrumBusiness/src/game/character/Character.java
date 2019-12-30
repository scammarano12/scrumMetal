package game.character;

import game.character.state.CharacterState;
import java.awt.Image;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import game.objects.Bullet;
import game.collisions.CollisionController;
import game.objects.movable.Direction;
import game.scene.Drawable;
import game.objects.movable.Movable;
import game.objects.SolidObject;
import game.objects.Weapon;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * Software Engineering Group
 */
/**
 *
 * @author albc
 */
public abstract class Character extends SolidObject implements Movable,Drawable {
    protected Weapon weapon;
    protected int health;
    protected List<Bullet> bullets;
    protected CharacterState state;
    private Clip deathSound;


    public Character(Point position, int width, int heigth, String id,int health,Weapon weapon) {
        super(position, width, heigth, id);
        initMusic();
        state = null;
        this.health=health;
        this.currentDir=Direction.RIGHT;
        this.weapon=weapon;
        this.bullets = new LinkedList<>();
        
    }
    
    public  void initMusic() {
        try {
            deathSound = AudioSystem.getClip();
           
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("src/resources/GameSounds/enemyDeath.wav")));
             BufferedInputStream bf = new BufferedInputStream(inputStream);
            
             inputStream = new AudioInputStream(bf,inputStream.getFormat(),inputStream.getFrameLength());
             deathSound.open(inputStream);
             
        } catch (Exception ex) {
            System.out.println(ex);
        }
    
    }
    public Weapon getWeapon(){
        return weapon;
    }
    
    
    @Override
    public void activeCollision() {
       
        CollisionController.getInstance().addSubject(this);
    }

    @Override
    public void stopCollision() {
      
       CollisionController.getInstance().removeSubject(this); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public List<Bullet> getFiredBullets(){
        bullets.removeIf(b -> !b.isActive());
        return bullets;
    }
    
    public boolean isAlive(){
        if(health<=0){
            deathSound.start();
            return false;
        }
        else
            return true;
    }
    
    public void shoot(){
        Bullet b = weapon.shoot(position, getCurrentDir(),this.width,this.heigth);
        
        if(b!=null)
            bullets.add(b);
        
    }
    
    public synchronized void setState(CharacterState state){
        this.state = state;
    }
    public synchronized int getHealth() {
        return health;
    }

    public synchronized void setHealth(int health) {
        this.health = health;
    }

    public synchronized Direction getCurrentDir() {
        return state.getDir();
    }
 

    @Override
    public synchronized Image getDraw(){
       Image i =  state.nextImage();
      
       return i;
    }
    
    @Override
    public synchronized void move(int dx, int dy) {
        getPosition().translate(dx, dy);
  
    }
    
    
    
    

    
    
     
    
    
    
    
}
