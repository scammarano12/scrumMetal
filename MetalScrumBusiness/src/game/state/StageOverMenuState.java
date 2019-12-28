/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.state;

import java.util.List;
import game.menu.MenuLevelTerminated;
import game.menu.MenuStageTerminated;
import game.state.stateListeners.EndStateListener;
import game.levels.GameLevel;
import game.character.Player;
import game.character.controller.CharacterController;
import game.scene.Scene;

/**
 *
 * @author albc
 */
 public class StageOverMenuState implements State{
        
        private MenuStageTerminated stageOver;
        private MenuLevelTerminated levelOver;
        private GameLevel gl;
        private Scene sc;
        private Player player;
        private List<CharacterController> controllers;
        
        public StageOverMenuState(MenuStageTerminated stageOver, MenuLevelTerminated levelOver,GameLevel gl, Player player,List<CharacterController> controllers) {
            this.stageOver = stageOver;
            this.levelOver = levelOver;
            this.gl=gl;
            this.sc=Scene.getInstance();
            this.controllers=controllers;
            this.player=player;
        }
        
        
        public void execute(){
          
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

        @Override
        public void escape() {
            
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