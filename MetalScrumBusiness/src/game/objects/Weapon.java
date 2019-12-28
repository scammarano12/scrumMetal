/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.objects;
import java.awt.Point;
import game.objects.movable.Direction;

/**
 *long startTime = System.currentTimeMillis();

...
...
// operazioni ...
...
...

long endTime = System.currentTimeMillis();
long seconds = (endTime - startTime) / 1000;
 * @author stefano
 */
public class Weapon {
    
    private int rateo;
    private long time ;
    
    public Weapon(int rateo) {
        this.rateo = rateo;
        time = System.currentTimeMillis();
        
    }
    
    public Bullet shoot(Point position,Direction d,int width,int heigth){
            
            if(System.currentTimeMillis() - time > 1000/rateo){
                time = System.currentTimeMillis() ;
                Bullet b = null;
                if(d == Direction.RIGHT){
                     b = new Bullet(new Point (position.x+width+10,position.y+heigth/2),"bullet",1,d);
                }else if(d == Direction.LEFT){
                     b = new Bullet(new Point (position.x-10,position.y+heigth/2),"bullet",1,d);
                     b.getPosition().translate(-b.getWidth(), 0);
                }
                
                b.draw();
                
                
                return b;
                
                
            }
            return null;
}
      
}
