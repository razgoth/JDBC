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
        Connection c = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(DRIVER_CLASS);
            c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("connected");
            stmt = c.createStatement();

                   rs = stmt.executeQuery("SELECT 15 AS retval;");

            while (rs.next()) {
                String ssn = rs.getString("retval");
                System.out.println(ssn);

            }
            rs.close();
            stmt.close();
            c.close();


        } catch (Exception e) {
            System.out.println("failed: something went wrong: " + e.getLocalizedMessage());
            System.exit(0);
        }
    }
}
