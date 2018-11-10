package uet.boom;

import java.awt.*;

public class Actor {
    private final int SPACE = 16;

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
}
