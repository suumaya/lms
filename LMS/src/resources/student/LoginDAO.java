package resources.student;

import org.hibernate.Session;
import org.hibernate.Transaction;

//import com.code.hibernate.Student;
 
import resources.student.Student;
import com.code.hibernate.HibernateUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import resources.student.DataConnect;

public class LoginDAO {

	public static boolean validate(String user, String password) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			System.out.println("*****************In validate try: LoginDAO");
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select userName, password from student where username = ? and password = ?");
			ps.setString(1, user);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				//result found, means valid inputs
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("************Login error -->" + ex.getMessage());
			return false;
		} finally {
			DataConnect.close(con);
		}
		return false;
	}
	
	
	public static boolean validateAdmin(String user, String password) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			System.out.println("*****************In validate try: LoginDAO");
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select userName, password from admin where userName = ? and password = ?");
			ps.setString(1, user);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				//result found, means valid inputs
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("************Login error -->" + ex.getMessage());
			return false;
		} finally {
			DataConnect.close(con);
		}
		return false;
	}
	
	
}