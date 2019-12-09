package metalscrum;

import java.awt.Image;
import java.awt.Point;
import java.util.HashMap;
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
    


    public Character(Point position, int width, int heigth, String id, boolean isVisible,int health, Direction currentDir,Weapon weapon) {
        
        super(position, width, heigth, id, isVisible);
        this.health=100;
        this.currentDir=Direction.RIGHT;
        this.weapon=weapon;
        
        
    }
    
    public void shoot(){
        System.out.println("sparo");
        weapon.shoot(position, currentDir,this.width);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Direction getCurrentDir() {
        return currentDir;
    }

    public void setCurrentDir(Direction currentDir) {
        this.currentDir = currentDir;
    }

    public HashMap<Direction, Image> getImages() {
        return images;
    }

    public void setImages(HashMap<Direction, Image> images) {
        this.images = images;
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
    public boolean isVisible() {
        return visible;
    }

    public void setIsVisible(boolean visible) {
        this.visible = visible;
    }

    
    
     
    
    
    
    
}
