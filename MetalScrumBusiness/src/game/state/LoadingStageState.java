/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.state;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import javax.swing.SwingUtilities;
import game.state.stateListeners.PlayerListener;
import game.collisions.CollisionController;
import game.state.stateListeners.EndStateListener;
import game.levels.GameLevel;
import game.GameSettings;
import game.character.BossEnemy;
import game.character.PlayerInterface;
import game.character.Enemy;
import game.character.FlyingEnemy;
import game.character.controller.BossEnemyController;

import game.character.controller.CharacterController;
import game.character.controller.EnemyController;
import game.character.controller.FlyingEnemyController;
import game.character.controller.PlayerController;
import game.character.state.FlyingEnemyState.FlyingEnemyWalkRight;
import game.character.state.enemyState.EnemyWalkRight;
import game.objects.BossEnemyWeapon;
import game.scene.Scene;
import game.objects.Weapon;
import java.util.HashMap;
import java.util.Map;

public class LoadingStageState implements State{
        private Scene sc;
        private CollisionController cc;
        private PlayerInterface player;
        private List<CharacterController> controllers;
        private GameLevel gl;
        private PlayerListener pl;
        
        private EndStateListener listener;
        
        public LoadingStageState(GameLevel gl,PlayerInterface player,List<CharacterController> controllers,PlayerListener pl) {
            this.sc = Scene.getInstance();
            this.cc= CollisionController.getInstance();
            this.gl=gl;
            this.player=player;
            this.controllers=controllers;
            this.pl=pl;
            
        }
        public void initPlayer(Point position,PlayerInterface player){
             player.setPosition(position);
             
             player.setHealth(player.getHealth()*4/player.getMaxHealth());
             player.setMaxHealth(4);
             System.out.println(player.getHealth() +" "+player.getMaxHealth() );
             player.getWeapon().setRateo(3);

             PlayerController controller = new PlayerController();
             controller.setListener(pl);
             controllers.add(controller);

             controller.addMovable(player.getMovable());
             sc.addKeyListener(controller);
             player.draw();
             cc.addSubject(player.getSolidObject());
             cc.addObject(player.getSolidObject());  
    }
        public void initEnemy(List<Point> positions,String type){
        
        //da spostare, magari, in quale classe apposita a fare ciò!
 
        
        
        
            for(int i=0; i<positions.size(); i++){
                
                Enemy enemy = null;
                
                CharacterController controller = null;
                //Aggiunto SSS
                if(type.equals("e")){
                    enemy = new Enemy(positions.get(i),GameSettings.EnemyDimension.width,GameSettings.EnemyDimension.height,"enemy",2,new Weapon(2));
                    enemy.setState(new EnemyWalkRight());
                    controller = new EnemyController(100,300);
                }
                else{
                    enemy = new FlyingEnemy(positions.get(i),GameSettings.EnemyDimension.width,GameSettings.EnemyDimension.height,"enemy",2,new Weapon(2));
                    enemy.setState(new FlyingEnemyWalkRight());
                    controller = new FlyingEnemyController(100,300);
                }
               
                
                controllers.add(controller);
                controller.addMovable(enemy);
                
                //associare all'enemy un timer per spostarsi e sparare!
                enemy.draw();
               
                enemy.activeCollision();
            
                //CollisionSystem.addCollisionObject(enemy);
            }
        
        
        }
        
        public void initBoss(List<Point> position){
            if(!position.isEmpty()){
                Point p = position.get(0);
                BossEnemy be = new BossEnemy(p,GameSettings.EnemyDimension.width*3,GameSettings.EnemyDimension.height*3,"boss",10,new BossEnemyWeapon(10));
                BossEnemyController bec = new BossEnemyController();
                bec.addMovable(be);
                be.draw();
                be.activeCollision();
                controllers.add(bec);
            }
        
        }
        public void initStage(){
            controllers = new LinkedList<>();

            Map<String,List<Point>> l = gl.createStage();
            initPlayer( l.get("p").get(0) , player);
            initEnemy(l.get("e"),"e");
            initEnemy(l.get("f"),"f");
            initBoss(l.get("b"));
        
             
    }
        public void start(){
            sc.reset();
            cc.reset();

            controllers.forEach(c-> c.deActive());
            System.out.println("loading");

            initStage();

             listener.stateEnded();//To change body of generated methods, choose Tools | Templates.
              
        }
            
        public void execute(){
            
            
        }

       

        @Override
        public void end() {
            
        }

        @Override
        public void setListener(EndStateListener listener) {
            this.listener=listener;
        }

        @Override
        public PlayerInterface getPlayer() {
            return player;
        }

        @Override
        public GameLevel getGameLevel() {
            return gl;
        }

        @Override
        public List<CharacterController> getControllers() {
            return controllers;
        }
    }
