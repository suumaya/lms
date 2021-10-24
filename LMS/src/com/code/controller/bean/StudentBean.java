package com.code.controller.bean;
import javax.faces.bean.ManagedBean;  
import javax.faces.bean.ViewScoped;  
import java.util.List;  
import code.com.dataAccessObj.dataAccessStudent;
import com.code.pojo.Student; 
import java.io.Serializable;
 

@SuppressWarnings("deprecation")
@ManagedBean(name = "StudentBean")  
@ViewScoped  
public class StudentBean implements Serializable {
	
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List < Student > usersList;  
	    private List < Student > searchList;  
	    private List < Student > searchByRecordNoList;  
	    dataAccessStudent StudentOpe = new dataAccessStudent();
	    Student student = null;
	    Student newStudent = null;
	    private String ConfirmedPassword;
	    
	   



		public List <Student> getUsers()  
	    {  
	      List<Student>  studentList = StudentOpe.allStudents();  
	        int count = usersList.size();  
	        return usersList;  
	    }
	    
	    
	    
	    public void newStudentSignup(){  
	    	
	          
	         
	       if(matchedPassword()){ 
	    	newStudent = new Student();
	        StudentOpe.newStudent(newStudent);
	        System.out.println("User successfully saved.");
	        
	       }
	         
	        
	        
	       }
	    
	    public void addStudent(){  
	          
		        
		        StudentOpe.newStudent(newStudent);
		       
		        System.out.println("User successfully saved.");  
		        
		        newStudent = new Student();  
		       }
	    
	    
	    public void deleteStudent(Student student)  
	    {  
	        String name =  student.getName();
	        StudentOpe.removeStudent(student); 
	       
	    }  
	    
	    public void searchByID()  
	    {  
	        searchByRecordNoList = StudentOpe.SearchByRecordNo(student.getId());  
	        int count = searchByRecordNoList.size();  
	       
	    }
	    
	    public boolean matchedPassword() {
	    	if(newStudent.getPassword().equals(ConfirmedPassword)) {
	    		return true;
	    	}
	    	
	    	return false;
	    }
		public List<Student> getUsersList() {
			return usersList;
		}

		public void setUsersList(List<Student> usersList) {
			this.usersList = usersList;
		}

		public List<Student> getSearchList() {
			return searchList;
		}

		public void setSearchList(List<Student> searchList) {
			this.searchList = searchList;
		}

		public List<Student> getSearchByRecordNoList() {
			return searchByRecordNoList;
		}

		public void setSearchByRecordNoList(List<Student> searchByRecordNoList) {
			this.searchByRecordNoList = searchByRecordNoList;
		}

		public dataAccessStudent getStudentOpe() {
			return StudentOpe;
		}

		public void setStudentOpe(dataAccessStudent studentOpe) {
			StudentOpe = studentOpe;
		}

		public Student getStudent() {
			return student;
		}

		public void setStudent(Student student) {
			this.student = student;
		}

		public Student getNewStudent() {
			return newStudent;
		}

		public void setNewStudent(Student newStudent) {
			this.newStudent = newStudent;
		}
		
		 public String getConfirmedPassword() {
				return ConfirmedPassword;
			}



			public void setConfirmedPassword(String confirmedPassword) {
				ConfirmedPassword = confirmedPassword;
			}
	    
}
