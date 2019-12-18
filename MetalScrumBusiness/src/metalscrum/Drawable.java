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
public interface Drawable {
    public Image getDraw();
    public Point getPosition();
    public void draw();
    public void unDraw();
    
}
