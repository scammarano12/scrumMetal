/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners.buttonListeners;

import gameState.StartMenuState;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import metalscrum.Application;

/**
 *
 * @author albc
 */
public class QuitListener implements ActionListener{
        private Application context;

        public QuitListener(Application context) {
            this.context = context;
        }
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            context.getStatus().end();
            context.setStatus(new StartMenuState(context.start));
     
            
        }

}
