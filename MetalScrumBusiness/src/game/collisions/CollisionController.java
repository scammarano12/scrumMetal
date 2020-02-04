/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.collisions;

import game.GameSettings;
import game.objects.SolidObject;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import java.util.List;

/**
 *
 * @author luca pomposelli
 */
public class CollisionController {

    private static CollisionController instance = null;

    private List<SolidObject> subjects;
    private List<SolidObject> objs;

    private CollisionController() {
        this.subjects = new LinkedList<>();
        this.objs = new LinkedList<>();

    }

    public static CollisionController getInstance() {
        if (CollisionController.instance == null) {
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

    public void addObject(SolidObject o) {
        objs.add(o);

    }

    public void removeObject(SolidObject o) {
        objs.remove(o);

    }

    public void reset() {
        subjects.removeAll(subjects);
        objs.removeAll(objs);
        instance.addObject(new SolidObject(new Point(-5, 0), 5, GameSettings.FrameDimension.height, "border") {
            @Override
            public Image getDraw() {
                return new BufferedImage(0, 0, 0); //To change body of generated methods, choose Tools | Templates.
            }
        });
        instance.addObject(new SolidObject(new Point(GameSettings.FrameDimension.width + 5, 0), 5, GameSettings.FrameDimension.height, "border") {
            @Override
            public Image getDraw() {
                return new BufferedImage(0, 0, 0); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    public void checkCollision() {

        List<Collision> collisions = new LinkedList<>();

        for (SolidObject subject : subjects) {
            Collision collision = new Collision(subject, null, false, false, false, false);
            Rectangle subjectHitBox = subject.getHitbox();

            for (SolidObject object : objs) {

                Rectangle objHitBox = object.getHitbox();
                if (subjectHitBox.intersects(objHitBox) && !object.getId().equals(subject.getId())) {
                    collision.setObject(object);

                    if (subjectHitBox.y > objHitBox.y) {
                        collision.setTop(true);
                    }
                    if (subjectHitBox.y + subjectHitBox.height == objHitBox.y + 1) {
                        collision.setDown(true);

                    }

                    if (subjectHitBox.x + subjectHitBox.width - 1 == objHitBox.x && (subjectHitBox.y + subjectHitBox.height - 1 > objHitBox.y || subjectHitBox.y < objHitBox.y + objHitBox.height)) {

                        collision.setRigth(true);

                    }
                    if (subjectHitBox.x == objHitBox.x + objHitBox.width - 1 && (subjectHitBox.y + subjectHitBox.height - 1 > objHitBox.y || subjectHitBox.y < objHitBox.y + objHitBox.height)) {
                        collision.setLeft(true);
                    }
                }
            }

            collisions.add(collision);

        }

        for (Collision c : collisions) {
            c.getSubject().setCollision(c);

            if (!c.getObject().isEmpty()) {
                for (SolidObject so : c.getObject()) {
                    if (!(so.getId().equals("player"))) {

                        so.setCollision(c);
                    }
                }

            }

        }
    }

}
