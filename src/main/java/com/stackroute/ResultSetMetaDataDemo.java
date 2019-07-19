package com.stackroute;

import java.sql.*;

public class ResultSetMetaDataDemo {
    //It is used for the demo for resultset
    public void resultSetDemo() {
        try {
            //Loading the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Registering with driver manager and establishing the connection
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from Employee");) {
            //Getting the data from the ResultSetMetaData
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            //Know columncount and column name
            System.out.println("Total Columns: " + resultSetMetaData.getColumnCount());
            System.out.println("First Column Name: " + resultSetMetaData.getColumnName(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
