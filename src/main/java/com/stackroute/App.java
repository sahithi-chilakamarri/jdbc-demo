package com.stackroute;

public class App {
    public static void main(String[] args) {
        //Creating objects for every class
        SimpleJdbcDemo simpleJdbcDemo = new SimpleJdbcDemo();
        ResultSetMetaDataDemo resultSetMetaDataDemo = new ResultSetMetaDataDemo();
        DatabaseMetaDataDemo databaseMetaDataDemo = new DatabaseMetaDataDemo();
        RowSetDemo rowSetDemo = new RowSetDemo();
        JdbcBatchDemo jdbcBatchDemo = new JdbcBatchDemo();
        JdbcTransactionDemo jdbcTransactionDemo = new JdbcTransactionDemo();
        //Calling function of SimpleJdbcDemo
        simpleJdbcDemo.getEmployeeDetails();
        System.out.println("------------");
        //To get the employee details in reverse order
        simpleJdbcDemo.getEmployeeDetailsInReverseOrder();
        System.out.println("------------");
        //To get the specific row data and reverse order
        simpleJdbcDemo.getEmployeeDetailsFromSecondRowInReverse();
        System.out.println("------------");
        //To get the employee details using prepared statement
        simpleJdbcDemo.getEmployeeDetailsByNameAndGender();
        System.out.println("------------");
        //Calling function of ResultSetMetadataDemo
        resultSetMetaDataDemo.resultSetDemo();
        System.out.println("------------");
        //Calling function of DatabaseMetaDataDemo
        databaseMetaDataDemo.databaseMetaDataDemo();
        System.out.println("------------");
        //Calling function of rowsetdemo
        rowSetDemo.rowSetDemo();
        System.out.println("------------");
        //Calling function of JdbcBatchDemo
        jdbcBatchDemo.jdbcBatchDemo();
        System.out.println("------------");
        //Calling function of jdbc transaction demo
        jdbcTransactionDemo.jdbcTransactionDemo();

    }
}
