/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.character.boss;

import game.character.enemy.EnemyStopLeft;
import game.objects.SolidObject;
import java.awt.Image;

/**
 *
 * @author lucap
 */
public class AereoBossStopLeft extends EnemyStopLeft{
    
     
    
        @Override
        protected void setAnimation(){
        
       
        Image stop = SolidObject.loadImage("src/resources/boss2/fermo/fermoSinistra.png",game.GameSettings.BossDimension.width,game.GameSettings.BossDimension.height);
        listImage.add(stop);
        
        
    
    }
    
    
}
