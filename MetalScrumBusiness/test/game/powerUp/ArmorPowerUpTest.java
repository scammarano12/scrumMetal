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
import java.awt.Point;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Francesco Sabbarese
 */
public class ArmorPowerUpTest {

    Player p;

    CollisionController cc;

    public ArmorPowerUpTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        p = new Player(new Point(50, 50), 50, 50, "player", new Weapon(2));

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setCollision method, of class ArmorPowerUp.
     */
    @Test
    public void testSetCollision() {
        System.out.println("setCollision");
        ArmorPowerUp instance = new ArmorPowerUp(new Point(1, 24), 50, 50, "ArmorPowerUp");
        cc = CollisionController.getInstance();

        cc.addObject(instance);
        cc.addSubject(p);
        cc.checkCollision();

        Collision c = p.getCollision();
        boolean result = c.isLeft();
        assertEquals(true, result);
    }

}
