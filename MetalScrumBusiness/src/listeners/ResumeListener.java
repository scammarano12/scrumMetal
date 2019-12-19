/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import gameState.InGameState;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import metalscrum.Application;

/**
 *
 * @author albc
 */
 public class ResumeListener implements ActionListener{
        private Application context;

        public ResumeListener(Application context) {
            this.context = context;
        }
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            context.getStatus().end();
            context.setStatus(new InGameState(context.getCurrentControllers(), context.getCurrentGameLevel(),context.getCurrentPlayer(),new GameListener(context)));
            
            
            
        }
    
    }