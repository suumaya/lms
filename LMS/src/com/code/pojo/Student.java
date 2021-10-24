package com.code.pojo;

import java.util.Date;  
import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import static javax.persistence.GenerationType.IDENTITY;  
import javax.persistence.Id;  
import javax.persistence.Table;  
import javax.persistence.Temporal;  
import javax.persistence.TemporalType;  


@Entity
@Table(name = "student", schema = "examinationsys")
public class Student {
	private int id;
	private String name;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	private String email;
	private String department;
	private String level;
	
	public Student(){
		
	}
	
	public Student(int id, String firstName, String lastName, String username, String email, String department,
			String level) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.department = department;
		this.level = level;
	}
	
	

	@Id @GeneratedValue(strategy = IDENTITY)  
    @Column(name = "id", unique = true, nullable = false)  
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "firstName")
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "lastName")
	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	
	
	@Column(name = "username")
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	
	@Column(name = "email") 
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "department") 
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Column(name = "level") 
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
}
