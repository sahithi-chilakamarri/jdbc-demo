package com.stackroute;

import com.sun.rowset.JdbcRowSetImpl;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class RowSetDemo {
    public void rowSetDemo(){
        try {
            //Loading the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //Creating objects for the JdbcRowSetImplementation class
            JdbcRowSetImpl jrs = new JdbcRowSetImpl();
            //Setting the connection with the database
            jrs.setUrl("jdbc:mysql://localhost:3306/employeedb");
            //Setting the username and password
            jrs.setUsername("root");
            jrs.setPassword("Root@123");
            //Giving the query to execute
            jrs.setCommand("SELECT * FROM Employee where Name=?");
            //Setting the name of which it have to return
            jrs.setString(1,"Bhargavi");
            //Calling the execute method
            jrs.execute();
            //Printing the values of the specified name
            while (jrs.next())
            System.out.println("Id: "+jrs.getInt(1)+" Name: "+jrs.getString(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
