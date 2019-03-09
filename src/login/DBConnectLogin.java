package login;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author susmita
 */
public class DBConnectLogin 
{
    public static Connection dbConnect() throws ClassNotFoundException, SQLException
    {
        
        Class.forName("com.mysql.jdbc.Driver");
	java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/LOGINCREDENTIALS","root","susmita12");
	System.out.println("Connection Established");
        return con;
    }
    
}
