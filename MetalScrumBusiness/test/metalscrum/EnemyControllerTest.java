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
 * @author Francesco Sabbarese
 */
public class EnemyControllerTest {

    private Enemy enemy;

    public EnemyControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        enemy = new Enemy(new Point(50, 150), 50, 45, "enemy", true, 100, Direction.RIGHT, new Weapon(2));

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getRangeMin method, of class EnemyController.
     */
    @Test
    public void testGetRangeMin() {
        System.out.println("getRangeMin");
        EnemyController instance = new EnemyController(100, 300);
        int expResult = 100;
        int result = instance.getRangeMin();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRangeMin method, of class EnemyController.
     */
    @Test
    public void testSetRangeMin() {
        System.out.println("setRangeMin");
        int rangeMin = 200;
        EnemyController instance = new EnemyController(100, 300);
        instance.setRangeMin(200);

        assertEquals(rangeMin, instance.getRangeMin());
    }

    /**
     * Test of getRangeMax method, of class EnemyController.
     */
    @Test
    public void testGetRangeMax() {
        System.out.println("getRangeMax");
        EnemyController instance = new EnemyController(100, 300);
        int expResult = 300;
        int result = instance.getRangeMax();
        assertEquals(expResult, result);

    }

    /**
     * Test of setRangeMax method, of class EnemyController.
     */
    @Test
    public void testSetRangeMax() {
        System.out.println("setRangeMax");
        int rangeMax = 300;
        EnemyController instance = new EnemyController(100, 400);
        instance.setRangeMax(300);
        assertEquals(rangeMax, instance.getRangeMax());

    }

    /**
     * Test of updatePositions method, of class EnemyController.
     */
    @Test
    public void testUpdatePositionsLeft() {
        System.out.println("updatePositions");
        enemy.setCurrentDir(Direction.LEFT);
        EnemyController instance = new EnemyController(100, 300);
        instance.addMovable(enemy);
        instance.updatePositions();

        int expectedX = 49;
        int expectedY = 151;

        assertEquals(expectedX, enemy.getPosition().getX(), 0.0001);
        assertEquals(expectedY, enemy.getPosition().getY(), 0.0001);

    }

    @Test
    public void testUpdatePositionsRight() {
        System.out.println("updatePositions");
        enemy.setCurrentDir(Direction.RIGHT);
        EnemyController instance = new EnemyController(100, 300);
        instance.addMovable(enemy);
        instance.updatePositions();

        int expectedX = 51;
        int expectedY = 151;

        assertEquals(expectedX, enemy.getPosition().getX(), 0.0001);
        assertEquals(expectedY, enemy.getPosition().getY(), 0.0001);

    }

}
