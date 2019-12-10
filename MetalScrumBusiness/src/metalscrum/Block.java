/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalscrum;

import java.awt.Image;
import java.awt.Point;


/**
 *
 * @author stefano
 */
public class Block extends SolidObject implements Drawable{
    private static final String platform = "src/resources/platform.png";

    public Block(Point position, int width, int heigth, String id, boolean isVisible) {
        super(position, width, heigth, id, isVisible);
        images.put(Direction.RIGHT, super.loadImage(platform));
    }

    @Override
    public Image getDraw() {
        return this.images.get(Direction.RIGHT); //To change body of generated methods, choose Tools | Templates.
        
    }
    
}
