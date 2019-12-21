/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners.buttonListeners;

import listeners.stateListeners.LoadedLevelListener;
import gameState.LoadingLevelState;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import metalscrum.Application;
import metalscrum.State;

/**
 *
 * @author albc
 */
public class PlayListener implements ActionListener{
        private Application context;

        public PlayListener(Application context) {
            this.context = context;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            context.getStatus().end();
            State s = new LoadingLevelState();
            s.setListener(new LoadedLevelListener(context));
            context.setStatus(s);
        }
    
    }