package uet.boom;

import javax.swing.*;
import java.awt.*;

public class Flame_item extends Actor {
    private Image image;
    public Flame_item(int x , int y){
        super(x,y);
        initFlame();

    }
    private void initFlame(){
        ImageIcon icon = new ImageIcon("src/sprites/powerup_flames.png");
        image = icon.getImage();
        setImage(image);
    }
}
