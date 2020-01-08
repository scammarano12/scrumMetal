/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.character.controller;

import game.character.Enemy;
import game.character.state.enemyState.EnemyStopRight;
import game.objects.Weapon;
import game.objects.movable.Direction;
import java.awt.Point;
import java.awt.event.ActionEvent;
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
public class EnemyControllerTest {
    
    public EnemyControllerTest() {
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
     * Test of deActive method, of class EnemyController.
     */
//    @Test
//    public void testDeActive() {
//        System.out.println("deActive");
//        EnemyController instance = null;
//        instance.deActive();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getRangeMin method, of class EnemyController.
     */
    @Test
    public void testGetRangeMin() {
        System.out.println("getRangeMin");
        EnemyController instance = new EnemyController(10, 20);
        int expResult = 10;
        int result = instance.getRangeMin();
        assertEquals("Range min errato!",expResult, result);
        
    }

    /**
     * Test of setRangeMin method, of class EnemyController.
     */
    @Test
    public void testSetRangeMin() {
        System.out.println("setRangeMin");
        int rangeMin = 15;
        EnemyController instance1 = new EnemyController(10, 20);
        instance1.setRangeMin(rangeMin);
        
        int result = instance1.getRangeMin();
        assertEquals("Settaggio Range min errato!",rangeMin, result);
        
    }

    /**
     * Test of getRangeMax method, of class EnemyController.
     */
    @Test
    public void testGetRangeMax() {
        System.out.println("getRangeMax");
        EnemyController instance2 = new EnemyController(10, 20);
        int expResult = 20;
        int result = instance2.getRangeMax();
        assertEquals("Range max errato!",expResult, result);
        
    }

    /**
     * Test of setRangeMax method, of class EnemyController.
     */
    @Test
    public void testSetRangeMax() {
        System.out.println("setRangeMax");
        int rangeMax = 25;
        EnemyController instance3 = new EnemyController(10, 20);
        instance3.setRangeMax(rangeMax);
        
        int result = instance3.getRangeMax();
        assertEquals("Settaggio Range min errato!",rangeMax, result);
        
    }

    /**
     * Test of getDistance method, of class EnemyController.
     */
    @Test
    public void testGetDistance() {
        
        System.out.println("getDistance");
        EnemyController instance4 = new EnemyController(10, 20);
        boolean result = false;
        
        if(instance4.getDistance() >= instance4.getRangeMin() && instance4.getDistance() <= instance4.getRangeMax() )
            result = true;
 
        assertEquals("La distanza non è compresa tra RangeMin e RangeMax",true, result);
        
    }

    /**
     * Test of updatePositions method, of class EnemyController.
     */
    @Test
    public void testUpdatePositions() {
        System.out.println("updatePositions");
        
        Enemy enemy = new Enemy(new Point(90,50), 30, 30,"enemy",2,new Weapon(2));
        enemy.setState(new EnemyStopRight());
        EnemyController instance5 = new EnemyController(10, 20);
        instance5.addMovable(enemy);
        
        float dist = instance5.getDistance();
        Direction startDir = enemy.getCurrentDir();
        int startPosition = enemy.getPosition().x;
        
        
        boolean checkPos = true;
        
        for(int i=0; i<50; i++){

            instance5.updatePositions();
            
            
            Direction currentDir = enemy.getCurrentDir();
            int currentPosition = enemy.getPosition().x;

            
            if( currentDir != startDir){
                
                if(currentDir==Direction.LEFT){     //essendo cambiata la direzione ci aspettiamo che ora sarà Direction.LEFT
                    if(currentPosition-startPosition != dist){ 
                        //System.out.println("ENTROOOO IF!!  I: "+i+"  - Pos: "+(currentPosition-startPosition));
                        checkPos = false;
                    }
                    else {
                        //System.out.println("ENTROOOO ELSE!!  I: "+i+"  - Pos: "+(currentPosition-startPosition));
                        startDir = currentDir;
                        startPosition = currentPosition;
                    }      
                }
                
                if(currentDir==Direction.RIGHT){    //essendo cambiata la direzione ci aspettiamo che ora sarà Direction.RIGHT
                    if(currentPosition-startPosition != -dist){ 
                            //System.out.println("ENTROOOO IF!!  I: "+i+"  - Pos: "+(currentPosition-startPosition));
                            checkPos = false;
                        }
                        else {
                            //System.out.println("ENTROOOO ELSE!!  I: "+i+"  - Pos: "+(currentPosition-startPosition));
                            startDir = currentDir;
                            startPosition = currentPosition;
                        }      
                }
                    
            }
            
            assertEquals(true, checkPos);
            
        }
  
    }

}
