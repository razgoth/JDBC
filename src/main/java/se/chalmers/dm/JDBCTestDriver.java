package se.chalmers.dm;

import java.sql.*;

import static java.lang.Class.forName;

public class JDBCTestDriver {
    // DB connection configuration
    private static String DRIVER_CLASS = "org.postgresql.Driver";
    private static String DB_USER = "postgres";
    private static String DB_PASSWORD = "Teach321";
    private static String DB_URL = "jdbc:postgresql://localhost:5432/websitedb";
    private static int EXIT_FAILURE = 1;

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        try {
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("connected");
            statement = connection.createStatement();

            result = statement.executeQuery("SELECT 15 AS retval;");

            while (result.next()) {
                String table = result.getString("retval");
                System.out.println(table);

            }
            result.close();
            statement.close();
            connection.close();


        } catch (Exception e) {
            System.out.println("failed: something went wrong: " + e.getLocalizedMessage());
            System.exit(0);
        }
    }
}
