package resources.exam;

import java.io.Serializable;
import java.util.*;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@SuppressWarnings("serial")
@ManagedBean(name = "questionsBean")
@SessionScoped
public class questions implements Serializable{
	private List<question> questionsList = new ArrayList<question>();

	public List<question> getQuestionsList() {
		return questionsList;
	}

	public void setQuestionsList(List<question> questionsList) {
		this.questionsList = questionsList;
	} 
	
	
}
