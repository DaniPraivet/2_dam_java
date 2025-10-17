package AD.Práctica3;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDB {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/world?useSSL=false&serverTimezone=UTC",
                "Desarrollador",
                "usuario"
        );
        System.out.println("Conexión OK");
        conn.close();
    }
}