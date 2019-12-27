package metalscrum;

import characterState.CharacterState;
import java.awt.Image;
import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;

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
    
    public void setState(CharacterState state){
        this.state = state;
    }
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Direction getCurrentDir() {
        return state.getDir();
    }

    public Point getPosition() {
        return position;
    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeigth() {
        return heigth;
    }

    @Override
    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public Image getDraw(){
       Image i =  state.nextImage();
      
       return i;
    }
    
    
    
    

    
    
     
    
    
    
    
}
