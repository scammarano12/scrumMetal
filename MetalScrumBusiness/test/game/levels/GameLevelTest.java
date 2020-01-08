/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.levels;

import java.awt.Point;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class GameLevelTest {

    public GameLevelTest() {
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
     * Test of nextStage method, of class GameLevel.
     */
    @Test
    public void testNextStage() {
        System.out.println("nextStage");
        GameLevel instance = new GameLevel(1, 1);
        assertEquals(true, instance.checkNextStage());
        instance.nextStage();
        assertEquals(false, instance.checkNextStage());
    }

    /**
     * Test of checkNextStage method, of class GameLevel.
     */
    @Test
    public void testCheckNextStage() {
        System.out.println("checkNextStage");
        GameLevel instance = new GameLevel(1, 1);
        boolean expResult = true;
        boolean result = instance.checkNextStage();
        assertEquals(expResult, result);
        expResult = false;
        instance.nextStage();

        result = instance.checkNextStage();
        assertEquals(expResult, result);

    }

    /**
     * Test of createStage method, of class GameLevel.
     */
    @Test
    public void createStageTest() {
        HashMap<String, List<Point>> positions = new HashMap<>();
        GameLevel gameLevel = new GameLevel(1, 3);
        positions = (HashMap<String, List<Point>>) gameLevel.createStage();
        assertNotNull(positions);

    }

}
