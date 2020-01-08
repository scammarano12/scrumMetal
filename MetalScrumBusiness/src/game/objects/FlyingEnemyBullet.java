/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.objects;

import game.objects.movable.Direction;
import java.awt.Point;

/**
 *
 * @author stefano
 */
public class FlyingEnemyBullet extends Bullet{
    
    public FlyingEnemyBullet(Point position, String id, int damage, Direction d) {
        super(position, id, damage, d);
        bullet = "src/resources/objects/bullet2.png";
        this.image = SolidObject.loadImage(bullet,game.GameSettings.FlyingBulletDimension.width,game.GameSettings.FlyingBulletDimension.height);
    }
    
    
    
    
}
