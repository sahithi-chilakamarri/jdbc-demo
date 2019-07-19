package com.stackroute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcBatchDemo {
    public void jdbcBatchDemo() {
        try {
            //Loading the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        try {
            //Registering the driver from driver manager
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");
            Statement statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            // Create statement object
            assert connection != null;
            Statement stmt = connection.createStatement();
            // Set auto-commit to false
            connection.setAutoCommit(false);
            // create table query
            String query1 = "CREATE TABLE user(user_id integer, user_name varchar(20))";
            stmt.addBatch(query1);
            // insert query
            String query2 = "INSERT INTO user (user_id, user_name) VALUES(1,'Brijesh')";
            stmt.addBatch(query2);
            // insert query
            String query3 = "INSERT INTO user (user_id, user_name) VALUES(2,'Raj Singh')";
            stmt.addBatch(query3);
            // insert query
            String query4 = "INSERT INTO user (user_id, user_name) VALUES(3,'Ankit')";
            stmt.addBatch(query4);
            // insert query
            String query5 = "INSERT INTO user (user_id, user_name) VALUES(4,'Raj')";
            stmt.addBatch(query5);
            // Update row value query
            String query6 = "UPDATE user SET user_name = 'Ravi' WHERE user_id = 1";
            stmt.addBatch(query6);
            // delete record from the table query
            String query7 = "Delete from user where user_id=3";
            stmt.addBatch(query7);
            stmt.executeBatch();
            System.out.println("Batch processing is done");
            // connection commited
            connection.commit();
        } catch (SQLException s) {
            System.out.println("SQL Exception " + s);
        }
    }
}
