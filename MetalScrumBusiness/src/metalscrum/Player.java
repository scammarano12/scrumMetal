package metalscrum;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.LinkedList;


/**
 *
 * Software Engineering Group
 */
/**
 *
 * @author albc
 */
public class Player extends Character {
 
    private int numberOfLife;
    private int playerHealth;
    
    public Player(Point position, int width, int heigth, String id, Weapon weapon) {
        super(position, width, heigth, id, 4, weapon );  
        numberOfLife=3;
        playerHealth=4;
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

}
