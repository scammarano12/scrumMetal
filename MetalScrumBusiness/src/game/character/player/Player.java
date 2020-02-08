package game.character.player;

import game.character.Character;
import game.objects.SolidObject;
import java.awt.Point;
import game.character.Weapon;
import game.objects.movable.Movable;



/**
 *
 * Software Engineering Group
 */
/**
 *
 * @author albc
 */
public class Player extends Character implements PlayerInterface {
 
    private int numberOfLife;
    private int playerHealth;
    
    public Player(Point position, int width, int height, String id, Weapon weapon) {
        super(position, width, height, id, 4, weapon );  
        numberOfLife=5;
        playerHealth=4;
    }

    
    @Override
    public synchronized int getMaxHealth(){
        return playerHealth;
    }
    
    @Override
    public synchronized void setMaxHealth(int max){
        playerHealth=max;
    }
    
  

    
    @Override
    public boolean hasLives(){
        
            
            numberOfLife=numberOfLife-1;
            
            if(numberOfLife>0){
                health=playerHealth;
                return true;
            }
            else
                return false;
        
        
    }
    
    @Override
    public int getNumberOfLife(){
        return numberOfLife;
    }

    @Override
    public SolidObject getSolidObject() {
        return (SolidObject) this; 
    }

    @Override
    public Movable getMovable() {
        return (Movable) this; //To change body of generated methods, choose Tools | Templates.
    }

    

   
   
  
}
