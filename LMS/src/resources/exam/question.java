package resources.exam;

import java.util.List;

public class question {
	private String question; 
	private List<answer> answers;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<answer> answers) {
		this.answers = answers;
	} 
	
}
