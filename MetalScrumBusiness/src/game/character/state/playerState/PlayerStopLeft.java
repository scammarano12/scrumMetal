/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.character.state.playerState;


import game.character.state.CharacterState;
import java.awt.Image;
import java.util.LinkedList;
import game.objects.movable.Direction;
import game.objects.SolidObject;

/**
 *
 * @author lucap
 */
public class PlayerStopLeft extends CharacterState{

    
    
    public PlayerStopLeft(){
        super.currentDir = Direction.LEFT;
        super.listImage = new LinkedList<>();
        setAnimation();
        
    }
    
    
    
    private void setAnimation(){
        
       
        Image stop = SolidObject.loadImage("src/resources/player/fermo/fermoSinistra.png",game.GameSettings.PlayerDimension.width,game.GameSettings.PlayerDimension.height);
        listImage.add(stop);
        
        
    
    }
    @Override
    public Direction getDir() {
        return super.currentDir;
    }

    @Override
    public Image nextImage() {
       return listImage.getFirst();
    }
    
}

