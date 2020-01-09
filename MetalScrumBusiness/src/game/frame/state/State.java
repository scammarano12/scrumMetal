/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.frame.state;

import game.character.player.PlayerInterface;
import game.character.CharacterController;

import java.util.List;
import game.frame.listeners.EndStateListener;
import game.levels.GameLevel;

/**
 *
 * @author stefano
 */
public interface State {
    public void execute();
    public void start();
    public void end();
    public void setListener(EndStateListener listener);
    public PlayerInterface getPlayer();
    public GameLevel getGameLevel();
    public List<CharacterController> getControllers();
}
