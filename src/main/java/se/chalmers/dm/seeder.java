package se.chalmers.dm;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static se.chalmers.dm.QueryHelper.sqlQuery;

public class seeder {
    public static void createUserTable() throws SQLException {
        PreparedStatement stat = ConnectionHelper.createPostgresConnection().prepareStatement(sqlQuery("create_user_table.sql"));
        stat.executeUpdate();
        System.out.println("table created ");
    }

    public static void insertFakeUsers(int i) {

    }
}
