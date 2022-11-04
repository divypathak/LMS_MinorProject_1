/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package My_classes;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author divyp
 */
public class DB {
    
    //create a connection betweem the project and database
      private static String servername="localhost";
    private static String username="root"; 
    private static String dbname="java_library_system";
    private static Integer portNumber=3306;
    private static String password="";
    
    
    // create a function to create and return the connection
    public static Connection getConnection()
    {
        Connection connection= null;
        
        MysqlDataSource datasource = new MysqlDataSource();
        datasource.setServerName(servername);
        datasource.setUser(username);
        datasource.setDatabaseName(dbname);
        datasource.setPassword(password);
        
          try {
              connection=datasource.getConnection();
          } catch (SQLException ex) {
              Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
          }
        
        
        
        
        
        
        return connection;
        
    }
    
    
}
