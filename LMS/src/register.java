import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.code.hibernate.DatabaseOperations;
import com.code.hibernate.ExamDatabaseOperations;

//import resources.exam.exam;
import resources.student.Student;
import tables.Exam;

import javax.faces.bean.*;

@SuppressWarnings("serial")
@ManagedBean(name = "register")
@SessionScoped
public class register implements Serializable{
//	private String username;
	private String confirmPassword;
	private String user = "Admin_SYS@online-examination-system";
	private String pass = "WelcomeToServerJSF#12July";
	private String connString = "jdbc:mysql://online-examination-system.mysql.database.azure.com:3306/examinationsys?useSSL=true&requireSSL=false";
	private Student student; 
    public static DatabaseOperations dbObj;
    public static ExamDatabaseOperations dbObjExam;

	public register() {
		student = new Student(); 
	}
	public String Register() {
		String result= "FAIL"; 
		//Check passwords 
		if(!student.getPassword().equals(confirmPassword)) {
			return result; 
		}
		String[] name = student.getName().split("\\s"); 
		String fName = name[0]; 
		String lName; 
		if(name.length>1) {
		lName =name[1]; 
		for(int i=2;i<name.length;i++) {
			lName+=" "+name[i]; 
		}
		}else {
			lName = ""; 	
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(connString,user, pass );
			String sql = "Insert into examinationsys.student values ('"
					+student.getUsername()+"','"
					+student.getPassword()+"','"
					+student.getEmail()+"','"
					+fName+"','"
					+lName+"','"
					+student.getDepartment()+"','"
					+student.getLevel()+"');";
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(sql);
			result = "SUCCESS";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
}
