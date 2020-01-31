/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emp;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author EYOBED
 */
public class DBMS {
     public static Connection connectDb() {
        try {
             Class.forName("com.mysql.jdbc.Driver"); //used to load the driver database
			
            //the following line of code is used to connect the database and the application
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/emp", "root", "1021070888");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    
}
