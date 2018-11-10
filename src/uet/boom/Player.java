package uet.boom;

import javax.swing.*;
import java.awt.*;

public class Player extends Actor{
    private Image image;
    public Player(int x , int y){
        super(x,y);
        initPlayer();

    }
    private void initPlayer(){
        ImageIcon icon = new ImageIcon("src/sprites/player_right.png");
        image = icon.getImage();
        setImage(image);
    }
}