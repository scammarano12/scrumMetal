/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalscrum;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


/**
 *
 * @author stefano
 */
public class Block extends SolidObject implements Drawable{
    private static final String platform = "src/resources/platform.png";

    public Block(Point position, int width, int heigth, String id) {
        super(position, width, heigth, id);
        image = SolidObject.loadImage(platform);
    }

    
    @Override
    public Image getDraw() {
        int imagesCount = width/40;
    
         
       
           
        BufferedImage images1[] = new BufferedImage[imagesCount];
        for(int j = 0; j < images1.length; j++) {
            images1[j] = new BufferedImage(40, 24, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = images1[j].createGraphics();
            
            g2d.drawImage(image,0, 0, 40, heigth, null);
            g2d.dispose();
        } 
        
        int widthTotal = 0;
        for(int j = 0; j < images1.length; j++) {
            widthTotal += images1[j].getWidth();
        }
        
        int widthCurr = 0;
        BufferedImage concatImage = new BufferedImage(widthTotal, heigth, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = concatImage.createGraphics();
     
        for(int j = 0; j < images1.length; j++) {
            g2d.drawImage(images1[j],widthCurr, 0, 40, heigth, null);
            widthCurr += images1[j].getWidth();
        }
        g2d.dispose();
        
        return concatImage;
        
        
        
    }

}
