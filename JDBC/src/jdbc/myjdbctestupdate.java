//package jdbc;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class myjdbctestupdate
//{
//
//    public static void main(String [] args) throws Exception
//
//    {
//
//        Connection myConn = null;
//        Statement myStmt = null;
//        String pass = "student";
//
//        try {
//            // 1. Get a connection to the database
//
//            myConn = DriverManager.getConnection(dbURL, user, pass);
//            System.out.println("Database connection is successful!");
//
//            // 2. Create a statement
//            myStmt = myConn.prepareStatement("select * from customer where active = ? and store_id = ?");
//            // 3. prepare statement
//            myStmt.setInt(1, 0);
//            myStmt.setInt(2, 1);
//            //4. execute SQL query
//            myRs = myStmt.executeQuery();
//            //5. Display the result set
//
//            display(myRs);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (myStmt != null){
//                myStmt.close();
//            }
//            if (myConn != null){
//                myConn.close();
//            }
//        }
//    }
//
//    }
//}
