package com.stackroute;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseMetaDataDemo {
    public void databaseMetaDataDemo() {
        /*Load the Jdbc Driver*/
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            /*Register the driver with the driver manager*/
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseMetaData databaseMetaData = null;
        try {
            /*It is used to get the database meta data*/
            assert connection != null;
            databaseMetaData = connection.getMetaData();
            /*It gives all the information related to the database*/
            System.out.println("Driver Name: " + databaseMetaData.getDriverName());
            System.out.println("Driver Version: " + databaseMetaData.getDriverVersion());
            System.out.println("UserName: " + databaseMetaData.getUserName());
            System.out.println("Database Product Name: " + databaseMetaData.getDatabaseProductName());
            System.out.println("Database Product Version: " + databaseMetaData.getDatabaseProductVersion());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
