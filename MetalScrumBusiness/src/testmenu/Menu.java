/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testmenu;

import javax.swing.JPanel;

/**
 *
 * @author donatospigapiena
 */
public class Menu {
    
    public static JPanel getStartMenu(){
    
            return new MenuStart();
    }
    public static JPanel getPauseMenu(){
    
            return new MenuPause();
    }
}
