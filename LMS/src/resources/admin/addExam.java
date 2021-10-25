package resources.admin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
		private String examText; 
		private  static questionAnswers question1; 
		private  static questionAnswers question2; 
		private  static questionAnswers question3; 
		private  static questionAnswers question4; 
		private  static questionAnswers question5; 
		private int[] qNumber= new int[10]; 
		private static List<questionAnswers> questions; 

		public addExam() {
			ex = new examService();
			exam = new exam(); 
			question1 = new questionAnswers(); 
			question2 = new questionAnswers(); 
			question3 = new questionAnswers(); 
			question4 = new questionAnswers(); 
			question5 = new questionAnswers(); 
		}
		public static String addExam() {
			questions = new ArrayList<questionAnswers>();
			
			questions.add(question1);
			questions.add(question2);
			questions.add(question3);
			questions.add(question4);
			questions.add(question5);
			
			exam.addQuestionAndAnswers(questions);
			return examService.addExam(exam);
//			return "SUCCESS";
		}
		
//		public static void getList() {
//			questions.add(question1);
//			questions.add(question2);
//			questions.add(question3);
//			questions.add(question4);
//			questions.add(question5);
//		}
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
	public  questionAnswers getQuestion1() {
		return question1;
	}
	public  void setQuestion1(questionAnswers question1) {
		this.question1 = question1;
	}
	public  questionAnswers getQuestion2() {
		return question2;
	}
	public  void setQuestion2(questionAnswers question2) {
		this.question2 = question2;
	}
	public  questionAnswers getQuestion3() {
		return question3;
	}
	public  void setQuestion3(questionAnswers question3) {
		this.question3 = question3;
	}
	public  questionAnswers getQuestion4() {
		return question4;
	}
	public  void setQuestion4(questionAnswers question4) {
		this.question4 = question4;
	}
	public  questionAnswers getQuestion5() {
		return question5;
	}
	public  void setQuestion5(questionAnswers question5) {
		this.question5 = question5;
	}
	public String getExamText() {
		return examText;
	}
	public void setExamText(String examText) {
		this.examText = examText;
	}
	
	 
}
