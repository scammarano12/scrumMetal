/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.powerUp;

import game.character.Player;
import game.objects.Weapon;
import java.awt.Point;
import java.awt.event.ActionEvent;
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
public class PlayerWeaponDecoratorTest {
    
    Weapon w;
    public PlayerWeaponDecoratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        w = new Weapon(2);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of actionPerformed method, of class PlayerWeaponDecorator.
     */
    @Test
    public void testActionPerformed() throws InterruptedException {
        System.out.println("actionPerformed");        
        Player p = new Player(new Point(50, 50), 50, 50, "player", w);
        PlayerWeaponDecorator instance = new PlayerWeaponDecorator(p);
        assertEquals(w.getRateo(), 6);
        Thread.sleep(6000);
        assertEquals(w.getRateo(), 2);
    }
    
}
