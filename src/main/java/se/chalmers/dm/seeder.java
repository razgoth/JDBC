package se.chalmers.dm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static se.chalmers.dm.ConnectionHelper.createPostgresConnection;
import static se.chalmers.dm.QueryHelper.sqlQuery;

public class seeder {
    public static void createUserTable() throws SQLException {
        Connection connection = createPostgresConnection();
        PreparedStatement stat = connection.prepareStatement(sqlQuery("create_user_table.sql"));
        stat.executeUpdate();
        System.out.println("table created ");
    }
}
