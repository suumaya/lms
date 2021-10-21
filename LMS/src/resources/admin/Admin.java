package resources.admin;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import resources.exam.ExamData;
import resources.exam.question;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.code.hibernate.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jboss.logging.BasicLogger;

import resources.student.*;
@NamedQueries({
	 @NamedQuery(name  = "userData_searchStudents", 
         	 	query = " select c " +
         	 		 " from admin c " +
         			 " where (:P_ID = -1 or c.id = :P_ID )" +
         			 " and (:P_username = '-1' or c.username = :P_username ) " +
         			 " order by c.username desc , c.id "
			 	)
}) 

@Entity
@Table(name = "admin", schema = "examinationsys")
@SuppressWarnings("serial")
@ManagedBean(name = "admin")
@SessionScoped
public class Admin implements Serializable{
	//What is This? 
 	 private static final long serialVersionUID = 6081417964063918995L;
 
 	@Column(name="userName")
	   private String username;
 	@Column(name="password")
	   private String password;
  
	   
	    public Admin() {}
	   
	   public Admin(String username, String password) { 
		this.username = username;
		this.password = password;
	   }
 
		   
		   public String getUsername() {
			      return username;
			   }

			   public void setUsername(String username) {
			      this.username = username;
			   }
			    
						   
						   public String getPassword() {
							      return password;
							   }

							   public void setPassword(String password) {
							      this.password = password;
							   }

							 //validate login
								public String validateUsernamePassword() {
									boolean valid = LoginDAO.validateAdmin(username, password);
									if (valid) {
										System.out.println("************ LoginDAO result VALID!!");
										HttpSession session = SessionUtils.getSession();
										session.setAttribute("username", username);
										return "admin";
									} else {
										System.out.println("************ LoginDAO result NOT VALID!!");
										FacesContext.getCurrentInstance().addMessage(
												null,
												new FacesMessage(FacesMessage.SEVERITY_WARN,
														"Incorrect Username and Passowrd",
														"Please enter correct username and Password"));
										return "login";
									}
								}
								
								

								//logout event, invalidate session
								public String logout() {
									HttpSession session = SessionUtils.getSession();
									session.invalidate();
									System.out.println("*************** LOG OUT");
									return "login";
								}
							  			
}
