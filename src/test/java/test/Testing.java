package test;

import com.bridgelabz.common.Constant;
import org.junit.Test;

import java.sql.*;

public class Testing {

    static Connection connection;
    PreparedStatement ps;

    @Test
    public void read() throws SQLException {
        System.out.println("----------Fetch data from database---------");
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(Constant.fetchQuery);
        while (rs.next()) {
            int personID = rs.getInt(1);
            String firstName = rs.getString(2);
            String lastName = rs.getString(3);
            int age = rs.getInt(4);
            System.out.println(personID + " " + firstName + " " + lastName + " " + age + " ");
        }
    }
}
