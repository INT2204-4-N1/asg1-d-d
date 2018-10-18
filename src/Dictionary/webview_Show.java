package Dictionary;
import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class webview_Show {
    @FXML
    private WebView webView;
   private WebEngine engine;
    public webview_Show(){
        engine = webView.getEngine();
    }

    public void mean() {
        Connection conn = JDBC_Connection.getConnection();
        String sql = "select * from tbl_edict";
        try {
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ResultSet rs = ptmt.executeQuery();
            while (rs.next())
            {
                String tu = rs.getString("word");
                String nghia = rs.getString("detail");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
