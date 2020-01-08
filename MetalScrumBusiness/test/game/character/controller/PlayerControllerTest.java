/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.character.controller;

import game.character.Player;
import game.collisions.CollisionController;
import game.objects.Weapon;
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

    CollisionController c;
    Player player;

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
        c = CollisionController.getInstance();
        player = new Player(new Point(280, 216), 50, 45, "player", new Weapon(2));
    }

    @After
    public void tearDown() {
    }

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
    @Test
    public void testUpdatePositionsRight() {
        System.out.println("updatePositions RIGHT");
        PlayerController instance = new PlayerController();
        instance.addMovable(player);

        int dx = 1;
        int dy = 0;
        instance.dx = dx;
        instance.dy = dy;

        c.addObject(player);
        c.addSubject(player);

        instance.updatePositions();

        //Direction expectedDir = Direction.RIGHT;
        //assertEquals(expectedDir, instance.walkRight.getDir());
        int expectedX = 280 + dx;
        assertEquals(expectedX, player.getPosition().getX(), 0.0001);

        int expectedY = 216 + 1;
        assertEquals(expectedY, player.getPosition().getY(), 0.0001);

    }

    @Test
    public void testUpdatePositionsLeft() {
        System.out.println("updatePositions LEFT");
        PlayerController instance = new PlayerController();
        instance.addMovable(player);

        int dx = -1;
        int dy = 0;
        instance.dx = dx;
        instance.dy = dy;

        c.addObject(player);
        c.addSubject(player);

        instance.updatePositions();

        //Direction expectedDir = Direction.LEFT;
        //assertEquals(expectedDir, instance.walkLeft.getDir());
        int expectedX = 280 + dx;
        assertEquals(expectedX, player.getPosition().getX(), 0.0001);

        int expectedY = 216 + 1;
        assertEquals(expectedY, player.getPosition().getY(), 0.0001);

    }

    @Test
    public void testUpdatePositionsUp() {
        System.out.println("updatePositions UP");

        PlayerController instance = new PlayerController();
        instance.addMovable(player);

        int dx = 1;
        int dy = -15;
        instance.dx = dx;
        instance.dy = dy;

        c.addObject(player);
        c.addSubject(player);

        instance.updatePositions();

        // Direction expectedDir = Direction.RIGHT;
        //assertEquals(expectedDir, player.getCurrentDir());
        int expectedX = 280 + dx;
        assertEquals(expectedX, player.getPosition().getX(), 0.0001);

        int expectedY = 216 + dy + 1; //gravità
        assertEquals(expectedY, player.getPosition().getY(), 0.0001);

    }

    /*
    @Test
    public void testUpdatePositionShoot(){
        
        System.out.println("updatePositions Shoot");
        PlayerController instance = new PlayerController();
        instance.addMovable(player);
        
        instance.shoot = true;
        
        instance.updatePositions();
        int len = player.bullets.size();
        int expectedLen = 1; 
        assertEquals(expectedLen, len);

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
