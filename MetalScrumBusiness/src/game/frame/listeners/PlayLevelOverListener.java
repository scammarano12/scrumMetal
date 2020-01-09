/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.frame.listeners;

import game.frame.state.LoadingLevelState;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import game.frame.Application;
import game.frame.state.State;

/**
 *
 * @author albc
 */
public class PlayLevelOverListener implements ActionListener{
        private Application context;

        public PlayLevelOverListener(Application context) {
            this.context = context;
        }
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
             
                State s = new LoadingLevelState(context.getCurrentGameLevel());
                System.out.println(s.getClass());
                
                s.setListener(new LoadedLevelListener(context));
                context.setStatus(s);
                
            
            
            
//          GameStatus.setGameStatus(3);
            
        }
    
    }