/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.character;

import game.character.enemy.Enemy;
import game.objects.SolidObject;
import game.objects.movable.Direction;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author stefano
 */
public class FlyingEnemy extends Enemy {
    private LinkedList<Image> helicopter;
   
    public FlyingEnemy(Point position, int width, int height, String id, int health, Weapon weapon) {
        super(position, width, height, id, health, weapon);
         helicopter = new LinkedList<>();
        initAnimation(2);
       
       
        
        
    }
    
    private void initAnimation(int step){
        for(int i =1 ;i<12 ;i++){
             
            
            Image animation = SolidObject.loadImage("./src/resources/nemicovolante/"+i+".png",game.GameSettings.FlyingEnemyDimension.width,game.GameSettings.FlyingEnemyDimension.height);
            for(int a = 0 ; a < step; a++){
                
                helicopter.addFirst(animation);
            }
            
            
        }
        

        
    }
    
    @Override
    public void shoot(){
        Bullet b = weapon.shoot(position, Direction.DOWN,this.width,this.height,this.getId());
        if(b!=null)
            bullets.add(b);
        
    }
    
    @Override
    public Image getDraw(){
        Image actual = state.nextImage();
        BufferedImage completeSkin = new BufferedImage(this.width,this.height,BufferedImage.TRANSLUCENT);
        Graphics g = completeSkin.createGraphics();
        Image img = helicopter.removeLast();
        helicopter.addFirst(img);
        g.drawImage(img, 0, 0, null);
        g.drawImage(actual,0,0,null);
        g.dispose();
        return completeSkin;
        
    }
    
    public void move(int dx,int dy){
        super.move(dx, 0);
        
    }
    
    
    
}
