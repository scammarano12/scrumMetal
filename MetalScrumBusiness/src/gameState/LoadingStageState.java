/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameState;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import listeners.PlayerListener;
import metalscrum.Application;
import metalscrum.CharacterController;
import metalscrum.CollisionController;
import metalscrum.Direction;
import metalscrum.EndStateListener;
import metalscrum.Enemy;
import metalscrum.EnemyController;
import metalscrum.GameLevel;
import metalscrum.Player;
import metalscrum.PlayerController;
import metalscrum.Scene;
import metalscrum.State;
import metalscrum.Weapon;

public class LoadingStageState implements State{
        private Scene sc;
        private CollisionController cc;
        private Player player;
        private List<CharacterController> controllers;
        private GameLevel gl;
        private PlayerListener pl;
        
        private EndStateListener listener;
        public LoadingStageState(GameLevel gl,Player player,List<CharacterController> controllers,PlayerListener pl) {
            this.sc = Scene.getInstance();
            this.cc= CollisionController.getInstance();
            this.gl=gl;
            this.player=player;
            this.controllers=controllers;
            this.pl=pl;
            
        }
        public void initPlayer(Point position,Player player){
             player.setPosition(position);

             PlayerController controller = new PlayerController();
             controller.setListener(pl);
             controllers.add(controller);

             controller.addMovable(player);
             sc.addKeyListener(controller);
             player.draw();
             cc.addSubject(player);
             cc.addObject(player);  
    }
        public void initEnemy(List<Point> positions){
        
        //da spostare, magari, in quale classe apposita a fare ciò!
 
        
        
        
            for(int i=0; i<positions.size(); i++){
                //Aggiunto SSS
                Enemy enemy = new Enemy(positions.get(i),50,45,"enemy",true,2,Direction.LEFT,new Weapon(2));

                EnemyController controller = new EnemyController(100,300);

                controllers.add(controller);

                controller.addMovable(enemy);
                //associare all'enemy un timer per spostarsi e sparare!
                enemy.draw();
                enemy.activeCollision();
                //CollisionSystem.addCollisionObject(enemy);
            }
        
        
        }
        public void initStage(){
            controllers = new LinkedList<>();


            List<Point> l = gl.createStage();
            initPlayer(l.remove(0),player);
            initEnemy(l);
        
             
    }
        public void execute(){
            sc.reset();
            cc.reset();

            controllers.forEach(c-> c.deActive());
            System.out.println("loading");

            initStage();

            

            //GameStatus.setGameStatus(0);

            sc.setVisible(true);
            sc.requestFocusInWindow();
            listener.stateEnded();
            
            
        }

        @Override
        public void escape() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void end() {
            
        }

        @Override
        public void setListener(EndStateListener listener) {
            this.listener=listener;
        }

        @Override
        public Player getPlayer() {
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