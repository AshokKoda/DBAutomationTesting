package com.bridgelabz.db.automation;

import com.bridgelabz.common.Constant;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseClass {
    Connection connection;

    @BeforeTest
    public Connection setUp(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println("JDBC Driver is found");
        } catch (ClassNotFoundException e) {
            //System.out.println("JDBC Driver class is not found");
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(Constant.dbUrl, Constant.userName, Constant.password);
            //System.out.println("Connection is established.");
        } catch (SQLException e) {
            e.printStackTrace();
            //System.out.println("Connection can not established.");
        }
        return connection;
    }

    @AfterTest
    public void tearDown() throws SQLException {
        connection.close();
    }
}
