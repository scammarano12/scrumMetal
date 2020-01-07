/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.levels;

import game.powerUp.ArmorPowerUp;
import game.scene.Scene;
import game.GameSettings;
import game.powerUp.WeaponPowerUp;
import game.objects.Block;
import game.frame.Application;
import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
    
    private  int levelNumber;
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
    
    public synchronized void nextLevel() {
        System.out.println("nextLevel :"+Thread.currentThread().getName());
        this.levelNumber++;
        
    }
    public synchronized boolean checkNextLevel() {
        System.out.println("checknextLevel :"+Thread.currentThread().getName());
       
        if((levelNumber-1) < 3 )
            return true;
        else{
            levelNumber = 1;
            return false;
        }
        
    }
    
    
    
    
    
    public synchronized boolean checkNextStage(){
       System.out.println("check :"+Thread.currentThread().getName());
        //return 
        if((stageNumber-1)<stageLimit )
            return true;
        else{
            stageNumber = 1;
            return false;
        }
                    
    }
    public synchronized Map<String,List<Point>> createStage(){
        System.out.println("create :"+Thread.currentThread().getName());
        Scene.getInstance().setBackground(new ImageIcon("src/resources/Levels/Level"+levelNumber+"/background.png").getImage().getScaledInstance(GameSettings.FrameDimension.width,GameSettings.FrameDimension.height, Image.SCALE_DEFAULT));
        HashMap<String,List<Point>> positions = new HashMap<>();
        LinkedList<Point> enemy = new LinkedList<>();
        LinkedList<Point> player = new LinkedList<>();
        LinkedList<Point> fenemy = new LinkedList<>();
        LinkedList<Point> boss= new LinkedList<>();
        try {
            System.out.println("src/resources/Levels/Level"+levelNumber+"/stage"+stageNumber+".txt");
            
            Reader is = new FileReader("src/resources/Levels/Level"+levelNumber+"/stage"+stageNumber+".txt");
            Scanner s = new Scanner(is);
            int width =GameSettings.BlockDimension.width;
            int height =GameSettings.BlockDimension.height;
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
                        
                        Block b = new Block(new Point((count-last)*width,j*height),width*last ,height,"block");
                        
                        b.draw();
                        b.activeCollision();
                       
                        last=0;
                        }
                    }
                    if(c=='p'){
                        player.add(new Point(count*width,j*height));
                        count++;
                    }
                    if(c=='0'){
                        count++;
                    }
                    if(c=='e'){
                         enemy.add(new Point(count*width,j*height));
                         count++;
                         
                    }
                    if(c=='f'){
                         fenemy.add(new Point(count*width,j*height));
                         count++;
                         
                    }
                    if(c=='a'){
                         ArmorPowerUp ap = new ArmorPowerUp(new Point(count*width,j*height),GameSettings.ArmorPowerUp.width,GameSettings.ArmorPowerUp.height,"powerUp");
                         ap.draw();
                         ap.activeCollision();
                         count++;
                    
                    }
                    if(c=='b'){
                        boss.add(new Point(count*width,j*height));
                        count++;
                        
                    }
                    if(c=='w'){
                        WeaponPowerUp wp = new WeaponPowerUp(new Point(count*width,j*height),GameSettings.WeaponPowerUp.width,GameSettings.WeaponPowerUp.height,"powerUp");
                        wp.draw();
                        wp.activeCollision();
                       
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
        
        positions.put("p", player);
        positions.put("e", enemy);
        positions.put("f", fenemy);
        positions.put("b", boss);
        return positions;
    }

    public void setLevel(int i, int i0) {
        this.stageNumber=i0 ;
        this.levelNumber= i ; 
    }

    
}
