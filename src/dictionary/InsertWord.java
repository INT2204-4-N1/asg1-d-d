package dictionary;

import java.sql.*;
import java.util.Scanner;

/**
 * class dùng  để thêm từ mới vào trong dictionary
 */
public class InsertWord {

    Scanner sc = new Scanner(System.in);

    public void insert(){
        Connection conn = JDBC_connect.getConnection();
        // khai báo 2 biến word , detail;
        String word , detail;
        System.out.println("nhập từ cần thêm");
        word = sc.nextLine();
        System.out.println("nhập nghĩa");
        detail = sc.nextLine();

        String sql = "insert into tbl_edict(word , detail) values(?,?)";

        // truyền thông tin vào đối tượng PreparedStatement
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, word);
            ps.setString(2 , detail);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}