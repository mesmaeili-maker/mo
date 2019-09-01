package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.*;

public class my_jdbc_test_create_database

{
    public static void main(String[] args) throws Exception{
        Connection myConn = null;
        Statement myStmt = null;

        String dbURL = "jdbc:mysql://localhost:3306/sakila?useSSL=false&serverTimezone=GMT";
        String user = "student";
        String pass = "NickNick12";
        try{
            //1. get a connection to the database
            myConn = DriverManager.getConnection(dbURL, user, pass);
            System.out.println("Database connection is successful!");
            //2. create a statement
            myStmt = myConn.createStatement();

            //3.Drop an existing database

            System.out.println("Dropping an existing database");
            String dropDatabase = "Drop database if exists exployees";
            myStmt.executeUpdate(dropDatabase);
            System.out.println("Database dropped succesfully ...");


            //4. execute SQL query
            System.out.println("Creating a new database");
            String createDatabase = "create database if not exists employee";
            myStmt.executeUpdate(createDatabase);
            System.out.println("Database created succesfully....");


        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (myStmt != null){
                myStmt.close();
            }

            if (myConn != null){
                myConn.close();
            }
        }
    }
}