package Dictionary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class Controller implements Initializable {


//    private static final ApplyImports AlertDialog = ;
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


    public void addWord_Key (ActionEvent event) throws Exception{

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample2.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
    public void deleteWord(ActionEvent event){
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
public void repair_Key(ActionEvent event) throws Exception
{
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample3.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    } catch(Exception e) {
        e.printStackTrace();
    }
}
//    public void repairWord(ActionEvent event){
//        Connection conn = JDBC_Connection.getConnection();
//        String sql = "Update tbl_edict set word = ? where detail = ?";
//        try {
//            PreparedStatement ptmt = conn.prepareStatement(sql);
//           // String newDetail = textArea.getPromptText();
//            String newWord = textField.getText();
//           String newDetail = textArea.getText();
//
//            ptmt.setString(1 , newWord);
//            ptmt.setString(2 , newDetail);
//            int kt = ptmt.executeUpdate();
//            if(kt != 0){
//                JOptionPane.showMessageDialog(null, "Repair successfully !");
//                textField.requestFocus();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//    public void speak(ActionEvent event) throws IOException{
//        if (event.getSource() == sound) {
//            String str = (String) list.getSelectionModel().getSelectedItem();
//            String str1 = textField.getText();
//
//
//        }

   // }
}
