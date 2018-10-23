package Dictionary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Controller  {

public static Stage stageAdd;
public static Stage stageTran;
public static Stage stageRepair;


    @FXML
    private AnchorPane root;
    @FXML
    private TextArea textArea;
    @FXML
    private ListView<String> list = new ListView<>() ;
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
    @FXML
    private Button ggtranslate;

    public void Search(KeyEvent event){
        Connection conn = JDBC_Connection.getConnection();
        ArrayList<String> arrayList = new ArrayList<>();
        String sql = "select word from tbl_edict";
        String tuNhap = textField.getText();
        try {
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ResultSet rs = ptmt.executeQuery();
            while (rs.next()){
                String goiY = rs.getString("word");
                if(goiY.startsWith(tuNhap)){
                    arrayList.add(goiY);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        list.getItems().setAll(arrayList);
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
            stageAdd = new Stage();
            stageAdd.setScene(new Scene(root1));
            stageAdd.show();
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
         stageRepair= new Stage();
        stageRepair.setScene(new Scene(root1));
        stageRepair.show();
    } catch(Exception e) {
        e.printStackTrace();
    }

}
    public void googleTraslate(ActionEvent event){
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample4.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stageTran = new Stage();
        stageTran.setScene(new Scene(root1));
        stageTran.show();
    } catch(Exception e) {
        e.printStackTrace();
    }
}
}
