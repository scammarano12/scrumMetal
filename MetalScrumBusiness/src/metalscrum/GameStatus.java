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
public class GameStatus {
    private static int gameStatus=3; 
    
    public static void setGameStatus(int gs){
        GameStatus.gameStatus=gs;
    }
    
     public static int getGameStatus(){
        return GameStatus.gameStatus;
    }
    
    
    
}
