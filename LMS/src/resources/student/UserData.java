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
   private boolean tableEnabled = false;
   private ArrayList<Student> students;	
   
   public List<Student> getDepartmentStudents(String Department) throws ClassNotFoundException, SQLException{
	   
	   ArrayList<Student> departmentStudents = new ArrayList<>();
	   Student std1 = new Student("Lama","lamaM" ,"lama@gmail.com","IT","level1","pass1234");
	   Student std2 = new Student("Sultan","sultang" ,"sultan@gmail.com","IT","level1","sultansultan");
	  
	   students.add(std1);
	   students.add(std2); 
	   
	   return departmentStudents;
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
//	   for(int i=0;i<students.size();i++) System.out.println("****"+students.get(i).getName()); 
//	   System.out.println("*************************************************"+students.size());
	      return students;
	   }

	   public String addStudent() {		 
		   Student student = new Student(name,username,email,department,level,password);
	      students.add(student);
	      return null;
	   }

	   public String removeStudent(Student student) {
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


							public boolean isTableEnabled() {
								System.out.println("#### Is enabled =" + tableEnabled);
								return tableEnabled;
							}


							public void setTableEnabled(boolean tableEnabled) {
								this.tableEnabled = tableEnabled;
							}
	
   
   
   
}
