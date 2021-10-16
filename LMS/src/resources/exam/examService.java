package resources.exam;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class examService {
	// @PersistenceContext
	//   private EntityManager em;

	    public exam find(Long id) {
	     //   return em.find(exam.class, id);
		 return new exam();
	    }

	    public List<exam> list() {
	        //return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
			//Create data just to check.
	    	List<exam> examData = new ArrayList<exam>();
			ExamData obj= new ExamData();
			obj.setExamName("CSC122");
			obj.setExamTime(new Time(0));
			obj.setExamDate(new Date(0));
			question qobj = new question();
			qobj.setQuestion("one");
			qobj.setAnswers(null);
			List<question> questions = new ArrayList<question>();
			questions.add(qobj);
			exam e =new exam();
			e.setExam(obj);
			e.setQuestions(questions);
			answer aobj = new answer();
			aobj.setAnswer("r1");
			List<answer> ans = new ArrayList<answer>();
			ans.add(aobj);
			ans.add(aobj);
			ans.add(aobj);
			qobj.setAnswers(ans);
			try {
			String user = "Admin_SYS@online-examination-system";
			String pass = "WelcomeToServerJSF#12July";
			String connString = "jdbc:mysql://online-examination-system.mysql.database.azure.com:3306/examinationsys?useSSL=true&requireSSL=false";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(connString,user, pass );
			String sql = "select * from exam; "; 
			Statement s = con.prepareStatement(sql); 
			ResultSet re = s.executeQuery(sql);
			while(re.next()) {
				obj.setExamName(re.getString(1));
				e.setExam(obj);
			}

			examData.add(e);
			examData.add(e);
			examData.add(e);
			examData.add(e);
			examData.add(e);
			examData.add(e);
			examData.add(e);
			return examData;
			}catch(Exception ee) {
				obj.setExamName(ee.toString());
				e.setExam(obj);
				examData.add(e);
				examData.add(e);
				examData.add(e);
			return examData;
			}
	    }

	    public void create(exam e) {
	   //     em.persist(e);
	    }

	    public void update(exam e) {
	//        em.merge(e);
	    }

	    public void delete(exam e) {
	//        em.remove(em.contains(e) ? e : em.merge(e));
	    }

}
