 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Agarwal
 */
public class Connect {
    Connection con=null;
   
        public static Connection ConnectDB(){
        try{

//           Class.forName("org.sqlite.JDBC");
//           Connection con = DriverManager.getConnection("jdbc:sqlite:mrsdb.db");

//           Class.forName("com.mysql.cj.jdbc.Driver");
//           
//           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrsdb","root","");

        
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=mrsdb","user","pass");
       
           return con;
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }      
    }
}
