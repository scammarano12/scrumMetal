package game.menu;


import game.GameSettings;
import game.character.PlayerInterface;

import game.objects.SolidObject;
import game.scene.Drawable;
import game.scene.Scene;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.text.Position;

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
    private PlayerInterface p;
    private int health;
    private int lives;
    private Image bar;
    private BufferedImage barLevel;
    private int maxHealth;
    private Image currentBar;
    private Image life;
    public HealthBar(PlayerInterface p){
         maxHealth=4;
        health=0;
        lives =0;
        this.p = p;
        bar = loadImage("src/resources/healthBar/bar.png");
        barLevel = loadImage("src/resources/healthBar/level.png");
        life = loadImage("src/resources/healthBar/life.png");
        life =  life.getScaledInstance(3*life.getWidth(null), 3*life.getHeight(null), Image.SCALE_DEFAULT);
        
        setBarLevel();
        
    }
    @Override
    public synchronized Image getDraw() {
        return setBarLevel();
    }
    
    private synchronized Image setBarLevel(){
        if(health != p.getHealth()){
            maxHealth= p.getMaxHealth();
            System.out.println("costruisco la barra");
            health = p.getHealth();
            lives = p.getNumberOfLife();
            BufferedImage current = new BufferedImage(GameSettings.HealthBarDimension.width+10+lives*(life.getWidth(null)+5),GameSettings.HealthBarDimension.height,BufferedImage.TRANSLUCENT);
            Graphics g = current.createGraphics();
            g.drawImage(barLevel.getSubimage(0, 0,(int)(0.2*bar.getWidth(null)+ 0.8*bar.getWidth(null)/maxHealth*health) , bar.getHeight(null)), 0, 0, null);
            g.drawImage(bar, 0, 0, null);
            for(int i =0; i< lives ;i++){
                g.drawImage(life,bar.getWidth(null)+10 +i*(life.getWidth(null)+5), bar.getHeight(null)/2 -life.getHeight(null)/2 , null);
            }
            g.dispose();
            currentBar = current;
            return current;
            
        }
        else
            return currentBar;
        
    }
    
    
    private BufferedImage loadImage(String imageName) {
        try {
            BufferedImage img = ImageIO.read(new File(imageName));
            
            return img;
            //ImageIcon ii = new ImageIcon(imageName);
        } catch (IOException ex) {
            Logger.getLogger(SolidObject.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        return null;
    }

    @Override
    public synchronized Point getPosition() {
        return new Point(10,10);
    }

    @Override
    public void draw() {
        Scene.getInstance().setBar(this); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void unDraw() {
        Scene.getInstance().setBar(null); //To change body of generated methods, choose Tools | Templates.
    }
    
}
