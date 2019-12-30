/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.state;

import game.PlayerInterface;
import java.util.List;
import game.menu.MenuLevelTerminated;
import game.menu.MenuStageTerminated;
import game.state.stateListeners.EndStateListener;
import game.levels.GameLevel;

import game.character.controller.CharacterController;
import game.scene.Scene;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author albc
 */
 public class StageOverMenuState implements State{
        
        private MenuStageTerminated stageOver;
        private MenuLevelTerminated levelOver;
        private GameLevel gl;
        private Scene sc;
        private PlayerInterface player;
        private List<CharacterController> controllers;
        
        public StageOverMenuState(MenuStageTerminated stageOver, MenuLevelTerminated levelOver,GameLevel gl, PlayerInterface player,List<CharacterController> controllers) {
            this.stageOver = stageOver;
            this.levelOver = levelOver;
            this.gl=gl;
            this.sc=Scene.getInstance();
            this.controllers=controllers;
            this.player=player;
        }
        
        
        public void execute(){
          
            
        }

       

        @Override
        public void end() {
            
             levelOver.setVisible(false);
             stageOver.setVisible(false);
                    
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

        
    @Override
    public void start() {
        if(!stageOver.isVisible() && !levelOver.isVisible()){
                gl.nextStage();
            
                sc.setVisible(false);
                if(gl.checkNextStage()){
                    stageOver.setVisible(true);
                    stageOver.requestFocusInWindow();
                }else{
                    levelOver.setVisible(true);
                    levelOver.requestFocusInWindow();
                    
                }
            }
    }
    }