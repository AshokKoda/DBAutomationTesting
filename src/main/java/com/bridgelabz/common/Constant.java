package com.bridgelabz.common;

public class Constant {
    //MYSQL Connection
    public static final String dbUrl = "jdbc:mysql://localhost:3306/uploadcsv";
    public static final String userName = "root";
    public static final String password = "Koda@1996";

    //Queries
    public static String insertQuery = "INSERT INTO Person(PersonID, Firstname, Lastname, Age) value (?, ?, ?, ?)";
    public static String fetchQuery = "SELECT * FROM Person";
    public static String updateQuery = "UPDATE Person SET Firstname=?, Lastname=?, Age=? WHERE PersonID=?";
    public static String deleteQuery = "DELETE FROM Person WHERE PersonID=?";
}
