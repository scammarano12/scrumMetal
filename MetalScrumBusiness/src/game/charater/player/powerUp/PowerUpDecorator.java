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
import java.awt.Image;
import java.awt.Point;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.List;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author SimonePadula
 */
public class PowerUpDecorator implements PlayerInterface{
    private PlayerInterface p;
    private Clip sound ;
    
    public PowerUpDecorator(PlayerInterface p){
        this.p = p;
        initMusic();
    }
    
    public  void initMusic() {
        try {
            sound = AudioSystem.getClip();
           
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("src/resources/powerUp/powerup.wav")));
             BufferedInputStream bf = new BufferedInputStream(inputStream);
            
             inputStream = new AudioInputStream(bf,inputStream.getFormat(),inputStream.getFrameLength());
             sound.open(inputStream);
             
             sound.start();
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    
    }
    
     @Override
    public void setState(CharacterState s) {
        p.setState(s);
    }

    @Override
    public void draw() {
        p.draw();
    }

    @Override
    public void unDraw() {
        p.unDraw();
    }

    @Override
    public Image getDraw() {
        return p.getDraw();
    }

    @Override
    public Point getPosition() {
        return p.getPosition();
    }

    @Override
    public boolean isAlive() {
        return p.isAlive();
    }

    @Override
    public int getHealth() {
        return p.getHealth();
    }

    @Override
    public Direction getCurrentDir() {
        return p.getCurrentDir();
    }

    @Override
    public int getNumberOfLife() {
        return p.getNumberOfLife();
    }

    @Override
    public void setPosition(Point p) {
        this.p.setPosition(p);
    }

    @Override
    public SolidObject getSolidObject() {
        return p.getSolidObject();
    }

    @Override
    public Movable getMovable() {
        return p.getMovable();
    }

    @Override
    public void shoot() {
        p.shoot();
    }

    @Override
    public Collision getCollision() {
        return p.getCollision();
    }

    @Override
    public List<Bullet> getFiredBullets() {
        return p.getFiredBullets();
    }

    @Override
    public void move(int dx, int dy) {
        p.move(dx, dy);
    }

    @Override
    public boolean hasLives() {
        return p.hasLives();
    }

    @Override
    public void stopCollision() {
        p.stopCollision();
    }

    @Override
    public Weapon getWeapon() {
        return p.getWeapon();
    }

    @Override
    public void setHealth(int nh) {
         p.setHealth(nh);
    }

    

    @Override
    public int getMaxHealth() {
       return p.getMaxHealth();
    }

    @Override
    public void setMaxHealth(int max) {
       p.setHealth(max); 
    }
    
}
