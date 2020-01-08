/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.objects;

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
import game.scene.Drawable;
import game.GameSettings;


/**
 *
 * @author stefano
 */
public class Block extends SolidObject implements Drawable{
    private String platform ;

    public Block(Point position, int width, int height, String id,String s) {
        super(position, width, height, id);
        
        
        image = blockloadImage(s);
        buildImage();
        
    }
    
    
    private Image blockloadImage(String s){
        try {
            return ImageIO.read(new File(s));
        } catch (IOException ex) {
            Logger.getLogger(Block.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public void buildImage(){
        //System.out.println("build");
        int imagesCount = width/GameSettings.BlockDimension.width;
    
         
       
           
        BufferedImage images1[] = new BufferedImage[imagesCount];
        for(int j = 0; j < images1.length; j++) {
            images1[j] = new BufferedImage(GameSettings.BlockDimension.width, GameSettings.BlockDimension.height, BufferedImage.TRANSLUCENT);
            Graphics2D g2d = images1[j].createGraphics();
            
            g2d.drawImage(image,0, 0, GameSettings.BlockDimension.width, height, null);
            g2d.dispose();
        } 
        
        int widthTotal = 0;
        for(int j = 0; j < images1.length; j++) {
            widthTotal += images1[j].getWidth();
        }
        
        int widthCurr = 0;
        BufferedImage concatImage = new BufferedImage(widthTotal, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = concatImage.createGraphics();
     
        for(int j = 0; j < images1.length; j++) {
            g2d.drawImage(images1[j],widthCurr, 0, GameSettings.BlockDimension.width, height, null);
            widthCurr += images1[j].getWidth();
        }
        g2d.dispose();
        
        image = concatImage;
    
    }

    
    @Override
    public Image getDraw() {
        return image;
  
    }
    
    
    public void setString(String s){
        platform = s;
    }

}
