package resources.exam;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@NamedQueries({
	 @NamedQuery(name  = "carRentalData_searchCarRentals", 
         	 	query = " select c " +
         	 		 " from CarRentalData c " +
         			 " where (:P_ID = -1 or c.id = :P_ID )" +
         			 " and (:P_CONTRACT_NUMBER = '-1' or c.contractNumber = :P_CONTRACT_NUMBER ) " +
         			 " and (:P_CHEQUE_NUMBER = '-1' or c.chequeNumber = :P_CHEQUE_NUMBER ) " +
         			 " and (:P_PLATE_NUMBER = '-1' or c.carPlateNumber = :P_PLATE_NUMBER ) " +
         			 " and (:P_EMPLOYEE_ID = -1 or c.employeeId = :P_EMPLOYEE_ID ) " +
         			 " and (:P_DOMAIN_SUB_RENTAL_COMPANY = -1 or c.domainSubRentalCompanyId = :P_DOMAIN_SUB_RENTAL_COMPANY ) " +
			 		 " and (:P_CONTRACT_STATUS = -1 or c.paid = :P_CONTRACT_STATUS ) "+
			 		 " and (:P_DEPT_ID_LIST_SIZE = 0 or c.departmentId IN (:P_DEPT_ID_LIST)) "+
			 		 " and (:P_RENT_START_DATE_NULL = 1 or PKG_CHAR_TO_DATE (:P_RENT_START_DATE, 'MI/MM/YYYY') <= c.rentStartDate)" + 
			 		 " and (:P_RENT_END_DATE_NULL = 1 or PKG_CHAR_TO_DATE (:P_RENT_END_DATE, 'MI/MM/YYYY') >= c.rentEndDate)" +      
         			 " order by c.rentEndDate desc , c.id "
			 	)
})

@SuppressWarnings("serial")
@Entity
@Table(name = "exam")
public class ExamData implements Serializable {
	@Id
	@Column(name="ID")
	private int examID; 
	@Column(name="answer_ID")
	private int answer_ID; 
	@Column(name="question_ID")
	private int question_ID; 
	private boolean started; 
	@Column(name="time")
	private Time examTime; 
	//@Column(name="examDate")
	private Date examDate; 
	@Column(name="name")
	private String examName;	
	@Column(name="description")
	private String description;
	private ExamData examData;
	private String examCode; 
	
	private int points; 

	public ExamData getExamData() {
		return examData;
	}
	public void setExamData(ExamData examData) {
		this.examData = examData;
	}

	public ExamData() {
		//this.examData = new ExamData(); 
	}
	public boolean isStarted() {
		return started;
	}
	public void setStarted(boolean started) {
		this.started = started;
	}
	public Time getExamTime() {
		return examTime;
	}
	public void setExamTime(Time examTime) {
		this.examTime = examTime;
	}
	public Date getExamDate() {
		return examDate;
	}
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public int getExamID() {
		return examID;
	}
	public void setExamID(int examID) {
		this.examID = examID;
	}
	public int getAnswer_ID() {
		return answer_ID;
	}
	public void setAnswer_ID(int answer_ID) {
		this.answer_ID = answer_ID;
	}
	public int getQuestion_ID() {
		return question_ID;
	}
	public void setQuestion_ID(int question_ID) {
		this.question_ID = question_ID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getExamCode() {
		return examCode;
	}
	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}
	

}

