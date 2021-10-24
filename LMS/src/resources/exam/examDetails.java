package resources.exam;

import java.io.Serializable;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@ManagedBean(name = "examDetailsBean", eager = true)
@SessionScoped
public class examDetails implements Serializable{
	 private exam exam; // +getter +setter
		private int points; 
		private int[] answersArray = new int[101]; 

	 
	    private examService examService;

		public exam getExam() {
			return exam;
		}

		public void setExam(exam exam) {
			this.exam = exam;
		}

		public examService getExamService() {
			return examService;
		}

		public void setExamService(examService examService) {
			this.examService = examService;
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
//		      points =  Integer.parseInt(params.get("points")); 
		      return "examResult";
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
		
//		public String enterExam(int examID) {
//			HttpSession session = SessionUtils.getSession();
//			session.setAttribute("examID", examID);
//			return "/exam/examDetails";
//		}
	    
}
