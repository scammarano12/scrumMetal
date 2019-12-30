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
import java.awt.Image;
import java.awt.Point;
import java.util.List;

/**
 *
 * @author stefano
 */
public class PlayerArmorDecorator implements PlayerInterface{
    private PlayerInterface p;
    private int resistanceMultiplier;
    
    
    public PlayerArmorDecorator(PlayerInterface p){
        this.p = p;
        resistanceMultiplier = 3;
        p.setHealth(resistanceMultiplier*p.getHealth());
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
        p.unDraw();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Image getDraw() {
       return  p.getDraw(); //To change body of generated methods, choose Tools | Templates.
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
    
}
