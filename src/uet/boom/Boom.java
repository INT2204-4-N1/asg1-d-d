package uet.boom;

import javax.swing.*;
import java.awt.*;

public class Boom extends JFrame {
    private final int Offset = 30;
    public Boom(){
        initUI();
    }
    private void initUI(){
        Board board = new Board();
        add(board);

        setTitle("BOOM");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(board.getW() + Offset, board.getH()+ 2 *Offset);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    public static void main(String[] abc){
        EventQueue.invokeLater(() -> {
            Boom ex = new Boom();
            ex.setVisible(true);
        });

    }

    }


