import tables.Exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class createExamObject {
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Exam.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			// create a exam object
			
			System.out.println("Creating new exam object...");
			Exam exam = new Exam(3, 6);
			
			// start a transaction
			session.beginTransaction();
			
			// save the exam object
			System.out.println("Saving the student...");
			session.save(exam);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}


}

