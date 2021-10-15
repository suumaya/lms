package com.code.hibernate;

import java.util.ArrayList;
import java.util.List;
 
import javax.faces.context.FacesContext;
 
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.code.hibernate.hibernateUtil;

import tables.Exam;

public class ExamDatabaseOperations {
	private static Transaction transaction;
    private static Session session = hibernateUtil.getSessionFactory().openSession();
 
   
    public void addingExam(Exam exam) {        
        try {
            transaction = session.beginTransaction();
            session.save(exam);
            System.out.println("Exam Record With Id: " + exam.getId() + " Is Successfully Created In Database");
 
            // XHTML Response Text
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("created exmam Id",  exam.getId());                        
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            transaction.commit();
        }
    }
    
    public void examDeletion(String deleteExamID) {
        try {
            transaction = session.beginTransaction();
            Exam examID = (Exam)session.load(Exam.class, new String(deleteExamID));
            session.delete(deleteExamID);
            System.out.println("Exam Record With Id: " + deleteExamID + " Is Successfully Deleted From Database");
 
            // XHTML Response Text
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("deleted Exam ID",  deleteExamID);  
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            transaction.commit();
        }
    }
    
    public void updatingExam(Exam exam) {
        try {
            transaction = session.beginTransaction();
            session.update(exam);        
            System.out.println("Exam Record With Id: " + exam.getId() + " Is Successfully Updated In Database"); 
 
            // XHTML Response Text
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("updated Exam Record",  "Success");
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            transaction.commit();
        }
    }
    
    //return exam by id
    @SuppressWarnings({ "unchecked", "unused" })
    public List<Exam> getExamById(String examID) { 
        Exam exam = new Exam();
        List<Exam> ExamList = new ArrayList<>();            
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from exam where id= :id").setString("exam", examID);          
            exam = (Exam) query.uniqueResult();
            ExamList = query.list();            
            System.out.println("exam Record With Id: " + examID + " Is Fetched Successfully From Database");
 
            // XHTML Response Text
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("findExamById",  examID);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            transaction.commit();
        }
        return ExamList;
    }

}
    
    
    
    

