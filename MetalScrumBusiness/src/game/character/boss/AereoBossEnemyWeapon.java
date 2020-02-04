/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.character.boss;

import game.character.Bullet;
import game.character.flyingenemy.FlyingEnemyBullet;
import game.character.Weapon;
import game.objects.movable.Direction;
import java.awt.Point;

/**
 *
 * @author luca pomposelli 
 */
public class AereoBossEnemyWeapon extends Weapon {
    

 private int shooted;
    
    public AereoBossEnemyWeapon(int rateo) {
        super(rateo);
        shooted = 0;
        time = System.currentTimeMillis();
        
    }
    
    @Override
    public Bullet shoot(Point position,Direction d,int width,int height, String id){
       
           
            int f = (game.GameSettings.FrameDimension.width/7) * (1+shooted);
            Point p = new Point(f,5);
            //Point p = new Point(position.x-game.GameSettings.BulletDimension.width-1,position.y+f);
            FlyingEnemyBullet lastShooted = new FlyingEnemyBullet(p,"bullet"+id,2,Direction.DOWN);
            
            System.out.println(f);
            lastShooted.draw();
            shooted++;
            System.out.println("shooted "+shooted);
        
        if(shooted == 5){
            shooted =0;
            
        }
        return lastShooted;
       
       
    }
      
    
}
