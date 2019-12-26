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
public class PlayerStopRight extends CharacterState{

    private final static String stopRight="src/resources/fermo/fermoDestra.png";
    
    public PlayerStopRight(){
        super.currentDir = Direction.RIGHT;
        super.listImage = new LinkedList<>();
        setAnimation();
        
    }
    
   
    
    private void setAnimation(){
        
       
        Image stop = SolidObject.loadImage("src/resources/fermo/fermoDestra.png");
        listImage.add(stop);
        
    
    }
    @Override
    public Direction getDir() {
        return super.currentDir;
    }

    @Override
    public Image nextImage() {
       return listImage.getFirst();    }
    
}

