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
    
    public Bullet shoot(Point position,Direction d,int width,int heigth){
            
            if(System.currentTimeMillis() - time > 1000/rateo){
                time = System.currentTimeMillis() ;
                Bullet b = null;
                if(d == Direction.SHOOTING_RIGHT){
                     b = new Bullet(new Point (position.x+width+10,position.y+heigth/2),57,19,"bullet",true,1,d);
                }else if(d == Direction.SHOOTING_LEFT){
                     b = new Bullet(new Point (position.x-49-10,position.y+heigth/2),49,19,"bullet",true,1,d);
                }
                
                b.draw();
                
                
                return b;
                
                
            }
            return null;
}
      
}
