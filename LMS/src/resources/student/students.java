package resources.student;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import resources.exam.exam;
 
 
@ManagedBean(name = "userData")
@SessionScoped
public class students implements Serializable {
   private static final long serialVersionUID = 6081417964063918994L;
  
   private boolean tableEnabled = false;
   private List<Student> students;	
   
		
   
   public List<Student> getStudents() throws ClassNotFoundException, SQLException{
	   students = new ArrayList<>();
	   Student std1 = new Student("John","aa","joh1" ,"jogn@gmail.com","Finance","level1","12345j");
	   Student std2 = new Student("Lama","aa","lamaM" ,"lama@gmail.com","IT","level1","pass1234");
	   Student std3 = new Student("Ahmed","aa","aa12" ,"ahmed@gmail.com","Finance","level2","ahmed12");
	   Student std4 = new Student("Sultan","aa","sultang" ,"sultan@gmail.com","IT","level1","sultansultan");
	   Student std5 = new Student("Sara","aa","saraQ" ,"sara@gmail.com","Finance","level2","qqss4545");

	  
	   try{
	   String user = "Admin_SYS@online-examination-system";
		String pass = "WelcomeToServerJSF#12July";
		String connString = "jdbc:mysql://online-examination-system.mysql.database.azure.com:3306/examinationsys?useSSL=true&requireSSL=false";
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection(connString,user, pass );
		 students.add(std1);
		   students.add(std2);
		   students.add(std3);
		   students.add(std4);
		   students.add(std5);
		   System.out.println("**************************************** in try");
	   
	      return students;
	   } catch(Exception e){
		   System.out.println("********************************** in catch");
		   return students;
	   }
	   
   }

	   public String addStudent(String name, String lname,String username, String email, String department, String level, String password) {		 
		   Student student = new Student(name,lname,username,email,department,level,password);
	      students.add(student);
	      return null;
	   }

	   public String removeStudent(Student student) {
	      students.remove(student);		
	      return null;
	   }
 

	 public boolean isTableEnabled() {
								System.out.println("#### Is enabled =" + tableEnabled);
								return tableEnabled;
							}


	 public void setTableEnabled(boolean tableEnabled) {
								this.tableEnabled = tableEnabled;
							}
	
   
   
   

   }
