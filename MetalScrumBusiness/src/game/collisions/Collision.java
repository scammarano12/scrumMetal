/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.collisions;

import game.objects.SolidObject;

/**
 *
 * @author stefano
 */
public class Collision {
    private boolean left;
    private boolean rigth;
    private boolean top;
    private boolean down;
    private SolidObject subject;
    private SolidObject object;
    
    public Collision(SolidObject subject,SolidObject object, boolean left,boolean rigth,boolean top,boolean down){
        this.left=left;
        this.rigth=rigth;
        this.down = down;
        this.top = top;
        this.subject=subject;
        this.object=object;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRigth() {
        return rigth;
    }

    public void setRigth(boolean rigth) {
        this.rigth = rigth;
    }

    public boolean isTop() {
        return top;
    }

    public void setTop(boolean top) {
        this.top = top;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public SolidObject getSubject() {
        return subject;
    }

    public void setSubject(SolidObject subject) {
        this.subject = subject;
    }

    public SolidObject getObject() {
        return object;
    }

    public void setObject(SolidObject object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Collision{" + "left=" + left + ", rigth=" + rigth + ", top=" + top + ", down=" + down + ", subject=" + subject + ", object=" + object + '}';
    }

   
    
    
    
    
}
