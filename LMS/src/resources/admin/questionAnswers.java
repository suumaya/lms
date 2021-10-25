package resources.admin;

import java.util.List;

import resources.exam.answer;

public class questionAnswers {
	private String question; 
	private answer answer1;
	private answer answer2;
	private answer answer3;
	private int Id; 
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public answer getAnswer1() {
		return answer1;
	}
	public void setAnswer1(answer answer1) {
		this.answer1 = answer1;
	}
	public answer getAnswer2() {
		return answer2;
	}
	public void setAnswer2(answer answer2) {
		this.answer2 = answer2;
	}
	public answer getAnswer3() {
		return answer3;
	}
	public void setAnswer3(answer answer3) {
		this.answer3 = answer3;
	} 
	
	
}
