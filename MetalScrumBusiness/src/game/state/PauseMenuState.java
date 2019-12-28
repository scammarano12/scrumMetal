/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.state;

import java.util.List;
import game.menu.MenuPause;
import game.state.stateListeners.EndStateListener;
import game.levels.GameLevel;
import game.character.Player;
import game.character.controller.CharacterController;

/**
 *
 * @author albc
 */
public class PauseMenuState implements State{
        private MenuPause pause;
        private List<CharacterController> controllers;
        private GameLevel gl;
        private Player player;

        public PauseMenuState(MenuPause pause, List<CharacterController> controllers, GameLevel gl, Player player) {
            this.pause = pause;
            this.gl=gl;
            this.controllers=controllers;
            this.player=player;
        }
        
        public void execute(){
            
            if(!pause.isVisible()){
                pause.setVisible(true);
                pause.requestFocusInWindow();
               }
        }
        

        @Override
        public void escape() {
//            
        }

        @Override
        public void end() {
            
                        pause.setVisible(false);
                    
        }

        @Override
        public void setListener(EndStateListener listener) {
            
        }

        @Override
        public Player getPlayer() {
            return player;
        }

        @Override
        public GameLevel getGameLevel() {
            return gl;
        }

        @Override
        public List<CharacterController> getControllers() {
            return controllers;
        }
    }