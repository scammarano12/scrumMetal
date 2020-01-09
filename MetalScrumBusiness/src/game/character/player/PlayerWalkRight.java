/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.character.player;

import game.character.CharacterState;
import java.awt.Image;
import java.util.LinkedList;
import game.objects.movable.Direction;
import game.objects.SolidObject;

/**
 *
 * @author lucap
 */
public class PlayerWalkRight extends CharacterState{

    
    
    public PlayerWalkRight(){
        super.currentDir = Direction.RIGHT;
        super.listImage = new LinkedList<>();
        setAnimation();
        
    }
    
  
    private void setAnimation(){
        
        int step = 20;
        Image walking = SolidObject.loadImage("src/resources/player/camminata/CamminataDestra.png",game.GameSettings.PlayerDimension.width,game.GameSettings.PlayerDimension.height);
        Image stop = SolidObject.loadImage("src/resources/player/fermo/fermoDestra.png",game.GameSettings.PlayerDimension.width,game.GameSettings.PlayerDimension.height);
        for(int j = 0;j<=20;j++ ){
            listImage.addFirst(stop);
        }
        for(int j = 0;j<=20;j++ ){
            listImage.addLast(walking);
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
