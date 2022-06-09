package com.bridgelabz.db.automation;

import com.bridgelabz.common.Constant;
import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAutomationTesting extends BaseClass {

    PreparedStatement ps;
    @Test
    public void insert() {
        connection = this.setUp();
        try {
            ps = connection.prepareStatement(Constant.insertQuery);
            System.out.println("----------Insert data---------");
            ps.setInt(1, 102);
            ps.setString(2, "demo");
            ps.setString(3, "Week");
            ps.setInt(4, 10);
            ps.executeUpdate();
            System.out.println("Data inserted successfully...");
            read();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void read() throws SQLException {
        connection = this.setUp();
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

    @Test
    public void update() throws SQLException {
        connection = this.setUp();
        System.out.println("----------Update data---------");
        ps = connection.prepareStatement(Constant.updateQuery);
        ps.setString(1, "Kalpu");
        ps.setString(2, "Dasu");
        ps.setInt(3, 25);
        ps.setInt(4, 101);
        ps.executeUpdate();
        System.out.println("Person data updated successfully.");
        read();
    }

    @Test
    public void delete() throws SQLException {
        connection = this.setUp();
        System.out.println("----------Delete data---------");
        ps = connection.prepareStatement(Constant.deleteQuery);
        ps.setInt(1, 102);
        ps.executeUpdate();
        System.out.println("Person data deleted successfully.");
        read();
    }
}
