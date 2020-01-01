/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.objects;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import game.collisions.Collision;
import game.collisions.CollisionController;
import game.objects.movable.Direction;
import game.scene.Drawable;
import game.scene.Scene;


/**
 *
 * @author stefano
 */
public abstract class SolidObject implements Drawable {
    protected Point position;
    protected int width;
    protected int heigth;
    protected String id;
    protected Collision collision;
    protected Image image;
    protected Direction currentDir;
    

    public SolidObject(Point position, int width, int heigth, String id) {
        this.position = position;
        this.width = width;
        this.heigth = heigth;
        this.id = id;
        this.collision=new Collision(this,null,false,false,false,false);
    }
    

    
    public static Image loadImage(String imageName) {
        try {
            Image img = ImageIO.read(new File(imageName));
            img = img.getScaledInstance(2*img.getWidth(null), 2*img.getHeight(null), 0);
            return img;
            //ImageIcon ii = new ImageIcon(imageName);
        } catch (IOException ex) {
            Logger.getLogger(SolidObject.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        return null;
    }

   
    public Rectangle getHitbox(){
        return new Rectangle(position.x,position.y,width,heigth);
    }
    
    
    public void setCollision(Collision collision){
        this.collision=collision;
    }
    public  Collision getCollision(){
        return collision;
    } 

    @Override
    public synchronized Point getPosition() {
        return position;
    }

    public synchronized void setPosition(Point position) {
        this.position = position;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public  int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    public void activeCollision() {
        CollisionController.getInstance().addObject(this);
    }

 
    public void stopCollision() {
       CollisionController.getInstance().removeObject(this); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void draw() {
        Scene.getInstance().addToDraw(this);
    }

    @Override
    public void unDraw() {
        Scene.getInstance().removeFromDraw(this);
    }

    @Override
    public abstract Image getDraw();
    
    
 
}
