package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;

public class myjdbcdelete {
    public static void main(String[] args) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        String dbURL = "jdbc:mysql://localhost:3306/sakila?useSSL=false&serverTimezone=GMT";
        String user = "student";
        String pass = "";
        try {
            // 1. Get a connection to the database
            myConn = DriverManager.getConnection(dbURL, user, pass);
            System.out.println("Database connection is successful!");
            // 2. Create a statement
            myStmt = myConn.createStatement();
            // 3. insert a new employee
            System.out.println("Deleting an actor for table");
            int rowsAffected = myStmt.executeUpdate(
                    "delete from actor " +
                            "where first_name = 'Boris' and last_name = 'Obama'");
            // verify this row insertion by getting a list of actors
            myRs = myStmt.executeQuery("SELECT * FROM ACTOR ORDER BY actor_id DESC");
            // 4. Process the result set
            while (myRs.next()){
                System.out.println(myRs.getString("actor_id") + " " + myRs.getString("first_name") +" " + myRs.getString("last_name"));
            }
        } catch (SQLException e) {
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