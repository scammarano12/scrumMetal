/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalscrum;

import java.awt.Point;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SimonePadula
 */
public class WeaponTest {
    
    public WeaponTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of shoot method, of class Weapon.
     */
    @Test
    public void testShoot() {
        System.out.println("shoot");
        Point position = new Point(40, 60);
        Direction d = Direction.SHOOTING_RIGHT;
        int width = 20;
        int heigth = 30;
        Weapon instance = new Weapon(2);
        Bullet expResult = new Bullet(new Point(position.x+width+10, position.y+heigth/2),57,19,"bullet",true,1,d);
        Bullet result = instance.shoot(position, d, width, heigth);
        assertEquals(expResult, result);
    }

}
