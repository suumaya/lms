package com.code.DBAccess;
import java.sql.*;
import org.hibernate.*;
import org.json.*;
import java.util.*;
import java.util.concurrent.Semaphore;

import javax.servlet.ServletContext;

public class databaseAccess {
//	protected static SessionFactory sessionFactory;
//	protected static final Semaphore DB_CONNECTION_SEMAPHORE = new Semaphore(100, true);
//	public static final ResourceBundle configuration = ResourceBundle.getBundle("com/code/resources/config.properties");
//	public static String dbEngineName;
	
	
	
	
	// basic connection with no operation. 
	public Connection get_connection() throws Exception{
        Connection connection=null;
        final String url = "jdbc:mysql://online-examination-system.mysql.database.azure.com:3306/examinationsys?useSSL=true&requireSSL=false";
        final String userName = "Admin_SYS@online-examination-system";
        final String password = "WelcomeToServerJSF#12July";
        
        try {
        Class.forName("com.mysql.jdbc.Driver");
        connection=DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }
	
	
	
	
	
}
