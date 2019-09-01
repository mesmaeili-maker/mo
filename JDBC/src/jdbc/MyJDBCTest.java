package jdbc;

import java.sql.*;

public class MyJDBCTest


{

    public static void main(String [] args) throws Exception {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
        myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "student", "NickNick12");
        System.out.println("Database connection is successful!");

        myStmt = myConn.createStatement();

        myRs = myStmt.executeQuery("SELECT * FROM ACTOR ORDER BY first_name");

        while (myRs.next()) {
            System.out.println(myRs.getString("first_name") + " " + myRs.getString("last_name"));
        }

    }

        catch(SQLException e)
        {
             e.printStackTrace();
        }

        finally {

            if(myRs !=null)

            {
                myRs.close();
            }

            if(myStmt !=null)

            {
                myStmt.close();
            }

            if(myConn !=null)
            {
                myConn.close();
            }
        }



    }


}
