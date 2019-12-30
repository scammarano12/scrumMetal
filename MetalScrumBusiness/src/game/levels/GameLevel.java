/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.levels;

import game.scene.Scene;
import game.GameSettings;
import game.objects.Block;
import game.frame.Application;
import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author stefano
 */
public class GameLevel {
    
    private final int levelNumber;
    private int stageNumber;
    private final int stageLimit;

    public GameLevel(int levelNumber,int stageLimit) {
        this.levelNumber = levelNumber;
      
        this.stageNumber = 1;
        this.stageLimit=stageLimit;
    }

   

    

    public synchronized void nextStage() {
        System.out.println("nextstage :"+Thread.currentThread().getName());
        
        this.stageNumber++;
    }
    
    
    
    public synchronized boolean checkNextStage(){
       System.out.println("check :"+Thread.currentThread().getName());
        //return 
        if((stageNumber-1)<stageLimit)
            return true;
        else{
            stageNumber = 1;
            return false;
        }
                    
    }
    public synchronized List<Point> createStage(){
        System.out.println("create :"+Thread.currentThread().getName());
        Scene.getInstance().setBackground(new ImageIcon("src/resources/Levels/Level"+levelNumber+"/background.png").getImage().getScaledInstance(GameSettings.FrameDimension.width,GameSettings.FrameDimension.height, Image.SCALE_DEFAULT));
        LinkedList<Point> positions = new LinkedList<>();
        try {
            System.out.println("src/resources/Levels/Level"+levelNumber+"/stage"+stageNumber+".txt");
            
            Reader is = new FileReader("src/resources/Levels/Level"+levelNumber+"/stage"+stageNumber+".txt");
            Scanner s = new Scanner(is);
            int width =GameSettings.BlockDimension.width;
            int heigth =GameSettings.BlockDimension.height;
            int j =0;
            int count = 0;
            int last = 0;
            while(s.hasNext()){
                String level = s.nextLine();
                count=0;
                last=0;
                for(int i =0; i<level.length();i++){
                    char c = level.charAt(i);
                    
                    if(c=='1'){
                        last++;
                        count++;
                    }else{
                        if((last>0 && c!='\t')){
                        
                        Block b = new Block(new Point((count-last)*width,j*heigth),width*last ,heigth,"block");
                        
                        b.draw();
                        b.activeCollision();
                       
                        last=0;
                        }
                    }
                    if(c=='p'){
                        positions.addFirst(new Point(count*width,j*heigth));
                        count++;
                    }
                    if(c=='0'){
                        count++;
                    }
                    if(c=='e'){
                         positions.addLast(new Point(count*width,j*heigth));
                         count++;
                         
                    }
                }
                j++;
            }
                
               
            
          is.close();
          s.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GameLevel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return positions;
    }

    
}
