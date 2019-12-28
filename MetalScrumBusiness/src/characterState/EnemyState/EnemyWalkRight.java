/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characterState.EnemyState;

import characterState.CharacterState;
import java.awt.Image;
import java.util.LinkedList;
import metalscrum.Direction;
import metalscrum.SolidObject;

/**
 *
 * @author stefano
 */
public class EnemyWalkRight extends CharacterState{
    
    public EnemyWalkRight(){
        super.currentDir = Direction.RIGHT;
        super.listImage = new LinkedList<>();
        setAnimation();
        
    }
    
   
    
    private void setAnimation(){
        
        int step = 20;
        Image walking1 = SolidObject.loadImage("src/resources/camminata/nemico1/camminata/1.png");
        Image walking2 = SolidObject.loadImage("src/resources/camminata/nemico1/camminata/2.png");
        Image walking3 = SolidObject.loadImage("src/resources/camminata/nemico1/camminata/3.png");
        Image stop = SolidObject.loadImage("src/resources/fermo/fermoDestra.png");
        
        for(int j = 0;j<=20;j++ ){
            listImage.addFirst(stop);
        }
        
        for(int j = 0;j<=20;j++ ){
            listImage.addLast(walking1);
        }
        for(int j = 0;j<=20;j++ ){
            listImage.addLast(walking2);
        }
        for(int j = 0;j<=20;j++ ){
            listImage.addLast(walking3);
        }
        
    
    }
    @Override
    public Direction getDir() {
        return super.currentDir;
    }

    @Override
    public Image nextImage() {
       Image next = listImage.removeLast();
       listImage.addFirst(next);
       return next;
    }
}
