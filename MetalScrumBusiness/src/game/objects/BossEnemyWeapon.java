/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.objects;

import game.objects.movable.Direction;
import java.awt.Point;
import java.util.List;
import java.util.Random;
import javax.swing.text.Position;

/**
 *
 * @author stefano
 */
public class BossEnemyWeapon extends Weapon{
    

    private int shooted;
    private int last;
    private boolean first;
    public BossEnemyWeapon(int rateo) {
        super(rateo);
        last=0;
        first=true;
        time = System.currentTimeMillis();
        
    }
    
    @Override
    public Bullet shoot(Point position,Direction d,int width,int height, String id){
       Random rand = new Random();
       int f;
           if (first){
               
               last=5+3*rand.nextInt(2);
               System.out.println(last);
                
               first=false;
                
                
           }else{
               if(last==5){
                   last=2;
               }
               else if(last==8)
                   last=2;
               first=true;
           }
                f=height/10*last;
                Point p = new Point(position.x-game.GameSettings.BulletDimension.width-1,position.y+f);
                Bullet lastShooted = new Bullet(p,"bullet"+id,2,Direction.LEFT);

                //System.out.println(f);
                lastShooted.draw();
        return lastShooted;
       
    }
    
    
    
    
    
}
