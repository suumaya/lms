package resources.student;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import resources.exam.ExamData;
import resources.exam.question;


@NamedQueries({
	 @NamedQuery(name  = "userData_searchStudents", 
         	 	query = " select c " +
         	 		 " from student c " +
         			 " where (:P_ID = -1 or c.id = :P_ID )" +
         			 " and (:P_username = '-1' or c.username = :P_username ) " +
         			 " order by c.username desc , c.id "
			 	)
}) 

@SuppressWarnings("serial")
@Entity
@Table(name = "student")
public class Student {
	//What is This? 
 	 private static final long serialVersionUID = 6081417964063918994L;

 	@Column(name="firstName")
	   private String name;
 	@Column(name="lastName")
	   private String lname;
 	@Column(name="userName")
	   private String username;
 	@Column(name="email")
	   private String email;
 	@Column(name="department")
	   private String department;
 	@Column(name="level")
	   private String level;
 	@Column(name="password")
	   private String password;
 	
	   
	   
	   public Student() {}
	   public Student(String name,String lname, String username, String email, String department, String level, String password) {
		   
		this.name = name;
		this.lname = lname;
		this.username = username;
		this.email=email;
		this.department = department;
		this.level=level;
		this.password = password;
		
	   }
	   

	   public String getName() {
		      return name;
		   }

		   public void setName(String lname) {
		      this.lname = lname;
		   }
		   
		   public String getLname() {
			      return lname;
			   }

			   public void setLname(String name) {
			      this.name = name;
			   }
		   
		   
		   public String getUsername() {
			      return username;
			   }

			   public void setUsername(String username) {
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
