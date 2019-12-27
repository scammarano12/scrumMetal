/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characterState.playerState;

import characterState.CharacterState;
import java.awt.Image;
import java.util.LinkedList;
import metalscrum.Direction;
import metalscrum.SolidObject;

/**
 *
 * @author lucap
 */
public class PlayerStopLeft extends CharacterState{

    private final static String stopLeft="src/resources/fermo/fermoSinistra.png";
    
    public PlayerStopLeft(){
        super.currentDir = Direction.LEFT;
        super.listImage = new LinkedList<>();
        setAnimation();
        
    }
    
    
    
    private void setAnimation(){
        
       
        Image stop = SolidObject.loadImage("src/resources/fermo/fermoSinistra.png");
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

