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
public class PlayerArmorDecorator implements PlayerInterface,Drawable{
    private PlayerInterface p;
    private Image left;
    private Image right;
    private int maxHealth;
    
    
    private final int multiplier = 3; 
    
    
    public PlayerArmorDecorator(PlayerInterface player){
        player.unDraw();
        maxHealth = player.getMaxHealth();
        right = SolidObject.loadImage("src/resources/powerUp/playerArmorRight.png");
        left  = SolidObject.loadImage("src/resources/powerUp/playerArmorLeft.png");
        int current = player.getMaxHealth() * multiplier;
        //System.out.println("vita con moltiplicatore" + current);
        player.setMaxHealth(current);
        player.setHealth(current);
        //System.out.println("vita che ho settato: " + player.getHealth());
        p = player;
        
        //System.out.println("vita post copia referenza" + p.getHealth());
        this.draw();
    }

    @Override
    public void setState(CharacterState s) {
         p.setState(s);
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

    @Override
    public Point getPosition() {
        return p.getPosition(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAlive() {
        return p.isAlive(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getHealth() {
        return p.getHealth(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Direction getCurrentDir() {
        return p.getCurrentDir();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNumberOfLife() {
        return p.getNumberOfLife();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPosition(Point p) {
        this.p.setPosition(p); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SolidObject getSolidObject() {
        return p.getSolidObject(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Movable getMovable() {
        return p.getMovable();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void shoot() {
        p.shoot();
    }

    @Override
    public Collision getCollision() {
        return p.getCollision(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Bullet> getFiredBullets() {
        return p.getFiredBullets(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void move(int dx, int dy) {
       p.move(dx, dy); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasLives() {
        return p.hasLives(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stopCollision() {
        p.stopCollision(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Weapon getWeapon() {
       return p.getWeapon();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setHealth(int nh) {
        p.setHealth(nh); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getMaxHealth() {
         return p.getMaxHealth();
    }

    @Override
    public void setMaxHealth(int max) {
        p.setMaxHealth(max); //To change body of generated methods, choose Tools | Templates.
    }
    
}
