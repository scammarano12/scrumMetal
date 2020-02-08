/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.charater.player.powerUp;

import game.character.player.PlayerInterface;
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
    
    public WeaponPowerUp(Point position, int width, int height, String id) {
        super(position, width, height, id);
        image = SolidObject.loadImage("src/resources/powerUp/weapon.png",game.GameSettings.WeaponPowerUp.width,game.GameSettings.WeaponPowerUp.height);
    }


    @Override
    public void setCollision(Collision c){
        super.setCollision(c);
        if(c.getSubject().getId().equals("player")){
            this.unDraw();
            this.stopCollision();
            PlayerInterface pi = (PlayerInterface) c.getSubject();
            pi = new PlayerWeaponDecorator(pi);
        }
    }
    
    
    @Override
    public Image getDraw() {
        return image;
    }
    
}
