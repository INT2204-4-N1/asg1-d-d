package Dictionary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    private static String typeOfDictionary = "av";
    private PreparedStatement preparedStatement = null;
    private Connection conn = JDBC_Connection.getConnection();
    private ResultSet rs = null;
    @FXML
    private AnchorPane root;
    @FXML
    private ListView<String> list = new ListView<>() ;
    @FXML
    private ObservableList<String> items = FXCollections.observableArrayList();
    @FXML
    private TextField textField;
    @FXML
    private WebView webView;
    @FXML
    private Button Add;
    @FXML
    private Button Delete;
    @FXML
    private Button Repair;
    @FXML
    private Button Sound;
    @Override
    public void initialize(URL Location , ResourceBundle resourceBundle)
    {
        list.setItems(items);
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
    public void SearchButtonEvent(KeyEvent event) throws SQLException {
        String query = "Select * from " + typeOfDictionary + " WHERE word=?";
        preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, textField.getText());
        rs = preparedStatement.executeQuery();
        if (event.getCode().equals(KeyCode.ENTER)) {
            String text = textField.getText();
            if ("".equals(text)) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("THÔNG BÁO");
                alert.setHeaderText("                      TỪ CHƯA ĐƯỢC NHẬP!");
                alert.setContentText("*WARNING: FBI");
                alert.show();
            } else if (list.getSelectionModel().getSelectedItem() == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("THÔNG BÁO");
                alert.setHeaderText("                      TỪ KHÔNG HỢP LỆ!");
                alert.setContentText("*WARNING: FBI");
                alert.show();
            } else {
                while (rs.next()) {
                    webView.getEngine().loadContent(rs.getString("html"));
                    System.out.println(rs.getString("html"));
                }
                preparedStatement.close();
                rs.close();
            }
        }
    }



}
