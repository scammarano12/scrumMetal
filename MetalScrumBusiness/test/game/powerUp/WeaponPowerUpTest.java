/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.powerUp;

import game.character.Player;
import game.collisions.Collision;
import game.collisions.CollisionController;
import game.objects.Weapon;
import java.awt.Image;
import java.awt.Point;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Francesco Sabbarese
 */
public class WeaponPowerUpTest {
    Player p;
    WeaponPowerUp wp;
    CollisionController cc;
    public WeaponPowerUpTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        p = new Player(new Point( 50, 50), 50, 50, "player", new Weapon(2));
        wp = new WeaponPowerUp(new Point( 49, 49), 5, 5, "weaponPowerUp");
        
        cc = CollisionController.getInstance();
        cc.addObject(wp);
        cc.addSubject(p);
        cc.checkCollision();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setCollision method, of class WeaponPowerUp.
     */
    @Test
    public void testSetCollision() {
        System.out.println("setCollision");
        Player player = new Player(new Point( 50, 50), 50, 50, "player", new Weapon(2));
        WeaponPowerUp instance = new WeaponPowerUp(new Point( 49, 49), 5, 5, "weaponPowerUp");   
        cc = CollisionController.getInstance();
        cc.addObject(instance);
        cc.addSubject(player);
        cc.checkCollision();
        
        assertNotEquals(instance.getCollision().getObject(), wp.getCollision().getObject());
        assertNotEquals(instance.getCollision().getSubject(), wp.getCollision().getSubject());
    }

}
