/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characterState;

import java.awt.Image;
import java.util.LinkedList;
import metalscrum.Direction;

/**
 *
 * @author lucap
 */
public abstract class CharacterState {
    
    protected Direction currentDir ; 
    protected LinkedList<Image> listImage;
    
    public abstract Direction getDir();
    
    public abstract Image nextImage();
}
