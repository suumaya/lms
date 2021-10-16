import java.sql.*;
import org.hibernate.*;
//import org.json.*;
import java.util.*;

public class databaseAccess {
	
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
