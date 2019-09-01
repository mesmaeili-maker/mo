package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

import java.sql.*;

public class myjdbcpreparedstatement {
    public static void main(String[] args) throws Exception {
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        String dbURL = "jdbc:mysql://localhost:3306/sakila?useSSL=false&serverTimezone=GMT";
        String user = "student";
                                                                                                                                     String pass = "NickNick12";
        try {
            // 1. Get a connection to the database
            myConn = DriverManager.getConnection(dbURL, user, pass);
            System.out.println("Database connection is successful!\n");
            // 2. Create a statement
            myStmt = myConn.prepareStatement("select * from customer where active = ? and store_id = ?");
            // 3. prepare statement
            myStmt.setInt(1, 0);
            myStmt.setInt(2, 1);
            //4. execute SQL query
            myRs = myStmt.executeQuery();
            //5. Display the result set
            display(myRs);
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
    public static void display(ResultSet myRs) throws  SQLException {
        while (myRs.next()){
            int customerId = myRs.getInt("customer_id");
            int storeId = myRs.getInt("store_id");
            String firstName = myRs.getString("first_name");
            String lastName = myRs.getString("last_name");
            int addressId = myRs.getInt("address_id");
            int active = myRs.getInt("active");
            System.out.printf("%d, %d, %s, %s, %d, %d\n",
                    customerId, storeId, firstName, lastName, addressId, active);
        }
    }
}
