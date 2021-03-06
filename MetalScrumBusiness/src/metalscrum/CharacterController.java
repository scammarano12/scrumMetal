/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalscrum;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author stefano
 */
public abstract class CharacterController{
    
    protected List<Movable> characters;
    protected int gravitylv;
    protected int dx;
    protected int dy;
    protected boolean shoot;
    protected boolean isActive;
    
    public CharacterController(){
        this.gravitylv=1;
        this.dx=0;
        this.dy=0;
        this.characters=new LinkedList<>();
        this.shoot=false;
        this.isActive=true;
    }
    
    public void addMovable(Movable m){
        this.characters.add(m);
    }
    
    public void removeMovable(Movable m){
        this.characters.remove(m);
    }
    
    public abstract void updatePositions();
    
    public void deActive(){
        isActive=false;
        this.characters.removeAll(characters);
    }
    
    public boolean isActive(){
        return isActive;
    }
    
    
}
