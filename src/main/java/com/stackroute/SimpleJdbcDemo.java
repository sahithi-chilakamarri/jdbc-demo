package com.stackroute;

import java.sql.*;

public class SimpleJdbcDemo {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    //To get the details of the employees from the database
    public void getEmployeeDetails() {

        try {
            //Loading the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Registering the driver with drivermanager and establishing connection
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from Employee");) {
            //Get the details using resultset
            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Get the employee details in reverse order
    public void getEmployeeDetailsInReverseOrder() {
        try {
            //Loading the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Registering the driver with drivermanager and establishing connection
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from Employee");) {
            //Cursor goes to the after last
            resultSet.afterLast();
            //Get the details using resultset in reverse order
            while (resultSet.previous()) {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getEmployeeDetailsFromSecondRowInReverse() {
        try {
            //Loading the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Registering the driver with drivermanager and establishing connection
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from Employee");) {
            //Cursor goes to the second row
            resultSet.absolute(2);
            //Get the details using resultset in reverse order
            while (resultSet.previous()) {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Get the details using preparedstatement
    public void getEmployeeDetailsByNameAndGender() {
        String statement = "select name,gender from Employee";
        try {
            //Loading the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Registering the driver with drivermanager and establishing connection
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");
             //Prepared statement object
             PreparedStatement preparedStatement = connection.prepareStatement(statement);
             ResultSet resultSet = preparedStatement.executeQuery();) {
            //Get the details using resultset
            while (resultSet.next()) {
                System.out.println("Name: " + resultSet.getString(1) + " Gender: " + resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
