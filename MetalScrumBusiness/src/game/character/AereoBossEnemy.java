/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.character;

import game.objects.Weapon;
import java.awt.Point;

/**
 *
 * @author lucap
 */
public class AereoBossEnemy extends Enemy {
    
    public AereoBossEnemy(Point position, int width, int height, String id, int health, Weapon weapon) {
        super(position, width, height, id, health, weapon);
    }
    
}
