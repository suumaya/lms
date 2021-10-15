import resources.student.Student;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
 
public class DatabaseOperations {
	 private static Transaction transObj;
	 private static Session sessionObj = HibernateUtil.getSessionFactory().openSession();
	 
	public void addStudentInDb(Student student) {
		try {
            transObj = sessionObj.beginTransaction();
            sessionObj.save(student);
           // System.out.println("Student Record With Id: " + studentObj.getId() + " Is Successfully Created In Database");
 
            // XHTML Response Text
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("createdStudentId",  student.getName());                        
        } catch (Exception exceptionObj) {
            exceptionObj.printStackTrace();
        } finally {
            transObj.commit();
        }
	}

}
