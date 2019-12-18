/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalscrum;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;

import java.util.List;
import javax.swing.SwingWorker;

/**
 *
 * @author stefano
 */
public class CollisionController {
    
    private static CollisionController instance = null;

    private List<SolidObject> subjects;
    private List<SolidObject> objs;
    
    private CollisionController(){
         this.subjects = new LinkedList<>();
        this.objs = new LinkedList<>();
        
    }
    
    public static CollisionController getInstance(){
        if(CollisionController.instance == null){
            instance = new CollisionController();
            
        }
        
        return instance;
        
    }
    

    public void addSubject(SolidObject o) {
        subjects.add(o);
        
    }

    public void removeSubject(SolidObject o) {
         subjects.remove(o);
        
        
    }

    public  void addObject(SolidObject o) {
        objs.add(o);
           
    }

    public void removeObject(SolidObject o) {
        objs.remove(o);
         
    }

    
    public void reset(){
       List<SolidObject> subjects = new LinkedList<>();
       List<SolidObject> objs = new LinkedList<>();
        
    }

    public void checkCollision() {
        
        List<Collision> collisions = new LinkedList<>();
        
        for (SolidObject subject : subjects) {
            Collision collision = new Collision(subject, null, false, false, false, false);
            Rectangle subjectHitBox = subject.getHitbox();
            
            for (SolidObject object :objs) {
               
                Rectangle objHitBox = object.getHitbox();
                if (subjectHitBox.intersects(objHitBox) && object.isVisible() && !object.getId().equals(subject.getId())) {
                    collision.setObject(object);
                
                    if (subjectHitBox.y  > objHitBox.y ) {
                        collision.setTop(true);
                        
                    }
                    if (subjectHitBox.y + subjectHitBox.height == objHitBox.y + 1) {
                        collision.setDown(true);
                       
                    }
                    
                    if ( subjectHitBox.x+subjectHitBox.width-1 == objHitBox.x && (subjectHitBox.y+subjectHitBox.height -1 > objHitBox.y || subjectHitBox.y < objHitBox.y + objHitBox.height)) {
                        
                        collision.setRigth(true);
                        
                    }
                    if (subjectHitBox.x == objHitBox.x + objHitBox.width - 1 && (subjectHitBox.y+subjectHitBox.height -1 > objHitBox.y || subjectHitBox.y < objHitBox.y + objHitBox.height)) {
                        collision.setLeft(true);
                    }
                    
                   
                } 
                
               
             }
             collisions.add(collision);
            
        }
        
        for(Collision c : collisions){
            c.getSubject().setCollision(c);
            
            if(c.getObject()!= null){
                c.getObject().setCollision(c);
            }
            
        }
    }

}
