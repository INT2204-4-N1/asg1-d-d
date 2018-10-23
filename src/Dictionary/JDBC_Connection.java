package Dictionary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Connection {
    public static Connection getConnection(){
        final String url = "jdbc:mysql://localhost:3306/dictionaries_2?verifyServerCertificate=false&useSSL=true";
        final String user = "root";
        final String password = "dung99";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                return DriverManager.getConnection(url , user , password);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }
}
