/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners.stateListeners;

import listeners.stateListeners.EndGameListener;
import metalscrum.Application;
import gameState.InGameState;
import listeners.GameListener;
import metalscrum.EndStateListener;
import metalscrum.State;

/**
 *
 * @author albc
 */
public class LoadedStageListener implements EndStateListener{
        private Application context;

        public LoadedStageListener(Application context) {
            this.context = context;
        }
        @Override
        public void stateEnded() {
            
            State s= new InGameState(context.getCurrentControllers(),context.getCurrentGameLevel(),context.getCurrentPlayer(),new GameListener(context));
            s.setListener(new EndGameListener(context));
            context.setStatus(s);
        }
        
    }
