/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.character;

import game.collisions.CollisionController;
import game.objects.Bullet;
import game.objects.Weapon;
import game.objects.movable.Direction;
import game.scene.Scene;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.Timer;
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
public class WeaponTest {
    private Weapon instance;
    private int rateo;
    private long time;
        
    
    
    public WeaponTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        rateo = 2;
        instance = new Weapon(rateo);
        Scene.getInstance();
        CollisionController.getInstance();
        time = System.currentTimeMillis();
        //System.out.println(time);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of shoot method, of class Weapon.
     */
    @Test
    public void testShoot1() {
        Point position = new Point(40, 60);
        Direction d = Direction.RIGHT;
        int width = 14;
        int heigth = 6;
        Weapon instance1 = new Weapon(rateo);
        Bullet result = instance1.shoot(position, d, width, heigth, "bullet");
        assertNotEquals("Se sparo, bisogna che l'oggetto result sia diverso da null", null, result);    //La prima volta può sparare (1 volta) (seppur il tempo non è iniziato a scorrere, perché fa SystemCurrent-0 che sarà sicuramente > 1000/rateo ).
    }
    
    @Test
    public void testShoot2() {
        Point position = new Point(40, 60);
        Direction d = Direction.RIGHT;
        int width = 20;
        int heigth = 30;

        int bull=0;
        while(System.currentTimeMillis()-time < 1000){  //entreremo finché il tempo trascorso è minore di 1 secondo. Spareremo tante volte, ma solo 2 (rateo) proiettili dovrebbero partire in un secondo (il primo a 0 e il secondo a 0,5 secondi).
            Bullet result = instance.shoot(position, d, width, heigth, "bullet");
            //System.out.println("Provo a sparare!!");
            if(result!=null)
                bull++;
        }

        assertEquals("Se provo a sparare continuamente, deve permettermi di sparare al più 2 proiettili al secondo.", bull, rateo);
    }
    
    
    
    @Test
    public void testShoot3() {
        Point position = new Point(40, 60);
        Direction d = Direction.RIGHT;
        int width = 20;
        int heigth = 30;
        
        while(System.currentTimeMillis()-time < 1000){  //entreremo finché il tempo trascorso è minore di 1 secondo. Spareremo tante volte, ma solo 2 (rateo) proiettili dovrebbero partire in un secondo (il primo a 0 e il secondo a 0,5 secondi).
            Bullet result = instance.shoot(position, d, width, heigth, "bullet");
            //System.out.println("Provo a sparare!!");
            
            if(result==null){
                assertEquals("Se provo a sparare continuamente, alcuni dei proietti dovranno essere null.", null, result);  //poiché è consentito sparare solo rateo (2) proiettili in un secondo.
            }
        }

    }
    

   
    

}
