package game;


import java.awt.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author stefano
 */
public class GameSettings {
    public static Rectangle FrameDimension = new Rectangle(1280,720);
    public static Rectangle PlayerDimension = new Rectangle(40,48);
    public static Rectangle EnemyDimension = new Rectangle(40,48);
    public static Rectangle FlyingEnemyDimension = new Rectangle(40,48);
    public static Rectangle BlockDimension = new Rectangle(40,24);
    public static Rectangle BulletDimension = new Rectangle(36,12);
    public static Rectangle FlyingBulletDimension = new Rectangle(20,20);
    public static Rectangle HealthBarDimension = new Rectangle(150,150/3);
    public static Rectangle BossDimension = new Rectangle(200,240);
    public static Rectangle ArmorPowerUp = new Rectangle(40,48);
    public static Rectangle PlayerArmorDecorator = new Rectangle(40,48);
    public static Rectangle WeaponPowerUp = new Rectangle(40,48);
    public static Rectangle AereoBossDimension = new Rectangle(200,240);
}
