package resources.exam;

import java.io.Serializable;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.sql.*;

@SuppressWarnings("serial")
@ManagedBean(name = "examsBean")
@SessionScoped
public class exams implements Serializable{
	private List<exam> examData;
	private examService ex; 
	
	public exams() {
		ex = new examService(); 
	}
	public List<exam> getExamData() {
		examData = ex.list(); 
	return examData; 
		}

	public void setExamData(List<exam> examData) {
		this.examData = examData;
	}
	
	

}
