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
public class Drawer {
    private static Scene scene;
    
    public  static void setScene(Scene scene){
        Drawer.scene=scene;
    }
    
    public static void addToDraw(Drawable d){
        Drawer.scene.addToDraw(d);
    }
    
    public static void removeFromDraw(Drawable d){
        Drawer.scene.removeFromDraw(d);
    }
    
   
    
    public static Scene getScene(){
        return scene;
    }
    
    public static void resetScene(){
        Drawer.scene.reset();
               
    }
            
    
   
    
    
}
