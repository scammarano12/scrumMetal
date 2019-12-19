/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import javax.swing.JPanel;

/**
 *
 * @author donatospigapiena
 */
public class Menu {
    
    public static MenuStart getStartMenu(){
    
            return new MenuStart();
    }
    public static MenuPause getPauseMenu(){
    
            return new MenuPause();
    }
}
