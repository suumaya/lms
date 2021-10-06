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
 
 
 
@ManagedBean(name = "userData")
@SessionScoped
public class UserData implements Serializable {
   private static final long serialVersionUID = 6081417964063918994L;
   private String name;
   private String username;
   private String email;
   private String department;
   private String level;
   private String password;
   
   private ArrayList<Student> students;	
   
   public UserData() {
   students = new ArrayList<Student>();
   Student std1 = new Student("John","joh1" ,"jogn@gmail.com","Finance","level1","12345j");
   Student std2 = new Student("Lama","lamaM" ,"lama@gmail.com","IT","level1","pass1234");
   Student std3 = new Student("Ahmed","aa12" ,"ahmed@gmail.com","Finance","level2","ahmed12");
   Student std4 = new Student("Sultan","sultang" ,"sultan@gmail.com","IT","level1","sultansultan");
   Student std5 = new Student("Sara","saraQ" ,"sara@gmail.com","Finance","level2","qqss4545");

   students.add(std1);
   students.add(std2);
   students.add(std3);
   students.add(std4);
   students.add(std5);
   }
   
   
   public List<Student> getStudentss() throws ClassNotFoundException, SQLException {

		Connection connect = null;

		String url = "jdbc:mysql://online-examination-system.mysql.database.azure.com:3306"; 

		String username = "Admin_SYS";
		String password = "WelcomeToServerJSF#12July";

		try {

			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager.getConnection(url, username, password);
			 System.out.println("########################Connection established"+connect);

		} catch (SQLException ex) {
			System.out.println("##################in exec");
			System.out.println(ex.getMessage());
		}

		List<Student> students = new ArrayList<Student>();
		PreparedStatement pstmt = connect
				.prepareStatement("select * from Student");
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			Student student = new Student();
			student.setName(rs.getString(1));
			student.setDepartment(rs.getString(1));
			students.add(student);

		}

		// close resources
		rs.close();
		pstmt.close();
		connect.close();

		return students;

	}
   
   
 
   public List<Student> getStudents() throws ClassNotFoundException, SQLException{
	   students = new ArrayList<>();
	   Student std1 = new Student("John","joh1" ,"jogn@gmail.com","Finance","level1","12345j");
	   Student std2 = new Student("Lama","lamaM" ,"lama@gmail.com","IT","level1","pass1234");
	   Student std3 = new Student("Ahmed","aa12" ,"ahmed@gmail.com","Finance","level2","ahmed12");
	   Student std4 = new Student("Sultan","sultang" ,"sultan@gmail.com","IT","level1","sultansultan");
	   Student std5 = new Student("Sara","saraQ" ,"sara@gmail.com","Finance","level2","qqss4545");

	   students.add(std1);
	   students.add(std2);
	   students.add(std3);
	   students.add(std4);
	   students.add(std5);
	   for(int i=0;i<students.size();i++) System.out.println("****"+students.get(i).getName()); 
	   System.out.println("*************************************************"+students.size());
	      return students;
	   }

	   public String addStudent() {		 
		   Student student = new Student(name,username,email,department,level,password);
	      students.add(student);
	      return null;
	   }

	   public String deleteStudent(Student student) {
	      students.remove(student);		
	      return null;
	   }
 

	   public String getName() {
		      return name;
		   }

		   public void setName(String name) {
		      this.name = name;
		   }
		   
		   
		   public String getUsername() {
			      return username;
			   }

			   public void setUserame(String username) {
			      this.username = username;
			   }
			   
			   
			   public String getEmail() {
				      return email;
				   }

				   public void setEmail(String email) {
				      this.email = email;
				   }
				   
				   public String getDepartment() {
					      return department;
					   }

					   public void setDepartment(String department) {
					      this.department = department;
					   }
					   
					   
					   public String getLevel() {
						      return level;
						   }

						   public void setLevel(String level) {
						      this.level = level;
						   }
						   
						   public String getPassword() {
							      return password;
							   }

							   public void setPassword(String password) {
							      this.password = password;
							   }
	
   
   
   
}
