
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
import javax.faces.bean.SessionScoped;

import resources.student.Student;
 

@SuppressWarnings("serial")
@ManagedBean(name = "dataBean")
@SessionScoped
public class DataBean implements Serializable {

	private static final long serialVersionUID = 6081417964063918994L;

	public List<Student> getStudents() throws ClassNotFoundException, SQLException {

		Connection connect = null;	
		String username = "Admin_SYS@online-examination-system";
		String password = "WelcomeToServerJSF#12July";
		String url = "jdbc:mysql://online-examination-system.mysql.database.azure.com:3306/examinationsys?useSSL=true&requireSSL=false";
	 
 
		try {

			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager.getConnection(url, username, password);
			System.out.println("############################# success #############################");
 
		} catch (SQLException ex) {
			System.out.println("in exec");
			System.out.println(ex.getMessage());
			System.out.println("############################# failed #############################");
		}

		List<Student> students = new ArrayList<Student>();
		PreparedStatement pstmt = connect
				.prepareStatement("select firstName,userName,department,level from student");
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			Student std = new Student();
			std.setName(rs.getString("firstName"));
			std.setLname(rs.getString("lastName"));
			std.setUsername(rs.getString("userName"));
			std.setPassword(rs.getString("password"));
			std.setDepartment(rs.getString("department"));
			std.setLevel(rs.getString("level"));
			std.setEmail(rs.getString("email"));

			students.add(std);

		}

		// close resources
		rs.close();
		pstmt.close();
		connect.close();

		return students;

	}

}
