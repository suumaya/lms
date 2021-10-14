package tables;
import java.util.Date;
import java.sql.Time;
import java.util.Timer;


public class Exam {
	private String id;
	private Date dueDate;
	private Time time;
	private Timer countDownTimer;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Timer getCountDownTimer() {
		return countDownTimer;
	}
	public void setCountDownTimer(Timer countDownTimer) {
		this.countDownTimer = countDownTimer;
	}

	
	
	
}
