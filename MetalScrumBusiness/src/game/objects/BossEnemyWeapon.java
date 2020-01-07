/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.objects;

import game.objects.movable.Direction;
import java.awt.Point;
import java.util.List;
import javax.swing.text.Position;

/**
 *
 * @author stefano
 */
public class BossEnemyWeapon extends Weapon{
    

    private int shooted;
    
    public BossEnemyWeapon(int rateo) {
        super(rateo);
        shooted = 0;
        time = System.currentTimeMillis();
        
    }
    
    @Override
    public Bullet shoot(Point position,Direction d,int width,int heigth, String id){
       if(System.currentTimeMillis() - time > 1000/rateo){
            Point p = new Point(position.x-10,(shooted+1)*100);
            Bullet lastShooted = new Bullet(p,"bullet"+id,2,Direction.LEFT);
            lastShooted.draw();
            shooted++;
            System.out.println("shooted "+shooted/2);
        
        if(shooted == 3){
            shooted =0;
            
        }
        return lastShooted;
       }
       return null;
    }
    
    
    
    
    
}
