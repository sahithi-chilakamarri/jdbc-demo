package com.stackroute;

import java.sql.*;
import java.util.Scanner;

public class JdbcTransactionDemo {
    public void jdbcTransactionDemo() {
        try {
            //Loading the driver and registering with the manager
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            //Estalishing the connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");
            //We are setting autocommit false so that it don't commit itself
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Employee values(?,?,?,?)");
            //Creating scanner object to take the input fro the user
            Scanner scanner = new Scanner(System.in);
            System.out.println("Insert values");
            int id = scanner.nextInt();
            String name = scanner.next();
            int age = scanner.nextInt();
            String gender = scanner.next();
            //If the name length is greater than the length that we given in the database it has to raise a exception
            if (name.length() > 20) {
                throw new Exception();
            }
            //Otherwise the values are inserted
            else {
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, name);
                preparedStatement.setInt(3, age);
                preparedStatement.setString(4, gender);
                preparedStatement.executeUpdate();
                //Committing the inserted values
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //This exception we are handling by taking the rollback method
        catch (Exception e) {
            try {
                assert connection != null;
                connection.rollback();
                System.out.println("Transaction rolled back");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
