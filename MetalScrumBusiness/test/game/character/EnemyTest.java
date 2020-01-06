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
        cc.reset();
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
        //Collision c = null;
        boolean coll=false;
        Enemy enemy1 = new Enemy(new Point(60,60),30, 30,"enemy",2,new Weapon(2));
        Player player1 = new Player(new Point(150,150), 30, 30, "player",new Weapon(2));
        cc.addSubject(enemy1);
        cc.addSubject(player1);
        cc.addObject(player1);
        
        cc.checkCollision();
 
        
        if(enemy1.getCollision().isDown() || enemy1.getCollision().isLeft() || enemy1.getCollision().isRigth() || enemy1.getCollision().isTop()){
            coll = true;
        }
        
        assertEquals("Nessuna collissione avvenuta!", false, coll);
        
    }
    
    
    
    @Test
    public void testSetCollisionDown() {
        System.out.println("setCollision");
        //Collision c = null;
        boolean coll=false;
        Enemy enemy = new Enemy(new Point(50,50),30, 30,"enemy",2,new Weapon(2));
        Player player = new Player(new Point(50,90), 30, 30, "player",new Weapon(2));
        cc.addSubject(enemy);
        cc.addSubject(player);
        cc.addObject(player);
        
        

        while(!enemy.getCollision().isDown()){
            //System.out.println("Enemy -->  x: "+enemy.getPosition().x +" y: "+(enemy.getPosition().y+enemy.getHeigth()));
            //System.out.println("Player -->  x: "+player.getPosition().x +" y: "+player.getPosition().y);
            //System.out.println(enemy.getCollision().isDown());
            cc.checkCollision();
            enemy.setPosition(new Point(enemy.getPosition().x, (enemy.getPosition().y+1)));
        }
        
        
        assertEquals("Collisione Down NON avvenuta con successo!", true, enemy.getCollision().isDown());
        
    }
    
    @Test
    public void testSetCollisionRight() {
        System.out.println("setCollision");
        //Collision c = null;
        boolean coll=false;
        Enemy enemy = new Enemy(new Point(50,50),30, 30,"enemy",2,new Weapon(2));
        Player player = new Player(new Point(90,50), 30, 30, "player",new Weapon(2));
        cc.addSubject(enemy);
        cc.addSubject(player);
        cc.addObject(player);
        
        

        while(!enemy.getCollision().isRigth()){
//            System.out.println("Enemy -->  x: "+(enemy.getPosition().x+enemy.getWidth()) +" y: "+(enemy.getPosition().y));
//            System.out.println("Player -->  x: "+player.getPosition().x +" y: "+player.getPosition().y);
//            System.out.println(enemy.getCollision().isRigth());
            cc.checkCollision();
            enemy.setPosition(new Point((enemy.getPosition().x+1), enemy.getPosition().y));
        }
        
        
        assertEquals("Collisione Right NON avvenuta con successo!", true, enemy.getCollision().isRigth());
        
    }
    
    
    
    @Test
    public void testSetCollisionLeft() {
        System.out.println("setCollision");
        //Collision c = null;
        boolean coll=false;
        Enemy enemy = new Enemy(new Point(90,50), 30, 30,"enemy",2,new Weapon(2));
        Player player = new Player(new Point(50,50), 30, 30, "player",new Weapon(2));
        cc.addSubject(enemy);
        cc.addSubject(player);
        cc.addObject(player);
        
        

        while(!enemy.getCollision().isLeft()){
//            System.out.println("Enemy -->  x: "+(enemy.getPosition().x) +" y: "+(enemy.getPosition().y));
//            System.out.println("Player -->  x: "+player.getPosition().x +" y: "+player.getPosition().y);
//            System.out.println(enemy.getCollision().isRigth());
            cc.checkCollision();
            enemy.setPosition(new Point((enemy.getPosition().x-1), enemy.getPosition().y));
        }
        
        
        assertEquals("Collisione Left NON avvenuta con successo!", true, enemy.getCollision().isLeft());
        
    }
    
    
    
    @Test
    public void testSetCollisionTop() {
        System.out.println("setCollision");
        //Collision c = null;
        boolean coll=false;
        Enemy enemy = new Enemy(new Point(50,90), 30, 30,"enemy",2,new Weapon(2));
        Player player = new Player(new Point(50,50), 30, 30, "player",new Weapon(2));
        cc.addSubject(enemy);
        cc.addSubject(player);
        cc.addObject(player);
        
        

        while(!enemy.getCollision().isTop()){
//            System.out.println("Enemy -->  x: "+(enemy.getPosition().x) +" y: "+(enemy.getPosition().y));
//            System.out.println("Player -->  x: "+player.getPosition().x +" y: "+player.getPosition().y);
//            System.out.println(enemy.getCollision().isRigth());
            cc.checkCollision();
            enemy.setPosition(new Point(enemy.getPosition().x, (enemy.getPosition().y-1)));
        }
        
        
        assertEquals("Collisione Top NON avvenuta con successo!", true, enemy.getCollision().isTop());
        
    }
    
    
    
    
}
