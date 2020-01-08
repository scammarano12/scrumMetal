/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.collisions;

import game.character.Enemy;
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
public class CollisionControllerTest {

    Player player;
    Enemy enemy;
    Player player2;
    Enemy enemy2;
    int numBorder;

    public CollisionControllerTest() {
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
        enemy = new Enemy(new Point(231, 216), 50, 45, "enemy", 50, new Weapon(2));
        player2 = new Player(new Point(231, 216), 50, 45, "player", new Weapon(2));
        enemy2 = new Enemy(new Point(280, 216), 50, 45, "enemy", 50, new Weapon(2));
        numBorder = 2;

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addSubject method, of class CollisionController.
     */
    @Test
    public void testAddSubject() {
        System.out.println("addSubject");
        CollisionController instance = CollisionController.getInstance();
        instance.addSubject(player);
        instance.addObject(enemy);
        instance.checkCollision();

        boolean collision = player.getCollision().isLeft();
        assertEquals(true, collision);
        collision = enemy.getCollision().isLeft();
        assertEquals(true, collision);
        assertEquals(1, instance.getSubjects().size());
        instance.reset();

    }

    /**
     * Test of removeSubject method, of class CollisionController.
     */
    @Test
    public void testRemoveSubject() {
        System.out.println("removeSubject");
        CollisionController instance = CollisionController.getInstance();
        instance.reset();
        instance.addSubject(player);
        instance.addObject(enemy);
        instance.checkCollision();

        boolean collision = player.getCollision().isLeft();
        assertEquals(true, collision);
        collision = enemy.getCollision().isLeft();
        assertEquals(true, collision);
        assertEquals(1, instance.getSubjects().size());
        instance.removeSubject(player);
        assertEquals(0, instance.getSubjects().size());
    }

    /**
     * Test of addObject method, of class CollisionController.
     */
    @Test
    public void testAddObject() {
        System.out.println("addObject");
        CollisionController instance = CollisionController.getInstance();
        instance.reset();
        instance.addSubject(player);
        instance.addObject(enemy);
        instance.checkCollision();

        boolean collision = enemy.getCollision().isLeft();
        assertEquals(true, collision);
        collision = player.getCollision().isLeft();
        assertEquals(true, collision);
        assertEquals(numBorder + 1, instance.getObjs().size());
    }

    /**
     * Test of removeObject method, of class CollisionController.
     */
    @Test
    public void testRemoveObject() {
        System.out.println("removeObject");

        CollisionController instance = CollisionController.getInstance();
        instance.reset();
        instance.addSubject(player2);
        instance.addObject(enemy2);
        instance.checkCollision();

        boolean collision = player2.getCollision().isRigth();
        assertEquals(true, collision);
        collision = enemy2.getCollision().isRigth();
        assertEquals(true, collision);
        assertEquals(numBorder + 1, instance.getObjs().size());
        instance.removeObject(enemy2);
        assertEquals(numBorder, instance.getObjs().size());
    }

    /**
     * Test of reset method, of class CollisionController.
     */
    @Test
    public void testReset() {
        System.out.println("reset");

        CollisionController instance = CollisionController.getInstance();
        instance.reset();
        instance.addSubject(player);
        instance.addObject(enemy);
        System.out.println("\n");

        //per verificare il motivo del fallimento del test decommentare questo for each
        /*
        for (SolidObject o : instance.getObjs()) {
            System.out.println(o.getId());
        }
        System.out.println(instance.getObjs().size());
        
         */
        System.out.println("\n");
        assertEquals(numBorder + 1, instance.getObjs().size());
        assertEquals(1, instance.getSubjects().size());
        instance.reset();
        assertEquals(numBorder, instance.getObjs().size());
        assertEquals(0, instance.getSubjects().size());

    }

    /**
     * Test of checkCollision method, of class CollisionController.
     */
    @Test
    public void testCheckCollision() {
        System.out.println("checkCollision");

        CollisionController instance = CollisionController.getInstance();
        instance.addSubject(player);
        instance.addObject(enemy);

        instance.checkCollision();

        boolean collision = player.getCollision().isLeft();
        assertEquals(true, collision);
        collision = enemy.getCollision().isLeft();
        assertEquals(true, collision);

    }

}
