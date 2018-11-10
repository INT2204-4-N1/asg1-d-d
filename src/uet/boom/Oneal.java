package uet.boom;

import javax.swing.*;
import java.awt.*;

public class Oneal extends Actor {
    private Image image;
    public Oneal(int x , int y){
        super(x,y);
        initOneal();

    }
    private void initOneal(){
        ImageIcon icon = new ImageIcon("src/sprites/oneal_left1.png");
        image = icon.getImage();
        setImage(image);
    }
}
