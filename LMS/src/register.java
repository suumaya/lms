import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import resources.exam.exam;
import resources.student.Student;
import javax.faces.bean.*;

@SuppressWarnings("serial")
@ManagedBean(name = "register")
@SessionScoped
public class register implements Serializable{
//	private String username;
//	private String password;
	private String user = "Admin_SYS@online-examination-system";
	private String pass = "WelcomeToServerJSF#12July";
	private String connString = "jdbc:mysql://online-examination-system.mysql.database.azure.com:3306/examinationsys?useSSL=true&requireSSL=false";
	private Student student; 
	public register() {
		student = new Student(); 
	}
	public void Register() {
//int n=0;
//n=n+1; 
////Session 
//		SessionFactory factory = new Configuration()
//				.configure()
//				.addAnnotatedClass(Student.class)//instead of exam.class we will put the user (admin, student )
//				.buildSessionFactory(); 
//		Session session = factory.getCurrentSession(); 
//		//Example of saving java object 
//		try {
//			//1. Create user object 
////			temp = new user(); 
//			Student temp = new Student();
//			//2.Start transaction 
//			session.beginTransaction(); 
//			
//			//3. save the user 
//			session.save(temp); 
//			
//			//4. commit transaction 
//			session.getTransaction().commit();
//			
//		}finally {
//			factory.close();
//		}
		//Connection 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(connString,user, pass );
			String sql = "Insert into examinationsys.student values ('"
			+student.getUsername()+"','"
			+student.getPassword()+"','"
			+student.getEmail()+"','"
			+student.getName()+"','"
			+student.getName()+"','"
			+student.getDepartment()+"','"
			+student.getLevel()+"');";
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
//return null; 
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
	
}
