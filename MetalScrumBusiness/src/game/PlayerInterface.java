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
public interface PlayerInterface {
    public void setState(CharacterState s);
    public void draw();
    public void unDraw();
    public Image getDraw();
    public Point getPosition();
    public boolean isAlive();
    public int getHealth();
    public Direction getCurrentDir();
    public int getNumberOfLife();
    public void setPosition(Point p);
    public SolidObject getSolidObject();
    public Movable getMovable();
    public void shoot();
    public Collision getCollision();
    public List<Bullet> getFiredBullets();
    public void move(int dx, int dy);
    public boolean hasLives();
    public void stopCollision();
    public Weapon getWeapon();
    
}
