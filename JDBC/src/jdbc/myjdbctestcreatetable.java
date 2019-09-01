package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class myjdbctestcreatetable {

    public static void main(String[] args) throws Exception{
        Connection myConn = null;
        Statement myStmt = null;
        String dbURL = "jdbc:mysql://localhost:3306/employee?useSSL=false&serverTimezone=GMT";
        String user = "student";
        String pass = "NickNick12";
        try{
            //1. get a connection to the database
            myConn = DriverManager.getConnection(dbURL, user, pass);
            System.out.println("Database connection is successful!");
            //2. create a statement
            myStmt = myConn.createStatement();
            //3. execute SQL query
            System.out.println("Creating a new table");
            String createTable = "create table if not exists employees" +
                    " (" +
                    "first_name varchar(255) not null," +
                    "last_name varchar(255) not null," +
                    "emp_id int not null," +
                    "salary int not null," +
                    "primary key(emp_id)" +
                    ")engine=innodb";
            myStmt.executeUpdate(createTable);
            System.out.println("DaTable created successfully ...");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (myStmt != null){
                myStmt.close();
            }
            if (myConn != null) {
                myConn.close();
            }
        }
    }
}