package Dictionary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class controllerRepair {

    @FXML
    TextField textField1;
    @FXML
    TextArea textArea1;
    @FXML
    Button ok;

    public void hienTu(KeyEvent event)
    {
        String moiNhap = textField1.getText().trim();
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
                        textArea1.setText(var4);
                        i = 1;
                    }
                }
                if (i == 0) {
                    JOptionPane.showMessageDialog(null, "This word doesn't inside my Dictionary");
                    textField1.requestFocus();
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void repairWord(ActionEvent event){

        Connection conn = JDBC_Connection.getConnection();
        String sql = "update tbl_edict set detail =? where word = ?";
        String tu = textField1.getText();
        String nghia = textArea1.getText();
        try {
            PreparedStatement ptmt = conn.prepareStatement(sql);

            ptmt.setString(2 , tu);
            ptmt.setString(1 , nghia);

            int kt = ptmt.executeUpdate();
            ptmt.close();
            conn.close();
            if(kt != 0){
                JOptionPane.showMessageDialog(null, "Repair successfully !");
                textField1.requestFocus();
            }
            Controller.stageRepair.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
