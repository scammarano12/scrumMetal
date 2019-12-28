/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.state;

import java.util.List;
import game.menu.MenuStart;
import game.state.stateListeners.EndStateListener;
import game.levels.GameLevel;
import game.character.Player;
import game.character.controller.CharacterController;

public class StartMenuState implements State{
        private MenuStart start;

        public StartMenuState(MenuStart start) {
            this.start = start;
        }
        
        public void start(){
            if(!start.isVisible()){
                        
                        start.setVisible(true);
                        start.requestFocusInWindow();
                     
            }
        }
        
        
        public void execute(){
        
        }

        

        @Override
        public void end() {
           if(start.isVisible()){
              
              start.setVisible(false);
           }
            
           
        
        }

        @Override
        public void setListener(EndStateListener listener) {
            
        }

        @Override
        public Player getPlayer() {
            return null;
        }

        @Override
        public GameLevel getGameLevel() {
            return null;
        }

        @Override
        public List<CharacterController> getControllers() {
            return null;
        }
    }
