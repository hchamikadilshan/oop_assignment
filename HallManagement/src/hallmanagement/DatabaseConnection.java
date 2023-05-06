/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hallmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hcham
 */
public class DatabaseConnection {
    private Connection connection;
    public DatabaseConnection(){
        this("jdbc:mysql://localhost:3306/hallmanagement?useSSL=false","root","[Python2001mysql]");
    }
    public DatabaseConnection(String url, String username, String password) {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Connect to the database
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database Connection Succesfull");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: MySQL JDBC driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error: Failed to connect to database");
            e.printStackTrace();
        }
    }
    
    
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: Failed to close database connection");
            e.printStackTrace();
        }
    }
    
    // Other methods for querying the database can be added here
}
