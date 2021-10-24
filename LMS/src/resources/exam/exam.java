package resources.exam;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

public class exam {
	private ExamData exam; 
	private List<question> questions; 
	private int points; 
	
	
	public exam() {
	}

	public ExamData getExam() {
		return exam;
	}



	public void setExam(ExamData exam) {
		this.exam = exam;
	}



	public List<question> getQuestions() {
		return questions;
	}



	public void setQuestions(List<question> questions) {
		this.questions = questions;
	}



	public void enterExam(int examID) {
		
	}
	
	public void clickeRadioButton(String clicked) {
		points+=1; 
	}



	public int getPoints() {
		return points;
	}



	public void setPoints(int points) {
		this.points = points;
	}
	
	public String showPoints() {
		FacesContext fc = FacesContext.getCurrentInstance();
	      Map<String,String> params = 
	         fc.getExternalContext().getRequestParameterMap();
//	      points =  Integer.parseInt(params.get("points")); 
	      return "examResult";
	}



	

}

