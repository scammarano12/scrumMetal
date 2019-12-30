/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.character.state.CharacterState;
import game.character.state.playerState.PlayerArmoredState;
import game.collisions.Collision;
import game.objects.Bullet;
import game.objects.SolidObject;
import game.objects.Weapon;
import game.objects.movable.Direction;
import game.objects.movable.Movable;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Timer;

/**
 *
 * @author SimonePadula
 */
public class PlayerWeaponDecorator extends PowerUpDecorator implements ActionListener {

    private PlayerInterface p;
    private int rateoMultiplier;
    private Weapon weapon;
    private int currentRateo;
    private Timer timer;
    
    public PlayerWeaponDecorator(PlayerInterface p) {
       super(p);
        this.p = p;
        rateoMultiplier = 3;
        weapon = p.getWeapon();
        currentRateo = weapon.getRateo();
        weapon.setRateo(currentRateo*rateoMultiplier);
        this.timer = new Timer(5000, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == timer){
            weapon.setRateo(currentRateo);
        }
    }
    

   
    
}
