/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.listeners;

import game.state.stateListeners.LoadedLevelListener;
import game.state.LoadingLevelState;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import game.frame.Application;
import game.state.State;

/**
 *
 * @author albc
 */
public class RestartListener implements ActionListener{
        private Application context;

        public RestartListener(Application context) {
            this.context = context;
        }
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            context.end();
            State s= new LoadingLevelState();
            s.setListener(new LoadedLevelListener(context));
            context.setStatus(s);
            //GameStatus.setGameStatus(1);
            
            
        }
    
    }