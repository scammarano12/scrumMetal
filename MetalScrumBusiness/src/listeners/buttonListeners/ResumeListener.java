/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners.buttonListeners;

import gameState.InGameState;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import listeners.GameListener;
import metalscrum.Application;

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
           
            context.end();
            context.setStatus(new InGameState(context.getCurrentControllers(), context.getCurrentGameLevel(),context.getCurrentPlayer(),gameListener));
           
            
            
        }
    
    }