package resources.student;

public class Student {

	   private String name;
	   private String username;
	   private String email;
	   private String department;
	   private String level;
	   private String password;

	   
	   public Student (String name,String username,String email,String department,String level,String password) {
		      this.name = name;
		      this.username = username;
		      this.name = name;
		      this.email = email;
		      this.department = department;
		      this.level = level;
		      this.password = password;
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
