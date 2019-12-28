/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.listeners;

import game.state.InGameState;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import game.listeners.GameListener;
import game.frame.Application;
import game.state.State;
import game.state.stateListeners.LoadedLevelListener;

/**
 *
 * @author albc
 */
 public class ResumeListener implements ActionListener{
        private Application context;
        private GameListener gameListener;

        public ResumeListener(Application context,GameListener gameListener) {
            this.context = context;
            this.gameListener = gameListener;
        }
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
           
            State s = new InGameState(context.getCurrentControllers(), context.getCurrentGameLevel(),context.getCurrentPlayer(),gameListener);
            s.setListener(new LoadedLevelListener(context));
            context.setStatus(s);
           
            
            
        }
    
    }