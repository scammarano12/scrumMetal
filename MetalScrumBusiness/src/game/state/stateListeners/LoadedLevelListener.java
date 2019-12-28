/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.state.stateListeners;

import game.state.LoadingStageState;
import java.util.LinkedList;
import game.frame.Application;
import game.state.State;

/**
 *
 * @author albc
 */
 public class LoadedLevelListener implements EndStateListener{
        private Application context;
        private PlayerListener pl;

        public LoadedLevelListener(Application context) {
            this.context = context;
            this.pl= new PlayerListener(context);
        }
        
        
        @Override
        public void stateEnded() {
           
            State s=new LoadingStageState(context.getCurrentGameLevel(),context.getCurrentPlayer(),new LinkedList<>(),pl);
            s.setListener(new LoadedStageListener(context));
            context.setStatus(s);
            
        }
        
    }
