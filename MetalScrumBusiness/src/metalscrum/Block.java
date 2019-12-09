/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalscrum;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author stefano
 */
public class Block extends SolidObject implements Drawable{

    public Block(Point position, int width, int heigth, String id, boolean isVisible) {
        super(position, width, heigth, id, isVisible);
    }

    @Override
    public Rectangle getDraw() {
        //return this.images.get(currentDir); //To change body of generated methods, choose Tools | Templates.
        return getHitbox();
    }
    
}
