/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.character.player;

import game.character.CharacterState;
import game.objects.SolidObject;
import game.objects.movable.Direction;
import java.awt.Image;
import java.util.LinkedList;

/**
 *
 * @author stefano
 */
public class PlayerArmoredState extends CharacterState{
    
    public PlayerArmoredState(){
        super.currentDir = Direction.LEFT;
        super.listImage = new LinkedList<>();
        setAnimation();
        
    }
    
   
    
    private void setAnimation(){
        
        int step = 5;
        
        Image armor1 = SolidObject.loadImage("src/resources/player/camminata/CamminataSinistra.png",game.GameSettings.PlayerDimension.width,game.GameSettings.PlayerDimension.height);
        Image armor2 = SolidObject.loadImage("src/resources/player/fermo/fermoSinistra.png",game.GameSettings.PlayerDimension.width,game.GameSettings.PlayerDimension.height);
        for(int j = 0;j<=step;j++ ){
            listImage.addFirst(armor1);
        }
        for(int j = 0;j<=step;j++ ){
            listImage.addLast(armor2);
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
