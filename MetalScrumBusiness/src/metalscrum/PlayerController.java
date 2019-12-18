/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalscrum;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author stefano
 */
public class PlayerController extends CharacterController implements KeyListener {
    private boolean avaiable=false;
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
               if(avaiable){
                   dy=-15;
                   avaiable=false;
               }
                
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
            Player p = (Player) m;
            if(p.isAlive()){
            if(shoot){
                p.shoot();
            }
            Collision collision=p.getCollision();
            if (dx>0 && !collision.isRigth() || dx<0 && !collision.isLeft()){ 
                if(dx>0)
                    p.setCurrentDir(Direction.RIGHT);
                else
                    p.setCurrentDir(Direction.LEFT);

            p.move(dx,0);
            }
            if(dy!=gravitylv)
                    dy+=gravitylv;
            else if (collision.isDown()){
                    dy=0;
                    avaiable=true;
                }
            if(dy<0 && !collision.isTop() || dy>0 && !collision.isDown() ){
                
                
                p.move(0, dy) ;
            }


            for(Bullet b : p.getFiredBullets()){
                if(b.getHitbox().x>1280 || b.getHitbox().x<0){
                   
                    b.setActive(false);
                    b.unDraw();
                    b.stopCollision();
                }
                else if(b.getCurrentDir() == Direction.SHOOTING_LEFT){
                        b.move(-10,0);
                    }
                else if(b.getCurrentDir() == Direction.SHOOTING_RIGHT){
                    b.move(10,0);
                }
            }
            
        }else{  
                if(p.hasLives())
                    GameStatus.setGameStatus(1);
                else
                    GameStatus.setGameStatus(4);
                p.unDraw();
                p.stopCollision();
            }
        }
        
        
    }

   
    
    
    
}
