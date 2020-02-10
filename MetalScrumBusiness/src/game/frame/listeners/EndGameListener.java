/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.frame.listeners;

import game.frame.state.StageOverMenuState;
import game.frame.Application;

/**
 *
 * @author albc
 */
 public class EndGameListener implements EndStateListener{
        private Application context;

        public EndGameListener(Application context) {
            this.context = context;
        }
        
        
        @Override
        public void stateEnded() {
            
            context.setStatus(new StageOverMenuState(context.getStart(),context.getStageOver(),context.getLevelOver(),context.getCurrentGameLevel(),context.getCurrentPlayer(),context.getCurrentControllers()));
             
        }
        
    }