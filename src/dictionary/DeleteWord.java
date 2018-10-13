package dictionary;

import java.sql.*;
import java.util.Scanner;

/**
 * class xóa từ
 */
public class DeleteWord {
    Scanner sc = new Scanner(System.in);
    public void delete(){
        Connection conn = JDBC_connect.getConnection();
        String word;
        System.out.println("nhập từ cần xóa");
        word = sc.nextLine();

        String sql = "delete from tbl_edict where word = ?";
        {
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1,word);
                int kt =  ps.executeUpdate();
                if(kt!=0){
                    System.out.println("xóa thành công");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
