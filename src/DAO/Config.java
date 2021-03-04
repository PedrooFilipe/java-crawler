package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {

    public static Connection createConnection(){
        String host = "localhost";
        String user = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/java-crawler";

        Connection conexao = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (Exception e) {
            e.printStackTrace();
        }

        try {
            conexao = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conexao;
    }
}
