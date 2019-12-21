/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners.buttonListeners;

import listeners.stateListeners.PlayerListener;
import listeners.stateListeners.LoadedStageListener;
import gameState.LoadingStageState;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import metalscrum.Application;
import metalscrum.State;

/**
 *
 * @author albc
 */
public class PlayStageListener implements ActionListener{
        private Application context;

        public PlayStageListener(Application context) {
            this.context = context;
        }
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            
            context.getStatus().end();
            State s=new LoadingStageState(context.getCurrentGameLevel(),context.getCurrentPlayer(),context.getCurrentControllers(),new PlayerListener(context));
            s.setListener(new LoadedStageListener(context));
            context.setStatus(s);
            
            //GameStatus.setGameStatus(1);
        }
    
    }
