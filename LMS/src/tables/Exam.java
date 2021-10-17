package tables;
import java.util.Date;
import java.sql.Time;
import java.time.Duration;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.*;



@Entity
@Table(name="exam", schema = "examinationsys")
public class Exam {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "time")
	private Duration time;
	
	@Column(name = "question_id")
	private int question_id;
	@Column(name = "answer_id")
	private int answer_id;
	
	
	public Exam(int question_id, int answer_id) {
		super();
		
		this.question_id = question_id;
		this.answer_id = answer_id;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public Duration getTime() {
		return time;
	}
	public void setTime(Duration time) {
		this.time = time;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public int getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
	}



	@Override
	public String toString() {
		return "Exam [id=" + id + ", time=" + time + ", question_id=" + question_id + ", answer_id=" + answer_id + "]";
	}

	
	
	
	
}
