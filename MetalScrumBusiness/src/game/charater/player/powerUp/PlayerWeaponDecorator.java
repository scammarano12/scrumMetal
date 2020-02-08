/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.charater.player.powerUp;

import game.character.player.PlayerInterface;
import game.character.Weapon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
