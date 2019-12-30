/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.character.state.CharacterState;
import game.collisions.Collision;
import game.objects.Bullet;
import game.objects.SolidObject;
import game.objects.Weapon;
import game.objects.movable.Direction;
import game.objects.movable.Movable;
import game.scene.Drawable;
import game.scene.Scene;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;

import java.util.List;

/**
 *
 * @author stefano
 */
public class PlayerArmorDecorator extends PowerUpDecorator implements Drawable{
    
    private Image left;
    private Image right;
    private int maxHealth;
    
    
    private final int multiplier = 3; 
    
    
    public PlayerArmorDecorator(PlayerInterface player){
        super(player);
        player.unDraw();
        maxHealth = player.getMaxHealth();
        right = SolidObject.loadImage("src/resources/powerUp/playerArmorRight.png");
        left  = SolidObject.loadImage("src/resources/powerUp/playerArmorLeft.png");
        int current = player.getMaxHealth() * multiplier;
        //System.out.println("vita con moltiplicatore" + current);
        player.setMaxHealth(current);
        player.setHealth(current);
        //System.out.println("vita che ho settato: " + player.getHealth());
        
        
        //System.out.println("vita post copia referenza" + p.getHealth());
        this.draw();
    }

    

    @Override
    public void draw() {
        Scene.getInstance().addToDraw(this);
    }

    @Override
    public void unDraw() {
        Scene.getInstance().removeFromDraw(this);//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Image getDraw() {
        if(p.isAlive()){
        Image img = p.getDraw();
        BufferedImage armor = new BufferedImage(p.getSolidObject().getWidth(),p.getSolidObject().getHeigth(),BufferedImage.TRANSLUCENT);
        Graphics g = armor.createGraphics();
        
        g.drawImage(img, 0, 0, null);
        if(p.getCurrentDir() == Direction.RIGHT)
            g.drawImage(right, 0, 0, null);
        else if(p.getCurrentDir() == Direction.LEFT)
            g.drawImage(left, 0, 0, null);
        g.dispose();
        return  armor; 
        
        }else {
            this.unDraw();
            p.setMaxHealth(maxHealth);
            p.draw();
            
            return p.getDraw();
            
        }
    }

}
