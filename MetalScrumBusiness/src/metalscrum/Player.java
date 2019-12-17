package metalscrum;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;


/**
 *
 * Software Engineering Group
 */
/**
 *
 * @author albc
 */
public class Player extends Character {
    private final static String rightPlayer="src/resources/playerRight.png";
    private final static String leftPlayer="src/resources/playerLeft.png";
    //private final static String upPlayer="src/resources/playerUp.png";
    //private final static String downPlayer="src/resources/playerDown.png";
    private final static String shootingLeft="src/resources/shootingLeft.png";
    private final static String shootingRight="src/resources/shootingRight.png";
    private int numberOfLife;
    private int playerHealth;
    
    public Player(Point position, int width, int heigth, String id, boolean isVisible, int health, Direction currentDir,Weapon weapon) {
        super(position, width, heigth, id, isVisible, health, currentDir,weapon);    
        images.put(Direction.RIGHT,super.loadImage(rightPlayer));
        images.put(Direction.LEFT,super.loadImage(leftPlayer));
        //images.put(Direction.UP,super.loadImage(upPlayer));
        //images.put(Direction.DOWN,super.loadImage(downPlayer));
        images.put(Direction.SHOOTING_LEFT,super.loadImage(shootingLeft));
        images.put(Direction.SHOOTING_RIGHT,super.loadImage(shootingRight));
        numberOfLife=3;
        playerHealth=health;
        

    }
    

    @Override
    public synchronized void move(int dx, int dy) {
        getPosition().translate(dx, dy);
       
        
    }
    

  
    
    
    public boolean hasLives(){
        
            
            numberOfLife=numberOfLife-1;
            System.out.println(numberOfLife);
            if(numberOfLife>0){
                health=playerHealth;
                return true;
            }
            else
                return false;
        
        
    }
    
    

    @Override
    public Image getDraw() {
        return images.get(currentDir);
        //return getHitbox();
    }
    
    
    
  
    

   
    
}
