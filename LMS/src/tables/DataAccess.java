package tables;
import java.sql.*;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import resources.exam.exam;


public class DataAccess {
	

	private String user = "Admin_SYS@online-examination-system";
	private String pass = "WelcomeToServerJSF#12July";
	private String connString = "jdbc:mysql://online-examination-system.mysql.database.azure.com:3306/examinationsys?useSSL=true&requireSSL=false";
	
	public DataAccess() {
		//Session 
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(exam.class)//instead of exam.class we will put the user (admin, student )
				.buildSessionFactory(); 
		Session session = factory.getCurrentSession(); 
		try {
			//retrive/save session objects 
		}catch(Exception ee) {
			
		}finally {
			factory.close();
		}
		//Example of saving java object 
		try {
			//1. Create user object 
//			temp = new user(); 
			//2.Start transaction 
			session.beginTransaction(); 
			
			//3. save the user 
//			session.save(temp); 
			
			//4. commit transaction 
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
		//Connection 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(connString,user, pass );
			
			Statement s = con.prepareStatement("select * from examinationsys.exam; "); 
			ResultSet re = s.executeQuery("select * from examinationsys.exam; ");
			while(re.next()) {
				System.out.println(re.getString(0));
			}
		}catch(Exception e) {
			
		}
	}
	public static <T> List<T> executeNamedQuery(Class<T> dataClass, String queryName, Map<String, Object> parameters) {
		//return executeUpdateNamedQuery(dataClass, queryName, parameters, false);
		return null; 
	}
}


