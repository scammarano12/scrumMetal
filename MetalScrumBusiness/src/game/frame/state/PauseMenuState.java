/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.frame.state;

import game.character.player.PlayerInterface;
import java.util.List;
import game.menu.MenuPause;
import game.frame.listeners.EndStateListener;
import game.levels.GameLevel;

import game.character.CharacterController;

/**
 *
 * @author albc
 */
public class PauseMenuState implements State{
        private MenuPause pause;
        private List<CharacterController> controllers;
        private GameLevel gl;
        private PlayerInterface player;

        public PauseMenuState(MenuPause pause, List<CharacterController> controllers, GameLevel gl, PlayerInterface player) {
            this.pause = pause;
            this.gl=gl;
            this.controllers=controllers;
            this.player=player;
        }
        public void start(){
        if(!pause.isVisible()){
                pause.setVisible(true);
                pause.requestFocusInWindow();
               }
        }
        public void execute(){
           
            
        }
        

       

        @Override
        public void end() {
            
           pause.setVisible(false);
                    
        }

        @Override
        public void setListener(EndStateListener listener) {
            
        }

        @Override
        public PlayerInterface getPlayer() {
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