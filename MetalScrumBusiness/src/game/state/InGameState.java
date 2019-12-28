/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.state;

import java.util.List;
import game.listeners.GameListener;
import game.collisions.CollisionController;
import game.state.stateListeners.EndStateListener;
import game.levels.GameLevel;
import game.character.Player;
import game.character.controller.CharacterController;
import game.character.state.playerState.*;
import game.objects.movable.Direction;
import game.scene.Scene;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.SwingUtilities;

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
        
        @Override
        public void start(){
            
            if(player.getCurrentDir() == Direction.LEFT)
                player.setState(new PlayerStopLeft());
            else
                 player.setState(new PlayerStopRight());
            if(!sc.isVisible()){
                sc.setVisible(true);
                sc.requestFocusInWindow();
                KeyListener[] kls = sc.getKeyListeners();
                //risoluzione problema -> key released non veniva intercettato
                for(KeyListener kl : kls){
                    kl.keyReleased(new KeyEvent(sc,19,System.currentTimeMillis(),19,KeyEvent.VK_LEFT,'z'));
                }
            }
        
            
        }
        
        public void execute(){
           
            cc.checkCollision();
                int enemyCounter=-1;
                for(CharacterController c :controllers){
                    c.updatePositions();
                    if(c.isActive())
                        enemyCounter++;
                }
                gl.setResumeEnemies(enemyCounter);
                
            
               
                if(enemyCounter==0)
                    SwingUtilities.invokeLater(new Runnable(){
                @Override
                public void run() {
                    listener.stateEnded();
                }
            });
                    
                             
                 
               
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