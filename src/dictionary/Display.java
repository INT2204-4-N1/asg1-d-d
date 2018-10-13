package dictionary;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
//import java.awt.event.ActionListener;

public class Display extends JFrame implements ActionListener {
    JTextField Input;
    JTextArea Output , Output2;
    JButton Translate,Add,Delete,b4;
    JLabel english,vietnamese, Title;
    JPanel pn,pn1,pn2;
    static boolean anhViet = true;
    private Border raisedBevel = BorderFactory.createRaisedBevelBorder();
    public Display()
    {
        super("DICTIONARY");
        Title = new JLabel("DICTIONARY");
        Title.setBounds(290,0,200,70);
        Title.setBackground(Color.blue);
        Title.setFont(new Font("Tahoma",Font.PLAIN,22));

        Input = new JTextField();
        Input.setBounds(20,70,170,30);

        Output = new JTextArea();
        Output.setBounds(290,70,400,500);
        Output.setFocusable(false);

        Output2 = new JTextArea();
        Output2.setBounds(20,120,170,450);
        Output2.setFocusable(false);


        Add = new JButton("Add");
        Add.setBackground(Color.gray);
        Add.setBounds(200,110,70,30);

        Delete = new JButton("Delete");
        Delete.setBackground(Color.gray);
        Delete.setBounds(200,150,70,30);
        english = new JLabel("Anh");
        vietnamese = new JLabel("Việt");

        english.setBounds(30,40,150,30);
        vietnamese.setBounds(150,40,50,30);


        b4 = new JButton("<->");
        b4.setBackground(new Color(205 , 135, 92));
        b4.setBounds(70,45,70,20);
        b4.setFont(new Font("Tahoma",Font.PLAIN,14));

        // Translate.addActionListener(this);
        Add.addActionListener(this);
        Delete.addActionListener(this);
        b4.addActionListener(this);

        pn = new JPanel();
        pn.setLayout(null);
        pn.setBackground(new Color(191, 239, 255));
        pn.add(Input); pn.add(Output);pn.add(Output2); pn.add(Add);pn.add(Delete); pn.add(b4);
        pn.add(english);pn.add(vietnamese);pn.add(Title);
        add(pn);
        setSize(600,650);
        setLocation(400,50);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent arg){

    }

}