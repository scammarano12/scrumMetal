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


    public Character(Point position, int width, int heigth, String id,int health,Weapon weapon) {
        super(position, width, heigth, id);
        state = null;
        this.health=health;
        this.currentDir=Direction.RIGHT;
        this.weapon=weapon;
        this.bullets = new LinkedList<>();
        
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
        
        return health>0;
    }
    
    public void shoot(){
        
        Bullet b = weapon.shoot(position, getCurrentDir(),this.width,this.heigth);
        
        if(b!=null)
            bullets.add(b);
        
    }
    
    public synchronized void setState(CharacterState state){
        this.state = state;
    }
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
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
