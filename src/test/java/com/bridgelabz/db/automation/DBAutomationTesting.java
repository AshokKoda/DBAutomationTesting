package com.bridgelabz.db.automation;

import com.bridgelabz.common.Constant;
import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class DBAutomationTesting extends BaseClass {

    PreparedStatement ps;
    @Test
    public void insert() {
        connection = this.setUp();
        try {
            ps = connection.prepareStatement(Constant.insertQuery);
            System.out.println("----------Insert data---------");
            Random rand = new Random();
            int id = rand.nextInt(999);
            ps.setInt(1, id);
            ps.setString(2, "Lasya");
            ps.setString(3, "Sree");
            ps.setInt(4, 12);
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
        count();
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

    @Test
    public void count() throws SQLException {
        connection = this.setUp();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(Constant.countQuery);
        while (rs.next()) {
            int count = rs.getInt(1);
            System.out.println("Total count : " + count);
        }
        System.out.println("-------------------------------------------------------");
    }
}
