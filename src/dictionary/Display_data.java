package dictionary;

import java.sql.*;
import java.util.Scanner;

/**
 * class hiển thị thông tin của database
 */
public class Display_data {

    Scanner sc = new Scanner(System.in);

    public void Display(){
        Connection conn = JDBC_connect.getConnection();
        String sql = "select * from tbl_edict";
        System.out.println("nhập từ cần tìm");
        String newWord = sc.nextLine();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            // khởi tạo resultset
            ResultSet rs = ps.executeQuery();
            while (rs.next()){

                String word = rs.getString("word");
                String tail = rs.getString("detail");

                if(newWord.equals(word)){
                    System.out.println(word+"   "+ tail);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}