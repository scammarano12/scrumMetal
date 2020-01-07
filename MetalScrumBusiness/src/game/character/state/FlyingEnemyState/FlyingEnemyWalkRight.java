/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.character.state.FlyingEnemyState;


import game.character.state.enemyState.*;
import game.character.state.CharacterState;
import java.awt.Image;
import java.util.LinkedList;
import game.objects.movable.Direction;
import game.objects.SolidObject;

/**
 *
 * @author stefano
 */
public class FlyingEnemyWalkRight extends CharacterState{
    
    public FlyingEnemyWalkRight(){
        super.currentDir = Direction.RIGHT;
        super.listImage = new LinkedList<>();
        setAnimation();
        
    }
    
   
   private void setAnimation(){
        
       
        Image stop = SolidObject.loadImage("./src/resources/nemicovolante/fermo/fermoDestra.png",game.GameSettings.FlyingEnemyDimension.width,game.GameSettings.FlyingEnemyDimension.height);
        listImage.add(stop);
        
        
    
    }

    @Override
    public Direction getDir() {
        return currentDir; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Image nextImage() {
        return listImage.get(0);
    }
}
