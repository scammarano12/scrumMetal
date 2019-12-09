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
    List<Drawable> objects;
    List<CharacterController> controllers;
    
    public Scene(){
        objects = new LinkedList<>();
        controllers = new LinkedList<>();
    }
    
    public synchronized void addToDraw(Drawable d){
        System.out.println("aggiungo");
        this.objects.add(d);
        
    }
    
    public synchronized void removeFromDraw(Drawable d){
       
        this.objects.remove(d);
        
    }
    
    public synchronized List<Drawable> getObjects(){
        return objects;
    }
    public synchronized List<CharacterController> getControllers(){
        return controllers;
    }
    
    @Override
    public synchronized void paint(Graphics g){
         
        for(Drawable d: objects){
            g.drawImage(d.getDraw(), d.getPosition().x, d.getPosition().y, this);
           
            //g.drawRect(d.getDraw().x, d.getDraw().y, d.getDraw().width, d.getDraw().height);
        }
        
    }
        
    
    public synchronized void createPlayer(){
        
        
    }
    
    
    
}
