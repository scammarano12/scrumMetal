/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.frame.state;

import game.character.player.PlayerInterface;
import java.util.List;
import game.menu.MenuStart;
import game.frame.listeners.EndStateListener;
import game.levels.GameLevel;

import game.character.CharacterController;

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
        public PlayerInterface getPlayer() {
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
