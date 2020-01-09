/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.character.boss;

import game.character.enemy.EnemyStopLeft;
import game.objects.SolidObject;
import game.objects.movable.Direction;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.LinkedList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author stefano
 */
public class BossStopLeft extends EnemyStopLeft{
        private final int step =50;
        private Clip clipUp;
        private Clip clipDown;
        private int sound;
        public BossStopLeft(){
            super();
            initMusic();
            sound=0;
        }
    
        
        @Override
        protected void setAnimation(){
        
     
        Image walking1 = SolidObject.loadImage("src/resources/boss1/fermo/fermoSinistra1.png",game.GameSettings.BossDimension.width,game.GameSettings.BossDimension.height);
        Image walking2 = SolidObject.loadImage("src/resources/boss1/fermo/fermoSinistra2.png",game.GameSettings.BossDimension.width,game.GameSettings.BossDimension.height);
        Image walking3 = SolidObject.loadImage("src/resources/boss1/fermo/fermoSinistra3.png",game.GameSettings.BossDimension.width,game.GameSettings.BossDimension.height);
        Image walking4 = SolidObject.loadImage("src/resources/boss1/fermo/fermoSinistra2.png",game.GameSettings.BossDimension.width,game.GameSettings.BossDimension.height);
        Image walking5 = SolidObject.loadImage("src/resources/boss1/fermo/fermoSinistra1.png",game.GameSettings.BossDimension.width,game.GameSettings.BossDimension.height);
       
       
        
        for(int j = 0;j<step;j++ ){
            listImage.addLast(walking1);
        }
        
        for(int j = 0;j<step;j++ ){
            listImage.addLast(walking2);
        }
        for(int j = 0;j<step;j++ ){
            listImage.addLast(walking3);
        }
        for(int j = 0;j<step;j++ ){
            listImage.addLast(walking4);
        }
        for(int j = 0;j<=step;j++ ){
            listImage.addLast(walking5);
        }
        
    
    }
        
     
        @Override
        public Image nextImage() {
        sound++;
        System.out.println("prova"+sound);
        
        if(sound ==1) {
            clipDown.start();
            System.out.println("down");
            
        }
        else if(sound == (2.5*step)+1){
            
            clipDown.stop();
             
            clipUp.start();
            System.out.println("start");
            
        }
        if(sound == (5*step)+1){
            clipUp.stop();
            clipUp.setMicrosecondPosition(0);
            clipDown.setMicrosecondPosition(0);
            sound =0;
        }
        
       
        
        Image i = listImage.remove(0);
        listImage.addLast(i);
        return i;
        
    }
    
    public  void initMusic() {
        try {
            clipUp = AudioSystem.getClip();
            clipDown = AudioSystem.getClip();
           
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("src/resources/boss1/fermo/up.wav")));
             BufferedInputStream bf = new BufferedInputStream(inputStream);
            
             inputStream = new AudioInputStream(bf,inputStream.getFormat(),inputStream.getFrameLength());
             
             
             
             clipUp.open(inputStream);
             
             inputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("src/resources/boss1/fermo/down.wav")));
             bf = new BufferedInputStream(inputStream);
            
             inputStream = new AudioInputStream(bf,inputStream.getFormat(),inputStream.getFrameLength());
             
             clipDown.open(inputStream);
             
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    
    }
    
}

