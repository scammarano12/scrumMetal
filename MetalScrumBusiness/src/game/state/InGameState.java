/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.state;

import game.PlayerInterface;
import game.menu.HealthBar;
import java.util.List;
import game.listeners.GameListener;
import game.collisions.CollisionController;
import game.state.stateListeners.EndStateListener;
import game.levels.GameLevel;

import game.character.controller.CharacterController;
import game.character.state.playerState.*;
import game.objects.movable.Direction;
import game.scene.Scene;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        private PlayerInterface player;
        private HealthBar bar;
        private boolean inGame;

        public InGameState(List<CharacterController> controllers,GameLevel gl,PlayerInterface player, GameListener gameListener) {
            this.sc = Scene.getInstance();
            this.cc= CollisionController.getInstance();
            this.controllers=controllers;
            this.gl=gl;
            this.gameListener = gameListener;
            this.player=player;
            sc.removeKeyListener(gameListener);
            sc.addKeyListener(gameListener);
            bar = new HealthBar(player);

        }
        
        @Override
        public void start(){
            inGame=true;
           controllers.forEach(c -> c.startLucaHaDecisoCosi());
            bar.draw();
            System.out.println("disegno barra vita");
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
        
        @Override
        public void execute(){
           if(inGame){
            cc.checkCollision();
                int enemyCounter=-1;
                for(CharacterController c :controllers){
                    c.updatePositions();
                    if(c.isActive())
                        enemyCounter++;
                   
                }
                
                
                
            
               
                if(enemyCounter==0){
                    
                    inGame=false;
                    SwingUtilities.invokeLater(new Runnable(){
                @Override
                public void run() {
                    
                        listener.stateEnded();
                    
                   
                }
            });
                }
                    
                             
                 
               
        }
        }

       

        @Override
        public void end() {
                        controllers.forEach(c -> c.stopLucaHaDecisoCosi());
                        sc.setVisible(false);
                        sc.removeKeyListener(gameListener);
                    
        }

        @Override
        public void setListener(EndStateListener listener) {
            this.listener=listener;
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