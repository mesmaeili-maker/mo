import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.*;
public class myjdbctest2 {
    public static void main(String[] args) throws Exception{
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        String dbURL = "jdbc:mysql://localhost:3306/sakila?useSSL=false&serverTimezone=GMT";
        String user = "student";
        String pass = "NickNick12";
        try{
            //1. get a connection to the database
            myConn = DriverManager.getConnection(dbURL, user, pass);
            System.out.println("Database connection is successful!");
            //2. create a statement
            myStmt = myConn.createStatement();
            //3. execute SQL query
            myRs = myStmt.executeQuery("SELECT * FROM CUSTOMER");
            //4. process the result set
            while (myRs.next()){
                System.out.println(myRs.getString("first_name") + " " + myRs.getString("last_name"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (myRs != null){
                myRs.close();
            }
            if (myStmt != null){
                myStmt.close();
            }
            if (myConn != null){
                myConn.close();
            }
        }
    }
}
