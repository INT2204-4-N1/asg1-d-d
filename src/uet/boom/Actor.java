package uet.boom;

import java.awt.*;

public class Actor {
    private final int SPACE = 17;

    private int x;
    private int y;
    private Image image;

    public Actor(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image img) {
        image = img;
    }

    public int x() {

        return x;
    }

    public int y() {

        return y;
    }

    public void setX(int x) {

        this.x = x;
    }

    public void setY(int y) {

        this.y = y;
    }
    public boolean isLeft(Actor actor){
        return x() - SPACE == actor.x() && y() == actor.y();
    }
    public boolean isRight(Actor actor){
        return x() + SPACE == actor.x() && y()==actor.y();
    }
    public boolean isTop(Actor actor){
        return y() - SPACE == actor.y() && x() == actor.x();
    }
    public boolean isBot(Actor actor){
        return y() + SPACE == actor.y() && x() == actor.x();
    }
}
