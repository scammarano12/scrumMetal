/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.character.enemy;

import game.character.Character;
import java.awt.Point;
import game.collisions.Collision;
import game.objects.SolidObject;
import game.character.Weapon;

/**
 *
 * @author SimonePadula
 */
public class Enemy extends Character {
    
    private long time;
    

    public Enemy(Point position, int width, int height, String id, int health, Weapon weapon) {
        super(position, width, height, id,health, weapon);
        
        time = System.currentTimeMillis();
        
        
    }
    
   
    
    @Override
    public void setCollision(Collision c){
       super.setCollision(c);
       for(SolidObject so : c.getObject()){
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
        
    }
    
    

   

    
    
    
    
}
