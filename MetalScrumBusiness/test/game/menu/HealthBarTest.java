/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.menu;

import game.character.Player;
import game.collisions.CollisionController;
import game.objects.Bullet;
import game.objects.Weapon;
import game.objects.movable.Direction;
import game.scene.Scene;
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
public class HealthBarTest {

    private HealthBar bar;

    public HealthBarTest() {
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
     * Test of getDraw method, of class HealthBar.
     */
    @Test
    public void testGetDraw() {
        Point position = new Point(50, 50);
        Weapon weapon = new Weapon(1);
        Player player = new Player(position, 50, 50, "player", weapon);

        int health = player.getHealth();
        assertEquals(4, health);

        Bullet bullet = new Bullet(new Point(99, 50), "bulletenemy", 1, Direction.RIGHT);

        CollisionController cc = CollisionController.getInstance();
        cc.reset();
        cc.addSubject(player);
        cc.addObject(bullet);
        cc.checkCollision();
        int healtAfterCollision = player.getHealth();
        assertEquals(3, healtAfterCollision);
        
        HealthBar instance = new HealthBar(player);
        assertTrue(instance.getDraw() instanceof Image);
    }

    @Test
    public void testUnDraw() {
        System.out.println("unDraw");
        Point position = new Point(50, 50);
        Weapon weapon = new Weapon(1);
        Player player = new Player(position, 50, 50, "player", weapon);
        HealthBar instance = new HealthBar(player);
        Scene s = Scene.getInstance();
        instance.getDraw();
        instance.unDraw();
        assertEquals(null, s.getBar());

    }

}
