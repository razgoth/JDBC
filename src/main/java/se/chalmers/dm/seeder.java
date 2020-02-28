package se.chalmers.dm;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static se.chalmers.dm.QueryHelper.sqlQuery;
import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;

public class seeder {
     static String Ssn;
     static String FName;
     static String LName;
     static String Email;
     static String IsActive;
    Faker faker = new Faker();
//    String FName = null;
//    String LName= null;
//    String Email = null;
//    String IsActive = null;

    public static void createUserTable() throws SQLException {
        PreparedStatement stat = ConnectionHelper.createPostgresConnection().prepareStatement(sqlQuery("create_user_table.sql"));
        stat.executeUpdate();
        System.out.println("table created ");
    }
   public static void insertFakeUsers(int i) throws SQLException {
        Faker faker = new Faker();

        for (int j = 0; j < i; j ++){
            Ssn = faker.idNumber().ssnValid();
            FName = faker.name().firstName();
            LName = faker.name().lastName();
            Email = faker.internet().emailAddress();
            IsActive = faker.;
           //"insert into tbl_user(Ssn, FName, LName, Email, IsActive) values(" +Ssn +FName+","+LName+"," +Email+","+IsActive+");"
            PreparedStatement stat = ConnectionHelper.createPostgresConnection().prepareStatement("insert into tbl_user(Ssn, FName, LName, Email, IsActive) values('"+Ssn+
                    "', '"+FName+"', '"+LName+"', '"+Email+"', '"+IsActive+"')");
            stat.executeUpdate();
            System.out.println("input inserted ");}
    }
}
