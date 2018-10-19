//package Dictionary;
//import javafx.scene.control.ScrollPane;
//import javafx.scene.web.WebEngine;
//import javafx.scene.web.WebView;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class webview_Show {
//    final WebView webView = new WebView();
//    final WebEngine engine = new WebEngine();
//    public webview_Show(){
//        engine.loadContent("");
//    }
//    public void mean(String tuMoi , ScrollPane pane) {
//       // pane.setContent(webView);
//       // engine.loadContent(tuMoi);
//
//        Connection conn = JDBC_Connection.getConnection();
//        String sql = "select * from tbl_edict";
//        try {
//            PreparedStatement ptmt = conn.prepareStatement(sql);
//            ResultSet rs = ptmt.executeQuery();
//            while (rs.next())
//            {
//                String tu = rs.getString("word");
//                String nghia = rs.getString("detail");
//                if(tuMoi.equals(tu)) {
//                    pane.setContent(nghia);
//                }
//            }
//
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//}
