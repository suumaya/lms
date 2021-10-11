package resources.exam;

import java.io.Serializable;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.sql.*;

@SuppressWarnings("serial")
@ManagedBean(name = "examsBean")
@SessionScoped
public class exams implements Serializable{
	private List<exam> examData;

	
	public List<exam> getExamData() {
		//Create data just to check.
		examData = new ArrayList<exam>();
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



		//return examData;



		try {
		/*SSLContext context = SSLContext.getInstance("TLSv1.2");
		context.init(null,null,null);
		SSLContext.setDefault(context);
		SSLSocketFactory factory = (SSLSocketFactory)context.getSocketFactory();
		SSLSocket socket = (SSLSocket)factory.createSocket();
		String[] protocols = socket.getEnabledProtocols();
		*/
		String user = "Admin_SYS@online-examination-system";
		String pass = "WelcomeToServerJSF#12July";
		String connString = "jdbc:mysql://online-examination-system.mysql.database.azure.com:3306/examinationsys?useSSL=true&requireSSL=false";
		Class.forName("com.mysql.jdbc.Driver");
		//DriverManager.getConnection(connString,user,pass);

		//Connection con = DriverManager.getConnection(connString,user,pass);
		
		Connection con=DriverManager.getConnection(connString,user, pass );



		examData.add(e);
		examData.add(e);
		examData.add(e);
		examData.add(e);
		// Context ctx = new InitialContext();
		// DataSource ds = (DataSource)ctx.lookup(connString);
		// Connection con2 = ds.getConnection(user,pass);

		// Context initContext = new InitialContext();
		// Context envContext = (Context)initContext.lookup("java:comp/env");
		// DataSource ds = (DataSource)envContext.lookup("jdbc/PollDatasource");
		// Connection connection = ds.getConnection();
		examData.add(e);
		examData.add(e);
		examData.add(e);

		return examData;
		}catch(Exception ee) {
		return examData;
		}
		}
	
	
	
	
	
	

	public void setExamData(List<exam> examData) {
		this.examData = examData;
	}
	
	

}
