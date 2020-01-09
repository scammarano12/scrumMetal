/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.frame.listeners;

import game.frame.listeners.EndGameListener;
import game.frame.Application;
import game.frame.state.InGameState;
import game.frame.listeners.GameListener;
import game.frame.state.State;

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
