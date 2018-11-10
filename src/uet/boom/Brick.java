package uet.boom;

import javax.swing.*;
import java.awt.*;

public class Brick extends Actor {
    private Image image;
    public Brick(int x , int y){
        super(x,y);
        initBrick();

    }
    private void initBrick(){
        ImageIcon icon = new ImageIcon("src/sprites/brick.png");
        image = icon.getImage();
        setImage(image);
    }
}
