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
import listeners.GameListener;
import metalscrum.CharacterController;
import metalscrum.CollisionController;
import metalscrum.EndStateListener;
import metalscrum.GameLevel;
import metalscrum.Player;
import metalscrum.Scene;
import metalscrum.State;

/**
 *
 * @author albc
 */
public class InGameState implements State{
        private Scene sc;
        private CollisionController cc;
        private List<CharacterController> controllers;
        private GameLevel gl;
        private EndStateListener listener;
        private GameListener gameListener;
        private Player player;

        public InGameState(List<CharacterController> controllers,GameLevel gl,Player player, GameListener gameListener) {
            this.sc = Scene.getInstance();
            this.cc= CollisionController.getInstance();
            this.controllers=controllers;
            this.gl=gl;
            this.gameListener = gameListener;
            this.player=player;
            sc.removeKeyListener(gameListener);
            sc.addKeyListener(gameListener);
        }
        
        public void execute(){
            
            if(!sc.isVisible()){
                sc.setVisible(true);
                sc.requestFocusInWindow();
            }
            
            cc.checkCollision();
                int enemyCounter=-1;
                for(CharacterController c :controllers){
                    c.updatePositions();
                    if(c.isActive())
                        enemyCounter++;
                }
                gl.setResumeEnemies(enemyCounter);
                
            
               
                if(enemyCounter==0)
                    listener.stateEnded();
                    //GameStatus.setGameStatus(5);          
                 
               
        }

        @Override
        public void escape() {
            
        }

        @Override
        public void end() {
                        sc.setVisible(false);
                        sc.removeKeyListener(gameListener);
                    
        }

        @Override
        public void setListener(EndStateListener listener) {
            this.listener=listener;
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