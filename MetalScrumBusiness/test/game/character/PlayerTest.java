/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.character;

import game.objects.Weapon;
import game.objects.SolidObject;
import game.objects.movable.Movable;
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
public class PlayerTest {
    
    private Player instance;
    
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
        //Per test: testGetMaxHealth1()
        instance = new Player(new Point(50,50), 40, 36, "player",new Weapon(2));
        instance.setMaxHealth(12);
    }
    
    @After
    public void tearDown() {
    
    }

    
    
    /**
     * Test of getMaxHealth method, of class Player.
     */
    @Test
    public void testGetMaxHealth() {
        System.out.println("getMaxHealth");
        Player instance1 = new Player(new Point(50,50), 40, 36, "player",new Weapon(2));
        int expResult = 4;
        int result = instance1.getMaxHealth();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMaxHealth method, of class Player.
     */
    @Test
    public void testSetMaxHealth() {
        System.out.println("setMaxHealth");
        Player instance2 = new Player(new Point(50,50), 40, 36, "player",new Weapon(2));
        int max = 8;
        instance2.setMaxHealth(max);
        assertEquals(max, instance2.getMaxHealth());
    }
    
    /**
     * Test of getMaxHealth method, of class Player.
     */
    @Test
    public void testGetMaxHealth1() {
        System.out.println("getMaxHealth after setMaxHealt (for PowerUp) in setUp()");
        
        int expResult = 12;
        int result = instance.getMaxHealth();
        assertEquals(expResult, result);
    }


    
    
    
    /**
     * Test of hasLives method, of class Player.
     */
    @Test
    public void testHasLives() {
        System.out.println("hasLives");
        Player instance3 = new Player(new Point(50,50), 40, 36, "player",new Weapon(2));
        boolean expResult = true;
        boolean result = instance3.hasLives();
        
        assertEquals(expResult, result);
       
    }
    
    @Test
    public void testHasLives1() {
        System.out.println("hasLives");
        Player instance4 = new Player(new Point(50,50), 40, 36, "player",new Weapon(2));
        boolean expResult = false;
        boolean result;
        instance4.hasLives();
        instance4.hasLives();
        result = instance4.hasLives();
        
        assertEquals(expResult, result);
       
    }
    
    @Test
    public void testHasLives2() {
        System.out.println("hasLives");
        Player instance4 = new Player(new Point(50,50), 40, 36, "player",new Weapon(2));
        boolean expResult = false;
        boolean result;
        result = instance4.hasLives();
        result = instance4.hasLives();
        result = instance4.hasLives();
        //anche se (per errore) andasse a un numero di vite < 0, il test ci dice che funziona ugualmente, ovvero non ha più vite!
        result = instance4.hasLives();
        result = instance4.hasLives();
        
        assertEquals(expResult, result);
       
    }
    

    /**
     * Test of getNumberOfLife method, of class Player.
     */
    @Test
    public void testGetNumberOfLife() {
        System.out.println("getNumberOfLife");
        Player instance5 = new Player(new Point(50,50), 40, 36, "player",new Weapon(2));
        int expResult = 1;
        instance5.hasLives();
        instance5.hasLives();
        int result = instance5.getNumberOfLife();
        assertEquals(expResult, result);
    }

    
//  NON OCCORRONO I SEGUENTI TEST:  
//
//
//    /**
//     * Test of getSolidObject method, of class Player.
//     */
//    @Test
//    public void testGetSolidObject() {
//        System.out.println("getSolidObject");
//        Player instance = null;
//        SolidObject expResult = null;
//        SolidObject result = instance.getSolidObject();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getMovable method, of class Player.
//     */
//    @Test
//    public void testGetMovable() {
//        System.out.println("getMovable");
//        Player instance = null;
//        Movable expResult = null;
//        Movable result = instance.getMovable();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
    
}
