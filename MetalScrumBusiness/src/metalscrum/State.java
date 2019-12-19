/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalscrum;

import java.util.List;

/**
 *
 * @author stefano
 */
public interface State {
    public void execute();
    public void escape();
    public void end();
    public void setListener(EndStateListener listener);
    public Player getPlayer();
    public GameLevel getGameLevel();
    public List<CharacterController> getControllers();
}
