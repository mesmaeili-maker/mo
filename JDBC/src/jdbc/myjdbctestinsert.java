package jdbc;

import java.sql.*;

public class myjdbctestinsert {


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
            System.out.println("insert a new actor record");
            myRs = myStmt.executeQuery("SELECT * FROM ACTOR");
            int rowsAffected = myStmt.executeUpdate(
                    "insert into actor " +
                            "(first_name, last_name)" +
                            "values " +
                            "('Leonardus', 'Hutabarat')");
            // verify this row insertion by getting a list of actors
            myRs = myStmt.executeQuery("SELECT * FROM ACTOR");
            // 4. Process the result set
            while (myRs.next()) {
                System.out.println(myRs.getString("first_name") + " " + myRs.getString("last_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (myStmt != null) {
                myStmt.close();
            }
            if (myConn != null) {
                myConn.close();
            }
        }
    }
}