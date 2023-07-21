package ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "0417_Thaina";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3307/pessoas";

    public static Connection createConnectionToMySQL() throws SQLException {
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        return connection;
    }
}
