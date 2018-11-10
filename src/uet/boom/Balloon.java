package uet.boom;

import javax.swing.*;
import java.awt.*;

public class Balloon extends Actor {
    private Image image;
    public Balloon(int x , int y){
        super(x,y);
        initBallon();

    }
    private void initBallon(){
        ImageIcon icon = new ImageIcon("src/sprites/balloom_left1.png");
        image = icon.getImage();
        setImage(image);
    }
}
