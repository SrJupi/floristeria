package ConnectionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectBD {

    private static final String CONTROLLER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/floristeria";
    private static final String USER = "root";
    private static final String KEY = "ItAcademy";

    public Connection connect() {
        Connection conn = null;

        try {
            Class.forName(CONTROLLER);
            conn = DriverManager.getConnection(URL, USER, KEY);
            System.out.println("Connected");

        }catch(ClassNotFoundException e) {
            System.out.println("Connection failed: driver error");

        }catch(SQLException e) {
            System.out.println("Connection failed");
        }

        return conn;
    }
}

