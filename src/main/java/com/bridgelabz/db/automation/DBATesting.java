package com.bridgelabz.db.automation;

import com.bridgelabz.common.Constant;
import java.sql.*;

public class DBATesting {
    static Connection connection;
    PreparedStatement ps;


    public void create() throws SQLException {
        System.out.println("----------Insert data---------");
        ps = connection.prepareStatement(Constant.insertQuery);
        ps.setInt(1, 110);
        ps.setString(2, "Lasya");
        ps.setString(3, "Sree");
        ps.setInt(4, 12);
        ps.executeUpdate();
        System.out.println("Data inserted successfully...");
    }
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

    public void update() throws SQLException {
        System.out.println("----------Update data---------");
        ps = connection.prepareStatement(Constant.updateQuery);
        ps.setString(1, "Mohan");
        ps.setString(2, "Das");
        ps.setInt(3, 15);
        ps.setInt(4, 107);
        ps.executeUpdate();
        System.out.println("Person data updated successfully.");
    }

    public void delete() throws SQLException {
        System.out.println("----------Delete data---------");
        ps = connection.prepareStatement(Constant.deleteQuery);
        ps.setInt(1, 106);
        ps.executeUpdate();
        System.out.println("Person data deleted successfully.");
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver is found");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver class is not found");
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(Constant.dbUrl, Constant.userName, Constant.password);
            System.out.println("Connection is established.");

            DBATesting dbaTesting = new DBATesting();
            //dbaTesting.create();
            //dbaTesting.update();
            dbaTesting.delete();
            dbaTesting.read();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection can not established.");
        }
    }
}
