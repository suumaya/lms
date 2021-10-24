package code.com.dataAccessObj;

import java.util.List;  
import java.util.ArrayList;  
import org.hibernate.Query;  
import org.hibernate.Session;
import com.code.pojo.Student;



public class dataAccessStudent {
	private Student student;
	private Student newStudent;
	private List<Student> allStudents;
	private List<Student> DaoSearchStudentList;
	Session session;
	 public List <Student> allStudents(){  
		 Session session =  HibernateUtil.getSessionFactory().openSession();  
	        try{  
	            session.beginTransaction();  
	            allStudents = session.createCriteria(Student.class).list();  
	            int count = allStudents.size();  
	            
	            session.getTransaction().commit();  
	        }  
	        catch (Exception e){  
	            e.printStackTrace();  
	            session.getTransaction().rollback();  
	        }  
	        session.close();  
	        return allStudents;  
	    }  
	 
	 public Integer getId()  {  
		 Session session = HibernateUtil.getSessionFactory().openSession();  
	        String hql = "select max(U.id) from User U";  
	        Query query = session.createQuery(hql);  
	        List <Integer> results = query.list();  
	        Integer userId = 1;  
	        if (results.get(0) != null)  
	        {  
	            userId = results.get(0) + 1;  
	        }  
	        session.flush();  
	        session.close();  
	        return userId;  
	    }
	 
	 public void newStudent(Student newStudent)   {  
		 Session session = HibernateUtil.getSessionFactory().openSession();  
	        try{  
	             
	            // begin a transaction  
	        	session.beginTransaction();
	            session.save(newStudent);
	            session.getTransaction().commit();
	            session.close();  
	            System.out.println("New Student saved, id: " +  
	            		newStudent.getId());  
	              
	        }  
	        catch (Exception e){  
	            e.printStackTrace();  
	            session.getTransaction().rollback();  
	        }  
	        session.close();  
	    } 
	 
	 public void removeStudent(Student student){  
		  Session session = HibernateUtil.getSessionFactory().openSession();  
	        try  
	        {  
	            String name = student.getName();
	            session.beginTransaction();  
	            session.delete(student);  
	            session.getTransaction().commit();  
	        }  
	        catch (Exception e)  
	        {  
	            e.printStackTrace();  
	            session.getTransaction().rollback();  
	        }  
	        session.close();  
	    } 
	 
	 public void updateInfo(Student student)  {  
		 Session  session = HibernateUtil.getSessionFactory().openSession();  
	        try  
	        {  
	            session.beginTransaction();  
	            session.update(student);  
	            session.flush();  
	            session.getTransaction().commit();  
	        }  
	        catch (Exception e)  
	        {  
	            e.printStackTrace();  
	            session.getTransaction().rollback();  
	        }  
	        session.close();  
	    } 
	 
	 public List <Student> SearchByRecordNo(int ID) {  
		 Session    session = HibernateUtil.getSessionFactory().openSession();  
	        List <Student> StudentDataAccessOperation = new ArrayList < > ();  
	        try  
	        {  
	            session.beginTransaction();  
	            Query qu = session.createQuery("From student std where std.id =:ID"); //User is the entity not the table  
	            qu.setParameter("id", ID);  
	            StudentDataAccessOperation = qu.list();  
	            int count = StudentDataAccessOperation.size();  
	            session.getTransaction().commit();  
	        }  
	        catch (Exception e)  
	        {  
	            e.printStackTrace();  
	            session.getTransaction().rollback();  
	        }  
	        finally  
	        {  
	            session.close();  
	        }  
	        return StudentDataAccessOperation;  
	        
	 }
	 
	 
	 
	 
		

	 
	 
	
}

