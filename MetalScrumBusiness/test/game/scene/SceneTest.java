/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.scene;

import game.character.Player;
import game.objects.Weapon;
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
public class SceneTest {

    Player player;

    public SceneTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        player = new Player(new Point(280, 216), 50, 45, "player", new Weapon(2));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class Scene.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Scene expResult = null;
        Scene result = Scene.getInstance();
        assertNotEquals(expResult, result);
        assertNotNull(result);
    }

    /**
     * Test of addToDraw method, of class Scene.
     */
    @Test
    public void testAddToDraw() {
        System.out.println("addToDraw");

        Scene instance = Scene.getInstance();

        instance.addToDraw(player);

        assertEquals(1, instance.getObjects().size());
    }

    /**
     * Test of removeFromDraw method, of class Scene.
     */
    @Test
    public void testRemoveFromDraw() {
        System.out.println("removeFromDraw");
        Scene instance = Scene.getInstance();

        instance.addToDraw(player);

        assertEquals(1, instance.getObjects().size());
        instance.removeFromDraw(player);
        assertEquals(0, instance.getObjects().size());

    }

    /**
     * Test of reset method, of class Scene.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        Scene instance = Scene.getInstance();

        instance.addToDraw(player);

        assertEquals(1, instance.getObjects().size());
        instance.reset();
        assertEquals(0, instance.getObjects().size());
    }

}
