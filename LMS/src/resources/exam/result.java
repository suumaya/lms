package resources.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class result {
	
	private int points ; 
	private static String user = "Admin_SYS@online-examination-system";
	private static String pass = "WelcomeToServerJSF#12July";
	private static String connString = "jdbc:mysql://online-examination-system.mysql.database.azure.com:3306/examinationsys?useSSL=true&requireSSL=false";
	private static Connection con; 
	
	public static int saveResult(String num) {
		int number = Integer.parseInt(num); 
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(connString,user, pass );
			String sql = "insert into `result` value("+0+","+num+","+0+"); ";
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			}catch(Exception ee) {

			}
		
		
		return number; 
	}

}
