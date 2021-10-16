
package models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import resources.student.Student;
 
@SuppressWarnings("serial")
@ManagedBean(name = "dataBean")
@SessionScoped
@RequestScoped

public class DataBean implements Serializable {

	private static final long serialVersionUID = 6081417964063918994L;
	List<Student> students = new ArrayList<Student>();
	Student std1 = new Student("John1","aa","joh1" ,"jogn@gmail.com","Finance","level1","12345j");
	Student std2 = new Student("John2","bb","joh2" ,"jogn2@gmail.com","Finance","level1","12345j");
	
	List<Student> other_students = new ArrayList<Student>();
	private boolean tableEnabled = false;
	Connection connect = null;	
	String username = "Admin_SYS@online-examination-system";
	String password = "WelcomeToServerJSF#12July";
	String url = "jdbc:mysql://online-examination-system.mysql.database.azure.com:3306/examinationsys?useSSL=true&requireSSL=false";

    private static final String SQL_DELETE = "delete from student WHERE username=?";
    private static final String SQL_INSERT = "insert into student values (?,?,?,?,?,?,?)";
    private static final String SQL_SELECT ="select firstName,lastName,userName,department,level,email from student";
	

	public List<Student> getStudents() throws ClassNotFoundException, SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = connect
					.prepareStatement("select firstName,lastName,userName,department,level,email from student");
//			   pstmt.setString(1, "SWE");
			ResultSet rs = pstmt.executeQuery();
			System.out.println("############################# success #############################");
			
			while (rs.next()) {

				Student std = new Student();
				std.setName(rs.getString("firstName"));
				std.setLname(rs.getString("lastName"));
				std.setUsername(rs.getString("userName"));
//				std.setPassword(rs.getString("password"));
				std.setDepartment(rs.getString("department"));
				std.setLevel(rs.getString("level"));
				std.setEmail(rs.getString("email"));

				students.add(std);
 
		}
			
			rs.close();
			pstmt.close();
			connect.close();
			} catch (SQLException ex) {
			System.out.println("*** in exec:");
			System.out.println("*** messafe: "+ex.getMessage());
			
			System.out.println("############################# failed #############################");
			return students;
			
			 
 		}

		return students;

	}
	
	
	public List<Student> getOther_students() throws ClassNotFoundException, SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = connect
					.prepareStatement("select firstName,lastName,userName,department,level,email from student where department !=?");
			   pstmt.setString(1, "SWE");
			ResultSet rs = pstmt.executeQuery();
			System.out.println("############################# success #############################");
			
			while (rs.next()) {

				Student std = new Student();
				std.setName(rs.getString("firstName"));
				std.setLname(rs.getString("lastName"));
				std.setUsername(rs.getString("userName"));
//				std.setPassword(rs.getString("password"));
				std.setDepartment(rs.getString("department"));
				std.setLevel(rs.getString("level"));
				std.setEmail(rs.getString("email"));

				other_students.add(std);
 
		}
			
			rs.close();
			pstmt.close();
			connect.close();
			} catch (SQLException ex) {
			System.out.println("*** in exec:");
			System.out.println("*** messafe: "+ex.getMessage());
			
			System.out.println("############################# failed #############################");
			return other_students;
			
			 
 		}

		return other_students;

	}
	
	
	 public void removeStudent(Student student) throws ClassNotFoundException, SQLException {
 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(url, username, password);			
			PreparedStatement pstmt = connect.prepareStatement(SQL_DELETE);
	            pstmt.setString(1, student.getUsername());
	            int row = pstmt.executeUpdate();
	            // rows affected
	            System.out.println(row);
 				System.out.println("############################# in remove success #############################");
 				students.remove(0);
			 
			
 			pstmt.close();
			connect.close();	
		
	} catch (SQLException e) {
		System.out.println("############################# sql remove failed #############################");
        System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
 
    } catch (Exception e) {
        e.printStackTrace();
		System.out.println("############################# general remove failed #############################");

    } 
		
		
		 students = getStudents();
 
	}
	  
	
	 
	 public String addStudent(Student student) throws ClassNotFoundException, SQLException {
			
		   System.out.println("#############################"+ student.getUsername()+" #############################");
		   Connection connect = null;	
			String username = "Admin_SYS@online-examination-system";
			String password = "WelcomeToServerJSF#12July";
			String url = "jdbc:mysql://online-examination-system.mysql.database.azure.com:3306/examinationsys?useSSL=true&requireSSL=false";

			
	  String SQL_INSERT = "insert into student values (?,?,?,?,?,?,?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(url, username, password);			
			PreparedStatement pstmt = connect.prepareStatement(SQL_INSERT);
	            pstmt.setString(1, student.getUsername());
	            pstmt.setString(2, student.getPassword());
	            pstmt.setString(3, student.getEmail());
	            pstmt.setString(4, student.getName());
	            pstmt.setString(5, student.getLname());
	            pstmt.setString(6, student.getDepartment());
	            pstmt.setString(7, student.getLevel());
	            int row = pstmt.executeUpdate();
	            // rows affected
	            System.out.println(row);
					System.out.println("############################# in add success #############################");
			 
			
				pstmt.close();
			connect.close();	
		
	} catch (SQLException e) {
		System.out.println("############################# sql add failed #############################");
	    System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());

	} catch (Exception e) {
	    e.printStackTrace();
		System.out.println("############################# general add failed #############################");
	 

	} 
		
		
		 
		 return "examList";  

	}
	 

	 public boolean isTableEnabled() {
								System.out.println("############## Is enabled =" + tableEnabled);
								return tableEnabled;
							}


	 public void setTableEnabled() {
	
								this.tableEnabled = true;
								 System.out.println("############# This time Is enabled =" + tableEnabled);
							}

	 

}

