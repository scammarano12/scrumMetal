/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalscrum;

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
    
    private int levelNumber;
    private int resumeEnemies;
    private int stageNumber;
    private int stageLimit;

    public GameLevel(int levelNumber,int stageLimit) {
        this.levelNumber = levelNumber;
        this.resumeEnemies = 0;
        this.stageNumber = 1;
        this.stageLimit=stageLimit;
    }

    public void setResumeEnemies(int resumeEnemies) {
        this.resumeEnemies = resumeEnemies;
    }

    public int getResumeEnemies() {
        return resumeEnemies;
    }

    public void nextStage() {
        this.stageNumber++;
    }
    
    
    
    public boolean checkNextStage(){
       
        return stageLimit!=(stageNumber-1);
    }
    public  List<Point> createStage(){
        
        Drawable background = new Drawable() {
            @Override
            public Image getDraw() {
                ImageIcon ii = new ImageIcon("src/resources/Levels/Level"+levelNumber+"/background.png");
                return ii.getImage();
            }

            @Override
            public Point getPosition() {
                return new Point(0,0);
            }

            @Override
            public void draw() {
                Scene.getInstance().addToDraw(this);
            }

            @Override
            public void unDraw() {
                Scene.getInstance().removeFromDraw(this);
            }
        };
        
        background.draw();
        
        LinkedList<Point> positions = new LinkedList<>();
        try {
            System.out.println("src/resources/Levels/Level"+levelNumber+"/stage"+stageNumber+".txt");
            Reader is = new FileReader("src/resources/Levels/Level"+levelNumber+"/stage"+stageNumber+".txt");
            Scanner s = new Scanner(is);
            int width =25;
            int heigth =16;
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
                         resumeEnemies++;
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
