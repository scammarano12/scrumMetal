/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.listeners;

import game.state.StartMenuState;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import game.frame.Application;
import game.state.LoadingLevelState;
import game.state.State;
import game.state.stateListeners.LoadedLevelListener;

/**
 *
 * @author albc
 */
public class QuitListener implements ActionListener{
        private Application context;

        public QuitListener(Application context) {
            this.context = context;
        }
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            context.getCurrentGameLevel().setLevel(1, 1);
            State s= new LoadingLevelState(context.getCurrentGameLevel());
            s.setListener(new LoadedLevelListener(context));
            
            context.setStatus(s);
           
            context.setStatus(new StartMenuState(context.getStart()));
     
            
        }

}
