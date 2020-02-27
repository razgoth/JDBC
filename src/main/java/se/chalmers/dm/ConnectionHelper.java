package se.chalmers.dm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    private static final String DRIVER_CLASS = "org.postgresql.Driver";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "Teach321";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/websitedb";

    public static Connection createPostgresConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER_CLASS);
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        return connection;
    }
}
