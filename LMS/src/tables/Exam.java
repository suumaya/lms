package tables;
import java.util.List;
import java.util.Date;
import java.sql.Time;
import java.util.Timer;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.code.hibernate.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "exam")
public class Exam implements Serializable {
	private String id;
	private List<Exam> examList;
	private Date dueDate;
	private Time time;
	
	
	public static ExamDatabaseOperations examOperation;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	
	public List getExamList() {
		return examList;
	}
	public void setExamList(List examList) {
		this.examList = examList;
	}
	
	public void addExamRecord() {
        System.out.println("Calling addExam() Method To Save an Exam Record");
        examOperation = new ExamDatabaseOperations();
        examOperation.addingExam(this);
    }
	
	public void deleteExam() {
		 System.out.println("Calling examDeletion() Method To Save an Exam Record");
		examOperation = new ExamDatabaseOperations();
		examOperation.examDeletion(id);
	}
	
	public void updateExam() {
        System.out.println("Calling updatingExam() Method To Update Exam Record");
        examOperation = new ExamDatabaseOperations();     
        examOperation.updatingExam(this);
    }
	
	public List<Exam> examDetails() {
		System.out.println("Calling getExamById() Method To Update Exam Record");
        examOperation = new ExamDatabaseOperations();     
        
        List<Exam> examList = examOperation.getExamById(id);
        for(Exam examById : examList) {
            id = examById.getId();
            
        }
        System.out.println("Fetched Id? " + id );
        return examList;
    }
	}

	

