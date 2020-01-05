/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
public class PlayerControllerTest implements KeyListener {

    public PlayerControllerTest() {
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
     * Test of keyPressed method, of class PlayerController.
     */
    @Test
    public void testKeyPressedSpace() {
        System.out.println("keyPressed SPACE");

        try {
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_SPACE);
        } catch (AWTException e) {
        }

    }

    @Test
    public void testKeyPressedLeft() {
        System.out.println("keyPressed LEFT");

        try {
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_LEFT);
        } catch (AWTException e) {
        }

    }

    @Test
    public void testKeyPressedSpaceRight() {
        System.out.println("keyPressed RIGHT");

        try {
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_RIGHT);
        } catch (AWTException e) {
        }

    }

    @Test
    public void testKeyPressedSpaceUp() {
        System.out.println("keyPressed UP");

        try {
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_UP);
        } catch (AWTException e) {
        }

    }

    //==========================================================================
    /**
     * Test of keyReleased method, of class PlayerController.
     */
    @Test
    public void testKeyReleasedSpace() {
        System.out.println("keyReleased SPACE");
        try {
            Robot robot = new Robot();

            robot.keyRelease(KeyEvent.VK_RIGHT);
        } catch (AWTException e) {
        }
    }

    @Test
    public void testKeyReleasedLeft() {
        System.out.println("keyReleased LEFT");
        try {
            Robot robot = new Robot();

            robot.keyRelease(KeyEvent.VK_RIGHT);
        } catch (AWTException e) {
        }
    }

    @Test
    public void testKeyReleasedRight() {
        System.out.println("keyReleased RIGHT");
        try {
            Robot robot = new Robot();

            robot.keyRelease(KeyEvent.VK_RIGHT);
        } catch (AWTException e) {
        }
    }

    @Test
    public void testKeyReleasedUp() {
        System.out.println("keyReleased UP");
        try {
            Robot robot = new Robot();

            robot.keyRelease(KeyEvent.VK_RIGHT);
        } catch (AWTException e) {
        }
    }

    //==========================================================================
    /**
     * Test of updatePositions method, of class PlayerController.
     */
    @Test
    public void testUpdatePositionsRight() {
        System.out.println("updatePositions RIGHT");
        Player player = new Player(new Point(280, 216), 50, 45, "player", true, 100, Direction.RIGHT, new Weapon(2));

        PlayerController instance = new PlayerController();
        instance.addMovable(player);

        int dx = 1;
        int dy = 0;
        instance.dx = dx;
        instance.dy = dy;

        CollisionSystem.setCollisionController(new CollisionController());
        CollisionSystem.addCollisionSubject(player);
        CollisionSystem.addCollisionObject(player);

        instance.updatePositions();

        Direction expectedDir = Direction.RIGHT;
        assertEquals(expectedDir, player.getCurrentDir());

        int expectedX = 280 + dx;
        assertEquals(expectedX, player.getPosition().getX(), 0.0001);

        int expectedY = 216 + 1; //gravità
        assertEquals(expectedY, player.getPosition().getY(), 0.0001);

    }

    @Test
    public void testUpdatePositionsLeft() {
        System.out.println("updatePositions Left");
        Player player = new Player(new Point(280, 216), 50, 45, "player", true, 100, Direction.LEFT, new Weapon(2));

        PlayerController instance = new PlayerController();
        instance.addMovable(player);

        int dx = -1;
        int dy = 0;
        instance.dx = dx;
        instance.dy = dy;

        CollisionSystem.setCollisionController(new CollisionController());
        CollisionSystem.addCollisionSubject(player);
        CollisionSystem.addCollisionObject(player);

        instance.updatePositions();

        Direction expectedDir = Direction.LEFT;
        assertEquals(expectedDir, player.getCurrentDir());

        int expectedX = 280 + dx;
        assertEquals(expectedX, player.getPosition().getX(), 0.0001);

        int expectedY = 216 + 1; //gravità
        assertEquals(expectedY, player.getPosition().getY(), 0.0001);

    }

    @Test
    public void testUpdatePositionsUp() {
        System.out.println("updatePositions UP");
        Player player = new Player(new Point(280, 216), 50, 45, "player", true, 100, Direction.RIGHT, new Weapon(2));

        PlayerController instance = new PlayerController();
        instance.addMovable(player);

        int dx = 0;
        int dy = -15;
        instance.dx = dx;
        instance.dy = dy;

        CollisionSystem.setCollisionController(new CollisionController());
        CollisionSystem.addCollisionSubject(player);
        CollisionSystem.addCollisionObject(player);

        instance.updatePositions();

        Direction expectedDir = Direction.RIGHT;
        assertEquals(expectedDir, player.getCurrentDir());

        int expectedX = 280 + dx;
        assertEquals(expectedX, player.getPosition().getX(), 0.0001);

        int expectedY = 216 + dy + 1; //gravità
        assertEquals(expectedY, player.getPosition().getY(), 0.0001);

    }

    /*
    @Test
    public void testUpdatePositionsBulletRight() {
        System.out.println("updatePositions Bullet");
        Player player = new Player(new Point(280, 216), 50, 45, "player", true, 100, Direction.RIGHT, new Weapon(2));

        PlayerController instance = new PlayerController();
        instance.addMovable(player);

        instance.shoot = true;
        instance.updatePositions();

        int dx = 10;
        int dy = 0;

        int expectedX = 280 + player.getWidth() + 10 + dx;
        int expectedY = 216 + player.getHeigth() / 2;

        System.out.println(player.bullets.isEmpty());
        Bullet b = player.bullets.get(1);

        assertEquals(expectedX, b.getPosition().getX(), 0.001);
        assertEquals(expectedY, b.getPosition().getY(), 0.001);

    }

    */
    
    

    //==========================================================================
    //EVENTI GENERATI
    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        PlayerController instance = new PlayerController();
        instance.keyPressed(e);

        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                boolean expectedSpace = true;
                assertEquals(expectedSpace, instance.shoot);
                break;

            case KeyEvent.VK_LEFT:
                int expectedLeft = -1;
                assertEquals(expectedLeft, instance.dx);
                break;

            case KeyEvent.VK_RIGHT:
                int expectedRight = 1;
                assertEquals(expectedRight, instance.dx);
                break;

            case KeyEvent.VK_UP:
                int expectedUp = -15;
                assertEquals(expectedUp, instance.dy);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        PlayerController instance = new PlayerController();
        instance.keyPressed(e);

        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                boolean expectedSpace = false;
                assertEquals(expectedSpace, instance.shoot);
                break;

            case KeyEvent.VK_LEFT:
                int expectedLeft = 0;
                assertEquals(expectedLeft, instance.dx);
                break;

            case KeyEvent.VK_RIGHT:
                int expectedRight = 0;
                assertEquals(expectedRight, instance.dx);
                break;

            case KeyEvent.VK_UP:
                int expectedUp = 0;
                assertEquals(expectedUp, instance.dy);
                break;
        }
    }

}
