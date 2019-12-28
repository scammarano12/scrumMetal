/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.state;

import java.awt.Point;
import java.util.List;
import javax.swing.SwingUtilities;
import game.state.stateListeners.EndStateListener;
import game.levels.GameLevel;
import game.GameSettings;
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
        private Player player;
        private EndStateListener listener;
        
        
        public void initLevel(){
            this.gl= new GameLevel(1,3);
        }
        
        public void execute(){
            initLevel();
            this.player = new Player(new Point(0,0),GameSettings.PlayerDimension.width,GameSettings.PlayerDimension.height,"player",new Weapon(2));
            player.setState(new PlayerStopLeft());
            //GameStatus.setGameStatus(1);
                    SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    listener.stateEnded();//To change body of generated methods, choose Tools | Templates.
                }
            });
                    
        }

            
           
            
        

        @Override
        public void escape() {
            
        }

        @Override
        public void end() {
            
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
            return null;
        }
    }