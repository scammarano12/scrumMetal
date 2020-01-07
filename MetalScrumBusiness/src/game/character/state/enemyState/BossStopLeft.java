/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.character.state.enemyState;

import game.objects.SolidObject;
import game.objects.movable.Direction;
import java.awt.Image;
import java.util.LinkedList;

/**
 *
 * @author stefano
 */
public class BossStopLeft extends EnemyStopLeft{
    
     
    
        @Override
        protected void setAnimation(){
        
       
        Image stop = SolidObject.loadImage("src/resources/boss1/fermo/fermoSinistra.png",game.GameSettings.BossDimension.width,game.GameSettings.BossDimension.height);
        listImage.add(stop);
        
        
    
    }
    
    
}
