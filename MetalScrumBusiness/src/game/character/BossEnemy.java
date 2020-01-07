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
 * @author stefano
 */
public class BossEnemy extends Enemy{
    
    public BossEnemy(Point position, int width, int heigth, String id, int health, Weapon weapon) {
        super(position, width, heigth, id, health, weapon);
    }
    
    
    
}
