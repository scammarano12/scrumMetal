/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.state;

import java.awt.Point;
import java.util.List;

import game.state.stateListeners.EndStateListener;
import game.levels.GameLevel;
import game.GameSettings;
import game.character.PlayerInterface;
import game.character.Player;
import game.character.controller.CharacterController;
import game.character.state.playerState.PlayerStopLeft;
import game.objects.Weapon;

/**
 *
 * @author albc
 */
public class LoadingLevelState implements State{
        private GameLevel gl;
        private PlayerInterface player;
        private EndStateListener listener;
        
        public LoadingLevelState(GameLevel gl){
             this.gl = gl;
            this.player = new Player(new Point(0,0),GameSettings.PlayerDimension.width,GameSettings.PlayerDimension.height,"player",new Weapon(2));
        }
        
        
        public void initLevel(){
            gl.setLevel(1,3);
            
        }
        
        
        public void start(){
            
            
            player.setState(new PlayerStopLeft());
            listener.stateEnded();//To change body of generated methods, choose Tools | Templates.
            
        }
        
        public void execute(){
            
                    
        }

   

        @Override
        public void end() {
            
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
            return null;
        }
    }
