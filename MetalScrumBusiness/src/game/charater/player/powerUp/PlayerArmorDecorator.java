/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.charater.player.powerUp;

import game.character.player.PlayerInterface;
import game.character.CharacterState;
import game.collisions.Collision;
import game.character.Bullet;
import game.objects.SolidObject;
import game.character.Weapon;
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
 * @author  Salvatore Reina
 */
public class PlayerArmorDecorator extends PowerUpDecorator implements Drawable{
    
    private Image left;
    private Image right;
    private int maxHealth;
    private PlayerInterface p;
    
    
    private final int multiplier = 3; 
    
    
    public PlayerArmorDecorator(PlayerInterface player){
        super(player);
        this.p = player;
        player.unDraw();
        maxHealth = player.getMaxHealth();
        right = SolidObject.loadImage("src/resources/powerUp/playerArmorRight.png",game.GameSettings.PlayerArmorDecorator.width,game.GameSettings.PlayerArmorDecorator.height);
        left  = SolidObject.loadImage("src/resources/powerUp/playerArmorLeft.png",game.GameSettings.PlayerArmorDecorator.width,game.GameSettings.PlayerArmorDecorator.height);
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
        BufferedImage armor = new BufferedImage(p.getSolidObject().getWidth(),p.getSolidObject().getHeight(),BufferedImage.TRANSLUCENT);
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
