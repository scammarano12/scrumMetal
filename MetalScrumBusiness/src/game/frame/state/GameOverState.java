/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.frame.state;

import game.character.player.PlayerInterface;
import java.util.List;
import game.menu.MenuGameOver;
import game.frame.listeners.EndStateListener;
import game.levels.GameLevel;

import game.character.CharacterController;

/**
 *
 * @author albc
 */
 public class GameOverState implements State{
        private MenuGameOver gameOver;

        public GameOverState(MenuGameOver gameOver) {
            this.gameOver = gameOver;
        }
        
        
        public void start(){
        
        if(!gameOver.isVisible()){
                System.out.println("GameOver");
                
                gameOver.setVisible(true);
                gameOver.requestFocusInWindow();
              
            
        }}
        
        
        public void execute(){
           
        }

      
        @Override
        public void end() {
           
                        gameOver.setVisible(false);
                   
            
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
