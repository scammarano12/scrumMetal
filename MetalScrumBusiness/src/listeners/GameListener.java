/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import metalscrum.Application;
import gameState.PauseMenuState;

/**
 *
 * @author albc
 */
public class GameListener implements KeyListener{
            private Application context;

        public GameListener(Application context) {
            this.context = context;
        }
            
            
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ESCAPE ){
                    /*if(GameStatus.getGameStatus()==0){
                        GameStatus.setGameStatus(2);
                    }*/                   
                    context.getStatus().end();
                    context.setStatus(new PauseMenuState(context.pause,context.getCurrentControllers(),context.getCurrentGameLevel(),context.getCurrentPlayer()));

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
    }
