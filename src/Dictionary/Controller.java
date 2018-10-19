package Dictionary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    private ScrollPane scrollPane;
//    @FXML
//    private WebView webView;
//     private WebEngine engine;
    @FXML
    private Button add;
    @FXML
    private Button delete;
    @FXML
    private Button repair;
    @FXML
    private Button sound;
    @FXML
    private Button search;
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
//    public void show(ActionEvent event){
//        mean();
//
//
//    }
//    public void showMean(){
//        String text = textField.getText();
//        webview_Show ws = new webview_Show();
//        ws.mean(text , scrollPane);
//    }
    public void mean(ActionEvent event) {
        String moiNhap = textField.getText();
        String tu, nghia;
        Connection conn = JDBC_Connection.getConnection();
        String sql = "select * from tbl_edict";
        try {
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
                tu = rs.getString("word");
                nghia = rs.getString("detail");
                if (moiNhap.equals(tu)) {
                    textArea.setText(nghia);
                }

            }

//            if(moiNhap == tu )
//            {
//                engine.loadContent(nghia);
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }





    public void addWord(ActionEvent event){
      //  Connection conn = JDBC_Connection.getConnection();
     //   TextInputDialog dialog = new TextInputDialog();
     //   dialog.setTitle("Add New Word");
     //   dialog.setContentText("New Word");
     //   Optional<String> them = dialog.showAndWait();
    //    TextInputDialog dialog2 = new TextInputDialog();
    //    dialog2.setTitle("Add Mean");
     //   dialog2.setContentText("Mean");
     //   Optional<String> nghia = dialog2.showAndWait();
        String them = JOptionPane.showInputDialog("New Word");
        String nghia = JOptionPane.showInputDialog("Mean ");
        Connection conn = JDBC_Connection.getConnection();
        String sql = "insert into tbl_edict(word,detail) values(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, them);
            ps.setString(2, nghia);

            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
