/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners.stateListeners;

import listeners.stateListeners.LoadedStageListener;
import gameState.GameOverState;
import gameState.LoadingStageState;
import metalscrum.Application;
import metalscrum.PlayerDeadListener;
import metalscrum.State;

/**
 *
 * @author albc
 */
public class PlayerListener implements PlayerDeadListener{
        private Application context;

        public PlayerListener(Application context) {
            this.context = context;
        }
        
        
        @Override
        public void playerDead() {
            
            context.getStatus().end();
            context.setStatus(new GameOverState(context.getGameOver()));
            
        }

        @Override
        public void playerHealthLevelEnded() {
            
            context.end();
            State s= new LoadingStageState(context.getCurrentGameLevel(), context.getCurrentPlayer(), context.getCurrentControllers(),new PlayerListener(context));
            s.setListener(new LoadedStageListener(context));
            context.setStatus(s);
             
        }
        
    }