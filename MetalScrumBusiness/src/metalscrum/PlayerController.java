/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalscrum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author stefano
 */
public class PlayerController extends CharacterController implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
       switch(e.getKeyCode()){
           case KeyEvent.VK_SPACE:
                shoot=true;
            break;
           case KeyEvent.VK_LEFT:
               dx=-1;
           break;
           case KeyEvent.VK_RIGHT:
               dx=1;
           break;
           case KeyEvent.VK_UP:
                dy=-10;
            break;
              
       }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_SPACE:
                shoot=false;
            break;
           case KeyEvent.VK_LEFT:
               dx=0;
           break;
           case KeyEvent.VK_RIGHT:
               dx=0;
           break;
           case KeyEvent.VK_UP:
               dy=0;
            break;
              
       }
    }
    
    @Override
    public void updatePositions(){
        for(Movable m: characters){
            System.out.println(shoot);
            if(shoot){
                ((Player) m).shoot();
            }
            
            m.move(dx, dy+gravitylv);
            if(dy!=0){
                dy=dy+gravitylv;
            }
            
            
        }
    }

   
    
    
    
}
