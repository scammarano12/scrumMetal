/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characterState.playerState;

import characterState.CharacterState;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import metalscrum.Direction;
import metalscrum.SolidObject;

/**
 *
 * @author lucap
 */
public class PlayerWalkLeft extends CharacterState{

    
    
    public PlayerWalkLeft(){
        super.currentDir = Direction.LEFT;
        super.listImage = new LinkedList<>();
        setAnimation();
        
    }
    
   
    
    private void setAnimation(){
        
        int step = 20;
        Image walking = SolidObject.loadImage("src/resources/camminata/CamminataSinistra.png");
        Image stop = SolidObject.loadImage("src/resources/fermo/fermoSinistra.png");
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
