/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.collisions.Collision;
import game.objects.SolidObject;
import game.scene.Drawable;
import java.awt.Image;
import java.awt.Point;

/**
 *
 * @author SimonePadula
 */
public class WeaponPowerUp extends SolidObject implements Drawable {

    private Image img;
    
    public WeaponPowerUp(Point position, int width, int heigth, String id) {
        super(position, width, heigth, id);
        img = SolidObject.loadImage("src/resources/powerUp/weapon.png");
    }

    public Image getImg() {
        return img;
    }

    public void setCollision(Collision c){
        super.setCollision(c);
        if(c.getSubject().getId().equals("player")){
            PlayerInterface pi = (PlayerInterface) c.getSubject();
            pi = new PlayerWeaponDecorator(pi);
        }
    }
    
    @Override
    public Image getDraw() {
        return img;
    }
    
}
