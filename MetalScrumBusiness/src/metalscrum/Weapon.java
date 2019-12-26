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
        this.time = System.currentTimeMillis();
        System.out.println("Time "+time);
    }
    
    public Bullet shoot(Point position,Direction d,int width,int heigth){
            
            if(System.currentTimeMillis() - time > 1000/rateo){
                System.out.println("time2: "+time);
                System.out.println("System.currentTimeMillis: "+System.currentTimeMillis());
                time = System.currentTimeMillis() ;
                Bullet b = null;
                if(d == Direction.SHOOTING_RIGHT){
                    b = new Bullet(new Point (position.x+width+10,position.y+heigth/2),57,19,"bullet",true,1,d);
                }else if(d == Direction.SHOOTING_LEFT){
                    b = new Bullet(new Point (position.x-49-10,position.y+heigth/2),49,19,"bullet",true,1,d);
                }
                
                Drawer.addToDraw(b);
                CollisionSystem.addCollisionObject(b);
                
                return b;
                
                
            }
            return null;
}
      
}
