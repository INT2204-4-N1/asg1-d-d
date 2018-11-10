package uet.boom;

import javax.swing.*;
import java.awt.*;

public class Grass extends Actor {
    private Image image;
    public Grass(int x , int y){
        super(x,y);
        initGrass();

    }
    private void initGrass(){
        ImageIcon icon = new ImageIcon("src/sprites/grass.png");
        image = icon.getImage();
        setImage(image);
    }
}
