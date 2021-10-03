package resources;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;


@SuppressWarnings("serial")
@ManagedBean(name = "examBean")
@SessionScoped
public class exam implements Serializable{
	private boolean started; 
	private Time examTime; 
	private Date examDate; 
	private List<ExamData> examData;
	private String examName;
	
	public boolean isStarted() {
		return started;
	}
	public void setStarted(boolean started) {
		this.started = started;
	}
	public List<ExamData> getExamData() {
		//Create data just to check. 
		examData = new ArrayList<ExamData>();
		ExamData obj= new ExamData(); 
		obj.setExamName("CSC122");
		obj.setExamTime(new Time(0));
		obj.setExamDate(new Date(0));
		examData.add(obj);
		examData.add(obj);
		examData.add(obj);
		examData.add(obj);
		examData.add(obj);
		examData.add(obj);
		examData.add(obj);
		return examData;
	}
	public void setExamData(List<ExamData> examData) {
		this.examData = examData;
	}
	
	
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
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

	

}

