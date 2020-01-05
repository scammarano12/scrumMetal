/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.character;

import game.collisions.Collision;
import game.collisions.CollisionController;
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
 * @author SimonePadula
 */
public class EnemyTest {
    
    private CollisionController cc;
    
    public EnemyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        cc = CollisionController.getInstance();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setCollision method, of class Enemy.
     */
    @Test
    public void testSetCollision() {
        System.out.println("setCollision");
        Collision c = null;
        Enemy enemy = new Enemy(new Point(50,50),50,45,"enemy",2,new Weapon(2));
        Player player = new Player(new Point(150,150), 40, 36, "player",new Weapon(2));
        cc.addSubject(enemy);
        cc.addSubject(player);
        cc.addObject(player);
        
        cc.checkCollision();
        //enemy.setCollision(c);
        
        //assertEquals(max, instance2.getMaxHealth());

    }
    
}
