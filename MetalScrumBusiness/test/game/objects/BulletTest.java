/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.objects;

import game.GameSettings;
import game.character.Player;
import game.collisions.Collision;
import game.collisions.CollisionController;
import game.objects.movable.Direction;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Salvatore
 */
public class BulletTest {
    
    private CollisionController cc;
    
    public BulletTest() {
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
        cc.reset();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of initMusic method, of class Bullet.
     */
//    @Test
//    public void testInitMusic() {
//        System.out.println("initMusic");
//        Bullet instance = null;
//        instance.initMusic();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of move method, of class Bullet.
     */ 
    @Test
    public void testMove() {
        System.out.println("move");
        boolean checkMove = false;
        Bullet instance = new Bullet(new Point(40, 60),"bullet",1, Direction.RIGHT);
        int dx = instance.getPosition().x + 10;
        int dy = instance.getPosition().y + 5;
        
        instance.move(10, 5);

        if( dx == instance.getPosition().x && dy == instance.getPosition().y){
            checkMove = true;  
        }
        assertEquals("La posizione del bullet non è cambiata!",true, checkMove);
        
    }

    /**
     * Test of clone method, of class Bullet.
     */
//    @Test
//    public void testClone() throws Exception {
//        System.out.println("clone");
//        Bullet instance = null;
//        Bullet expResult = null;
//        Bullet result = instance.clone();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of isActive method, of class Bullet.
     */
//    @Test
//    public void testIsActive() {
//        System.out.println("isActive");
//        Bullet instance = null;
//        boolean expResult = false;
//        boolean result = instance.isActive();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setActive method, of class Bullet.
//     */
//    @Test
//    public void testSetActive() {
//        System.out.println("setActive");
//        boolean active = false;
//        Bullet instance = null;
//        instance.setActive(active);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getDirection method, of class Bullet.
//     */
//    @Test
//    public void testGetDirection() {
//        System.out.println("getDirection");
//        Bullet instance = null;
//        Direction expResult = null;
//        Direction result = instance.getDirection();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
    /**
     * Test of setCollision method, of class Bullet.
     */
    @Test
    public void testSetCollision() {
        System.out.println("setCollision e checkDamage");
//        Collision c = null;
        boolean checkDamage = false;
        Bullet bullet = new Bullet(new Point(150, 40),"bulletenemy",1, Direction.LEFT); 
        Player player = new Player(new Point(60,25), 40, 50, "player",new Weapon(2));
        //con tali posizioni si ha già una condizione di collisione a sinistra tra player e bullet.
        
        cc.addSubject(player);
      
        //cc.addObject(bullet);     //non bisogna farla perche viene già fatta nel costruttore di Bullet (altrimenti aggiungerebbe due bullet uguali alla lista di oggetti in cc)
        
        int currentHealth = player.getHealth();
        for(int i=0;i< 100;i++){
        
        cc.checkCollision();

        
        if(player.getCollision().isRigth()){
            if(currentHealth != player.getHealth() && currentHealth - player.getHealth() == 1 )
                checkDamage = true;
        }
        
        if(bullet.isActive()){
            bullet.move(-1,0);
        }
          
           
        }
         assertEquals("Il bullet non danneggia il player!",true, checkDamage);
    }
//
//    /**
//     * Test of getDraw method, of class Bullet.
//     */
//    @Test
//    public void testGetDraw() {
//        System.out.println("getDraw");
//        Bullet instance = null;
//        Image expResult = null;
//        Image result = instance.getDraw();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
