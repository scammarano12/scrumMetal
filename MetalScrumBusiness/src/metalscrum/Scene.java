/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalscrum;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author stefano
 */
public class Scene extends JPanel {
    private List<Drawable> objects;
    public static Scene instance = null;
   
    
    private Scene(){
        objects = new LinkedList<>();
      
    }
    
    public static Scene getInstance(){
        if(instance==null){
            instance = new Scene();
        }
        return instance;
    }
    
    public synchronized void addToDraw(Drawable d){
        objects.add(d);
    }
    
    public synchronized void removeFromDraw(Drawable d){
       objects.remove(d);
        
    }
    
   public synchronized void reset(){
       objects.removeAll(objects);
   }
    
    
    @Override
    public synchronized void paint(Graphics g){
       
        for(Drawable d: objects){
            g.drawImage(d.getDraw(), d.getPosition().x, d.getPosition().y, this);
           
            //g.drawRect(d.getDraw().x, d.getDraw().y, d.getDraw().width, d.getDraw().height);
        }
        
    }
        
    
    
}
