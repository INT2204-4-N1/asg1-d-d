package dictionary;

import jdk.internal.util.xml.impl.Input;

import java.awt.*;
import java.beans.EventHandler;
import java.sql.*;
import java.util.Scanner;
import java.awt.event.KeyEvent ;

/**
 * class hiển thị thông tin của database
 */
public class Display_data {

    Display dl = new Display();

    public void Output_search() {
        Connection conn = JDBC_connect.getConnection();
        String sql = "select * from tbl_edict";
        String search = dl.Input.getText().toString();

                try {
                    PreparedStatement ps = conn.prepareStatement(sql);

                    // khởi tạo resultset
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {

                        String word = rs.getString("word");
                        String tail = rs.getString("detail");

                        if (search.equals(word)) {
                            dl.Output.setText(tail);
                        }
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

    }


