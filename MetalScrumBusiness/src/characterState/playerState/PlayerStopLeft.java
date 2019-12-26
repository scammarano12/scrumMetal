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
public class PlayerStopLeft extends CharacterState{

    private final static String stopLeft="src/resources/fermo/fermoSinistra.png";
    
    public PlayerStopLeft(){
        super.currentDir = Direction.LEFT;
        super.listImage = new LinkedList<>();
        setAnimation();
        
    }
    
    protected Image loadImage(String imageName) {
        try {
            Image img = ImageIO.read(new File(imageName));
            
            img = img.getScaledInstance(4*img.getWidth(null), 4*img.getHeight(null), Image.SCALE_DEFAULT);
            return img;
            //ImageIcon ii = new ImageIcon(imageName);
        } catch (IOException ex) {
            Logger.getLogger(SolidObject.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        return null;
    }
    
    private void setAnimation(){
        
       
        Image stop = loadImage("src/resources/fermo/fermoSinistra.png");
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

