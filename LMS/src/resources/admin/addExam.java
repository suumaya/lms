package resources.admin;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import resources.exam.exam;
import resources.exam.examService;

@SuppressWarnings("serial")
@ManagedBean(name = "addExamBean")
@SessionScoped
public class addExam implements Serializable{
	 private static exam exam; // +getter +setter
		private examService ex;
		private int[] qNumber= new int[10]; 

		public addExam() {
			ex = new examService();
		}
		public static String addExam() {
			return examService.addExam(exam);
//			return "SUCCESS";
		}
	public exam getExam() {
		return exam;
	}

	public void setExam(exam exam) {
		this.exam = exam;
	}

	public examService getEx() {
		return ex;
	}

	public void setEx(examService ex) {
		this.ex = ex;
	}
	public int[] getqNumber() {
		return qNumber;
	}
	public void setqNumber(int[] qNumber) {
		this.qNumber = qNumber;
	}
	 
	 
}
