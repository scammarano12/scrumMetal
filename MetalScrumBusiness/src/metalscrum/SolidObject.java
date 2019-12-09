/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalscrum;


import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;
import javax.swing.ImageIcon;


/**
 *
 * @author stefano
 */
public abstract class SolidObject {
    protected Point position;
    protected int width;
    protected int heigth;
    protected String id;
    protected boolean visible;
    protected Collision collision;
    protected HashMap<Direction,Image> images;
    protected Direction currentDir;

    public SolidObject(Point position, int width, int heigth, String id, boolean visible) {
        this.position = position;
        this.width = width;
        this.heigth = heigth;
        this.id = id;
        this.visible = visible;
        this.collision=new Collision(this,null,false,false,false,false);
        this.images=new HashMap<>();
    }
    
    protected Image loadImage(String imageName) {

        ImageIcon ii = new ImageIcon(imageName);
        return ii.getImage();
        
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

    public  Point getPosition() {
        return position;
    }

    public   void setPosition(Point position) {
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

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
  
    
}
