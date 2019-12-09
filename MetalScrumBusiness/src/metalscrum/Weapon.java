/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalscrum;
import java.awt.Point;

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
    
    public void shoot(Point position,Direction d,int width){
            
            if(System.currentTimeMillis() - time > 1000/rateo){
                time = System.currentTimeMillis() ;
                Bullet b = null;
                if(d == Direction.RIGHT){
                     b = new Bullet(new Point (position.x+width+1,position.y),3,3,"bullet",true,1,d);
                }else{
                     b = new Bullet(new Point (position.x-1,position.y),3,3,"bullet",true,1,d);
                }
                Drawer.addToDraw(b);
                CollisionSystem.addCollisionSubject(b);
                Thread bt = new Thread(b);
                bt.start();
                
            }
            
        
           
           
    }
    
    

    
    
    
}
