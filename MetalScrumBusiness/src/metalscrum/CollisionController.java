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

    private List<SolidObject> subjects;
    private List<SolidObject> objs;
    
    

    public synchronized void addSubject(SolidObject o) {
        subjects.add(o);
        
    }

    public  synchronized void removeSubject(SolidObject o) {
         subjects.remove(o);
        
        
    }

    public  synchronized void addObj(SolidObject o) {
        objs.add(o);
           
    }

    public synchronized void removeObj(SolidObject o) {
        objs.remove(o);
         
    }

    public CollisionController() {
        this.subjects = new LinkedList<>();
        this.objs = new LinkedList<>();

    }
    
    public void reset(){
        objs.removeAll(objs);
        subjects.removeAll(subjects);
        
    }

    public synchronized void checkCollision() {
        
        List<Collision> collisions = new LinkedList<>();
        
        for (SolidObject subject : subjects) {
            
            Rectangle subjectHitBox = subject.getHitbox();
            Collision collision = new Collision(subject, null, false, false, false, false);
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
                    
                    
                   /* 
                    subject.setCollision(collision);
                    object.setCollision(collision);
*/
                } 
                collisions.add(collision);
                
               

            }
            
        }
        
        for(Collision c : collisions){
            c.getSubject().setCollision(c);
            
            if(c.getObject()!= null){
                c.getObject().setCollision(c);
            }
            
        }
    }

}
