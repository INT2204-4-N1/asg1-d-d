package dictionary;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
//import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    JTextField Input;
    JTextArea Output;
    JButton Translate,Add,Delete,b4;
    JLabel english,vietnamese, Title;
    JPanel pn,pn1,pn2;
    static boolean anhViet = true;
    private Border raisedBevel = BorderFactory.createRaisedBevelBorder();
    public Main()
    {
        super("DICTIONARY");
        Title = new JLabel("DICTIONARY");
        Title.setBounds(290,0,200,70);
        Title.setBackground(Color.blue);
        Title.setFont(new Font("Tahoma",Font.PLAIN,22));

        Input = new JTextField();
        Input.setBounds(20,70,170,30);

        Output = new JTextArea();
        Output.setBounds(290,70,400,400);
        Output.setFocusable(false);

        Translate=new JButton("Dịch");
        Translate.setBackground(Color.gray);
        Translate.setBounds(200,70,70,30);

        Add = new JButton("Thêm");
        Add.setBackground(Color.gray);
        Add.setBounds(200,110,70,30);

        Delete = new JButton("Xóa");
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

        Translate.addActionListener(this);
        Add.addActionListener(this);
        Delete.addActionListener(this);
        b4.addActionListener(this);

        pn = new JPanel();
        pn.setLayout(null);
        pn.setBackground(new Color(191, 239, 255));
        pn.add(Translate);pn.add(Input); pn.add(Output); pn.add(Add);pn.add(Delete); pn.add(b4);
        pn.add(english);pn.add(vietnamese);pn.add(Title);
        add(pn);
    }

    public void actionPerformed(ActionEvent arg){

    }
    public static void main(String arg[])
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main Dic = new Main();
                Dic.setSize(700,500);
                Dic.setVisible(true);
                Dic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}
