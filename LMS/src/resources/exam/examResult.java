package resources.exam;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@SuppressWarnings("serial")
@ManagedBean(name = "examResult")
@SessionScoped
public class examResult implements Serializable{
	private String result;
	private int[] arrays; 
	public static int points; 
	private int[] answersArray = new int[101]; 

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	} 
	
	public int getPoints() {
		return points;
	}
	
	public void calPoints(boolean c) {
		if (c)
		points +=1; 
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	public String showPoints() {
		FacesContext fc = FacesContext.getCurrentInstance();
	      Map<String,String> params = 
	         fc.getExternalContext().getRequestParameterMap();
	      points =  Integer.parseInt(params.get("answersPoints2")); 
	      points = points; 
	      return "/exam/examResult";
	}
	
	public String showPoints(int point) {
		FacesContext fc = FacesContext.getCurrentInstance();
	      Map<String,String> params = 
	         fc.getExternalContext().getRequestParameterMap();
	      points =  Integer.parseInt(params.get("answersPoints2")); 
	      points = points; 
	      return "/exam/examResult";
	}
	

	
	public int[] getAnswersArray() {
		return answersArray;
	}



	public void setAnswersArray(int[] answersArray) {
		this.answersArray = answersArray;
	}
	
	public void setAnswer(int id, int answer) {
		answersArray[id] = answer; 
	}
	
}
