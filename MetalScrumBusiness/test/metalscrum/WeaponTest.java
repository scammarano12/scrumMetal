/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalscrum;

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
        Drawer.setScene(new Scene());
        CollisionSystem.setCollisionController(new CollisionController());
        time = System.currentTimeMillis();
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
        Direction d = Direction.SHOOTING_RIGHT;
        int width = 20;
        int heigth = 30;
        Weapon instance1 = new Weapon(rateo);
        Bullet result = instance1.shoot(position, d, width, heigth);
        assertEquals("Se sparo, bisogna che l'oggetto result sia diverso da null", null, result);
    }
    
    @Test
    public void testShoot2() {
        Point position = new Point(40, 60);
        Direction d = Direction.SHOOTING_RIGHT;
        int width = 20;
        int heigth = 30;

        int bull=0;
        while(System.currentTimeMillis()-time < 1200){  //entreremo finché il tempo trascorso è minore di 1 secondo (più qualcosina affinché permetta di chiamare il metodo shoot). Spareremo tante volte, ma solo 2 (rateo) proiettili dovrebbero partire in un secondo (il primo tra 0 e 0,5 secondi e il secondo tra 0,5 e 1 secondo.
            Bullet result = instance.shoot(position, d, width, heigth);
            if(result!=null)
                bull++;
        }

        assertEquals("Se provo a sparare continuamente, deve permettermi di sparare al più 2 proiettili al secondo.", bull, rateo);
    }
    
    /*
    @Test
    public void testShoot3() {
        Point position = new Point(40, 60);
        Direction d = Direction.SHOOTING_RIGHT;
        int width = 20;
        int heigth = 30;
         
        //Bullet expResult = new Bullet(new Point(position.x+width+10, position.y+heigth/2),57,19,"bullet",true,1,d);
        Bullet result = instance.shoot(position, d, width, heigth);
        //assertEquals(expResult, result);
        assertNotEquals(null, result);
    }
    
    */
    
    
    
    
    
      
    /*
    //Per la classe WeaponTest
    @Override
    public boolean equals(Object obj){
        //Point position, int width, int heigth, String id, boolean isVisible,int damage,Direction currentDir
        
        Bullet b = ((Bullet)obj);
        if(this.position.x != b.position.x || this.position.y != b.position.y)
            return false;
        if(this.width != b.width)
            return false;
        if(this.heigth != b.heigth)
            return false;
        if(this.id != b.id)
            return false;
        if(!(this.isVisible()==true && b.isVisible()==true || this.isVisible()==false && b.isVisible()==false))
            return false;
        if(this.damage!=b.damage)
            return false;
        if(this.currentDir!=b.currentDir)
            return false;
        
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.damage;
        hash = 71 * hash + (this.active ? 1 : 0);
        hash = 71 * hash + Objects.hashCode(this.images);
        return hash;
    }
   
    */

}
