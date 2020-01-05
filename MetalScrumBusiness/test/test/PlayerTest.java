/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;
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
public class PlayerTest {
    
    public PlayerTest() {
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
     * Test of move method, of class Player.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        int dx = 1;
        int dy = -15;
        Player instance = new Player(new Point(50,150),50,45,"player",true,100,Direction.RIGHT,new Weapon(2));
        instance.move(dx, dy);
        
        int expX = 51;
        int expY = 135;
        assertEquals(expX, instance.getPosition().x);
        assertEquals(expY, instance.getPosition().y);
    }

    /**
     * Test of getDraw method, of class Player.
     */
    @Test
    public void testGetDrawRight() {
        System.out.println("getDraw");
        Player instance = new Player(new Point(50,150),50,45,"player",true,100,Direction.RIGHT,new Weapon(2));
        
        ImageIcon ii = new ImageIcon("src/resources/playerRight.png");
        Image expResult = ii.getImage();
        
        Image result = instance.getDraw();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetDrawLeft() {
        System.out.println("getDraw");
        Player instance = new Player(new Point(50,150),50,45,"player",true,100,Direction.LEFT,new Weapon(2));
        
        ImageIcon ii = new ImageIcon("src/resources/playerLeft.png");
        Image expResult = ii.getImage();
        
        Image result = instance.getDraw();
        assertEquals(expResult, result);
    }
    
}
