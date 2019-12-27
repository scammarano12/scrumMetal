/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameState;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import menu.MenuPause;
import metalscrum.CharacterController;
import metalscrum.EndStateListener;
import metalscrum.GameLevel;
import metalscrum.Player;
import metalscrum.State;

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