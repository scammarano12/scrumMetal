/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalscrum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author SimonePadula
 */
public class EnemyController extends CharacterController implements ActionListener {

    private int count=0;
    private int rangeMin;
    private int rangeMax;
    
    private float distance;
    private Timer timer;
    
    private boolean shoot=false;
    
    
    
    public EnemyController(int rangeMin, int rangeMax){
        this.rangeMin = rangeMin;
        this.rangeMax = rangeMax;
        Random rand = new Random();
        this.distance = rand.nextInt((this.rangeMax - this.rangeMin) + 1) + this.rangeMin;
        //System.out.println(this.distance);
        
        this.timer = new Timer((rand.nextInt((10-7)+1)+7)*1000, this);
        timer.start();
        
    }
        

    public int getRangeMin() {
        return rangeMin;
    }

    public void setRangeMin(int rangeMin) {
        this.rangeMin = rangeMin;
    }

    public int getRangeMax() {
        return rangeMax;
    }

    public void setRangeMax(int rangeMax) {
        this.rangeMax = rangeMax;
    }
    

    public float getDistance() {
        return distance;
    }
    
    
    @Override
    public void updatePositions() {
        
        
        for (Movable m : characters) {  //si può togliere il foreach
            
            if( ((Enemy)m).getCurrentDir()==Direction.RIGHT ){
                if(count < this.distance){
                    dx = 1;
                    count++;
                    //System.out.print("DX ");
                    //System.out.println(count);
                    
                } else{
                    dx = -1;
                    count--;
                    ((Enemy)m).setCurrentDir(Direction.LEFT);
                    //System.out.print("DX ");
                    //System.out.println(count);
                }    
            }
            
            
            if( ((Enemy)m).getCurrentDir()==Direction.LEFT ){
                if( count>0 ){ //dx==((Enemy)m).getDistance()
                    dx = -1;
                    count--;
                    //System.out.print("SX ");
                    //System.out.println(count);
                } else{
                    dx = 1;
                    count++;
                    ((Enemy)m).setCurrentDir(Direction.RIGHT);
                    //System.out.print("SX ");
                    //System.out.println(count);
                }
            }
            
            
            
            
            m.move(dx, dy + gravitylv);
                if (dy != 0) {
                    dy = dy + gravitylv;
                }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.shoot = true;
        System.out.print("SPAROOOOOOO!");
        for (Movable m : characters) {
            ((Enemy) m).shoot();
        }
        this.shoot = false;
    }
    

}
