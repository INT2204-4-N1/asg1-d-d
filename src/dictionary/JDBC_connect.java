package dictionary;
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class JDBC_connect {
    public static Connection getConnection(){
        final String url = "jdbc:mysql://localhost:3306/Dictionaries?verifyServerCertificate=false&useSSL=true";
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