package com.code.hibernate;


import java.util.ArrayList;
import java.util.List;
 
import javax.faces.context.FacesContext;
 
//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import resources.student.Student;
import com.code.hibernate.HibernateUtil;

public class DatabaseOperations {
 
 
    private static Transaction transObj;
    private static Session sessionObj = HibernateUtil.getSessionFactory().openSession();
 
    // Method To Add New Student Details In Database
    public static void addStudentInDb(Student studentObj) { 
    	try {
    		transObj = sessionObj.beginTransaction();
    		sessionObj.save(studentObj);
            System.out.println("Exam Record With Id: " + studentObj.getName() + " Is Successfully Created In Database");
 
            // XHTML Response Text
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("created exmam Id",  studentObj.getName());                        
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	transObj.commit();
        }
    	 
    }
  
}

