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
public class LevelBuilder {
    
    
    
    public static List<Point> createStage(int levelNumber ,int number){
        
        Drawer.getScene().addToDraw(new Drawable() {
            @Override
            public Image getDraw() {
                ImageIcon ii = new ImageIcon("src/resources/Levels/Level"+levelNumber+"/background.png");
                return ii.getImage();
            }

            @Override
            public Point getPosition() {
                return new Point(0,0);
            }
        });
        
        LinkedList<Point> positions = new LinkedList<>();
        try {
            Reader is = new FileReader("src/resources/Levels/Level"+levelNumber+"/stage"+number+".txt");
            Scanner s = new Scanner(is);
            int width =40;
            int heigth =24;
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
                        
                        Block b = new Block(new Point((count-last)*width,j*heigth),width*last ,heigth,"block",true);
                        Drawer.addToDraw(b);
                        CollisionSystem.addCollisionObject(b);
                       
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
                
               
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return positions;
    }

    
}
