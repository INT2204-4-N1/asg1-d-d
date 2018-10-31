package Dictionary;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class controllerAdd {
    @FXML
    TextField textField;
    @FXML
    TextArea textArea;
    @FXML
    Button ok;

    public void addWord(){
        String them = textField.getText();
        String nghia = textArea.getText();
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
            Controller.stageAdd.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
