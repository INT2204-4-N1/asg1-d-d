package Dictionary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class Controller implements Initializable {


    @FXML
    private AnchorPane root;
    @FXML
    private TextArea textArea;
    @FXML
    private ListView<String> list = new ListView<>() ;
    @FXML
    private ObservableList<String> items = FXCollections.observableArrayList();
    @FXML
    private TextField textField;
    @FXML
    private Button add;
    @FXML
    private Button delete;
    @FXML
    private Button repair;
    @FXML
    private Button sound;

    @Override
    public void initialize(URL Location , ResourceBundle resourceBundle)
    {
        list.setItems(items);
        Connection conn = JDBC_Connection.getConnection();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select word from tbl_edict");
            while (rs.next())
            {
                items.add(rs.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mean(KeyEvent event) {
        String moiNhap = textField.getText().trim();
        if(event.getCode() == KeyCode.ENTER) {
            Connection conn = JDBC_Connection.getConnection();
            int i = 0;
            String sql = "select * from tbl_edict";
            try {
                PreparedStatement ptmt = conn.prepareStatement(sql);
                ResultSet rs = ptmt.executeQuery();
                while (rs.next()) {

                    if (moiNhap.equals(rs.getString("word"))) {
                        String nghia = rs.getString("detail");
                        String var1 = nghia.replaceAll("<C><F><I><N><Q>", "\n       ");
                        String var2 = var1.replaceAll("<br />", "\n      ");
                        String var3 = var2.replaceAll("</Q></N></I></F></C>", " ");
                        String var4 = var3.replace("=", "+");
                        textArea.setText(var4);
                        i = 1;
                    }
                }
                if (i == 0) {
                    JOptionPane.showMessageDialog(null, "This word doesn't inside my Dictionary");
                    textField.requestFocus();
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }



    public void addWord(ActionEvent event){

        String them = JOptionPane.showInputDialog("New Word");
        String nghia = JOptionPane.showInputDialog("Mean ");
        Connection conn = JDBC_Connection.getConnection();
        String sql = "insert into tbl_edict(word,detail) values(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, them);
            ps.setString(2, nghia);

            int kt =ps.executeUpdate();
            if(kt != 0){
                JOptionPane.showMessageDialog(null, "added successfully !");
                textField.requestFocus();
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void deleteWord(){
        Connection conn = JDBC_Connection.getConnection();
        String word = textField.getText().toString();
        int click = JOptionPane.showConfirmDialog(null , "Are you sure" , "Question" , JOptionPane.YES_NO_OPTION);
                if(click == JOptionPane.YES_OPTION){
                    String sql = "delete from tbl_edict where word = ?";
                    try {
                        PreparedStatement ptmt = conn.prepareStatement(sql);
                        ptmt.setString(1,word);
                       int kt =  ptmt.executeUpdate();
                       if(kt != 0){
                           JOptionPane.showMessageDialog(null, "delete successfully !");
                           textField.requestFocus();
                       }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
    }


}
