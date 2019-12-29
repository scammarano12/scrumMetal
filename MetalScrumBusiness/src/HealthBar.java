
import game.character.Player;
import game.objects.SolidObject;
import game.scene.Drawable;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucap
 */
public class HealthBar implements Drawable{
    private Player p;
    private int health;
    private int lives;
    private Image bar;
    private Image barLevel;
    public HealthBar(Player p){
        health= p.getHealth();
        lives = p.getNumberOfLife();
        this.p = p;
        bar = loadImage("path");
        barLevel = setBarLevel();
        
    }
    @Override
    public Image getDraw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Image setBarLevel(){
        
    }
    private Image loadImage(String imageName) {
        try {
            Image img = ImageIO.read(new File(imageName));
            
            return img;
            //ImageIcon ii = new ImageIcon(imageName);
        } catch (IOException ex) {
            Logger.getLogger(SolidObject.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        return null;
    }

    @Override
    public Point getPosition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void unDraw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
