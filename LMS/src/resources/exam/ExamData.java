package resources.exam;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.Entity;
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
	private boolean started; 
	private Time examTime; 
	private Date examDate; 
	private String examName;
	private ExamData examData;
	
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
	

}

