/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.frame.listeners;

import game.frame.listeners.LoadedStageListener;
import game.frame.state.GameOverState;
import game.frame.state.LoadingStageState;
import game.frame.Application;
import game.frame.state.State;

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
            
            context.setStatus(new GameOverState(context.getGameOver()));
            
        }

        @Override
        public void playerHealthLevelEnded() {
           
            State s= new LoadingStageState(context.getCurrentGameLevel(), context.getCurrentPlayer(), context.getCurrentControllers(),new PlayerListener(context));
            s.setListener(new LoadedStageListener(context));
            context.setStatus(s);
             
        }
        
    }