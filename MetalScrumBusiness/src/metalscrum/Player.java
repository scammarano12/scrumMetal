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
    private final static String upPlayer="src/resources/playerUp.png";
    private final static String downPlayer="src/resources/playerDown.png";
    
    public Player(Point position, int width, int heigth, String id, boolean isVisible, int health, Direction currentDir,Weapon weapon) {
        super(position, width, heigth, id, isVisible, health, currentDir,weapon);    
        images.put(Direction.RIGHT,loadImage(rightPlayer));
        images.put(Direction.LEFT,loadImage(leftPlayer));
        images.put(Direction.UP,loadImage(upPlayer));
        images.put(Direction.DOWN,loadImage(downPlayer));
        

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
    public Rectangle getDraw() {
        //return images.get(currentDir);
        return getHitbox();
    }
    
  
    

   
    
}
