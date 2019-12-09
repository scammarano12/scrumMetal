/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metalscrum;

/**
 *
 * @author stefano
 */
public class CollisionSystem {
    private static CollisionController cc;
    
    public  static CollisionController getCollisionController(){
        return CollisionSystem.cc;
    }
    
    public static void setCollisionController(CollisionController cc){
        CollisionSystem.cc=cc;
    }
    
    public static void addCollisionObject(SolidObject o){
        CollisionSystem.cc.addObj(o);
    }
    
    public  static void addCollisionSubject(SolidObject c){
        CollisionSystem.cc.addSubject(c);
    }
    
    
    
    
}
