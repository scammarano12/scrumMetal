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

    private final static String walkingLeft="src/resources/camminata/camminataSinistra.png";
    private final static String stopLeft="src/resources/fermo/fermoSinistra.png";
    
    public PlayerWalkLeft(){
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
        
        int step = 20;
        Image walking = loadImage("src/resources/camminata/CamminataSinistra.png");
        Image stop = loadImage("src/resources/fermo/fermoSinistra.png");
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
