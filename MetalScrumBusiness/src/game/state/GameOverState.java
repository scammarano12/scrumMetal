/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.state;

import java.util.List;
import game.menu.MenuGameOver;
import game.state.stateListeners.EndStateListener;
import game.levels.GameLevel;
import game.character.Player;
import game.character.controller.CharacterController;

/**
 *
 * @author albc
 */
 public class GameOverState implements State{
        private MenuGameOver gameOver;

        public GameOverState(MenuGameOver gameOver) {
            this.gameOver = gameOver;
        }
        
        public void execute(){
           
        if(!gameOver.isVisible()){
                System.out.println("GameOver");
                
                gameOver.setVisible(true);
                gameOver.requestFocusInWindow();
              
            
        }}

        @Override
        public void escape() {
            
        }

        @Override
        public void end() {
           
                        gameOver.setVisible(false);
                   
            
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
