/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.charater.player.powerUp;

import game.character.player.PlayerInterface;
import game.character.player.PlayerArmoredState;
import game.collisions.Collision;
import game.objects.SolidObject;
import game.scene.Drawable;
import java.awt.Image;
import java.awt.Point;

/**
 *
 * @author Salvatore Reina
 */
public class ArmorPowerUp extends SolidObject implements Drawable {
       private final int  animation = 20;
       private int  count;
    public ArmorPowerUp(Point position, int width, int height, String id) {
        super(position, width, height, id);
        image = SolidObject.loadImage("src/resources/powerUp/armor.png",game.GameSettings.ArmorPowerUp.width,game.GameSettings.ArmorPowerUp.height); 
        count=0;
    }

    @Override
    public Image getDraw() {
       
        
         
        return image; //To [change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void setCollision(Collision c){
       
        if(c.getSubject().getId().equals("player") ){
            this.unDraw();
            this.stopCollision();
            PlayerInterface p = (PlayerInterface) c.getSubject();
            p = new PlayerArmorDecorator(p);
         }
    }
    
    
}
