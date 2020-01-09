/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.frame.listeners;

import game.frame.state.LoadingStageState;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import game.frame.Application;
import game.frame.state.State;

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
           
            
            
            State s=new LoadingStageState(context.getCurrentGameLevel(),context.getCurrentPlayer(),context.getCurrentControllers(),new PlayerListener(context));
            s.setListener(new LoadedStageListener(context));
            context.setStatus(s);
            
            //GameStatus.setGameStatus(1);
        }
    
    }
