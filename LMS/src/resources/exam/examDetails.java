package resources.exam;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@SuppressWarnings("serial")
@ManagedBean(name = "examDetailsBean")
@SessionScoped
public class examDetails implements Serializable{
	 private exam exam; // +getter +setter

	 
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
	    
	    
	    
}
