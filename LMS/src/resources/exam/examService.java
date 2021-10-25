package resources.exam;

import java.io.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Stateless
public class examService {
	private static List<exam> examData = new ArrayList<exam>();
	private static Connection con; 
	private static String user = "Admin_SYS@online-examination-system";
	private static String pass = "WelcomeToServerJSF#12July";
	private static String connString = "jdbc:mysql://online-examination-system.mysql.database.azure.com:3306/examinationsys?useSSL=true&requireSSL=false";
	
	
	public static String addExam(exam e) {
		String result= "FAIL"; 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(connString,user, pass );
			String sql = "Insert into examinationsys.exam values ('"
			+e.getExam().getExamID()+"','"
			+e.getExam().getExamID()+"','"
			+e.getExam().getExamID()+"','"
			+e.getExam().getExamID()+"','"
			+e.getExam().getExamID()+"','"
			+e.getExam().getExamID()+"','"
			+e.getExam().getExamID()+"');";
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			//Questions insert
			//Answers insert 
			result = "SUCCESS";
		}catch(Exception ee) {
			ee.printStackTrace();
		}
		return result;
	}

	    public static exam find(int id) {
	    	for (exam e : examData){
	            if (e.getExam().getExamID()==id) {
	            	questions qList = getExamQuestions(e.getExam().getQuestion_ID()); 
	            	e.setQuestions(qList.getQuestionsList());
	            	 return e; 
	            }
	                 
	            }
		 return new exam();
	    }
	    public static questions getExamQuestions(int questionId) {
	    	 
//	    	exam e = find(examId); 
//	    	int questionId = e.getExam().getQuestion_ID(); 
	    	questions qList = new questions(); 
			List<question> questions = new ArrayList<question>();

	    	try {
	    		Class.forName("com.mysql.jdbc.Driver");
	    		con=DriverManager.getConnection(connString,user, pass );
				String sql = "select * from question where ID="+questionId+";"; 
				Statement s = con.prepareStatement(sql); 
				ResultSet re = s.executeQuery(sql);
				List<answer> ansList = new ArrayList<answer>();
				while(re.next()) {
					question qobj = new question();
					int ansID = Integer.parseInt(re.getString(3)); //answer_ID					
					qobj.setQuestion(re.getString(2));//Question
					qobj.setId(Integer.parseInt(re.getString(1)));//Id
					ansList = getQuestionAnswers(ansID); 
					qobj.setAnswers(ansList);
					questions.add(qobj);
				}
				}catch(Exception ee) {

				}
	    	qList.setQuestionsList(questions);
	    	return qList; 
	    }
	    
	    public static List<answer> getQuestionAnswers(int ansID){
			List<answer> ans = new ArrayList<answer>();
			 
	    	try {
	    		Class.forName("com.mysql.jdbc.Driver");
	    		con=DriverManager.getConnection(connString,user, pass );
				String sql = "select * from answer where id = "+ansID+";"; 
				Statement s = con.prepareStatement(sql); 
				ResultSet re = s.executeQuery(sql);
				while(re.next()) {				
					answer aobj = new answer();
					aobj.setId(Integer.parseInt(re.getString(1)));//Id
			    	aobj.setAnswer(re.getString(2));
			    	if(Integer.parseInt(re.getString(3))==1)
			    	aobj.setCorrect(true);
			    	else
			    		aobj.setCorrect(false);
					ans.add(aobj);
				}
				}catch(Exception ee) {

				}

	    	return ans; 
	    }

	    public static List<exam> list() {
	    	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(connString,user ,pass );
			String sql = "select * from exam; "; 
			Statement s = con.prepareStatement(sql); 
			ResultSet re = s.executeQuery(sql);
			while(re.next()) {
				ExamData obj= new ExamData();
				exam e =new exam();
				obj.setExamID(Integer.parseInt(re.getString(1)));
				obj.setQuestion_ID(Integer.parseInt(re.getString(2)));
				obj.setAnswer_ID(Integer.parseInt(re.getString(3)));
				obj.setExamTime(new Time(0));
				obj.setExamDate(new Date(0));
				obj.setExamName(re.getString(5));
				obj.setDescription(re.getString(6));
				e.setExam(obj);
				examData.add(e);
			}
			
		}catch(Exception ee) {
			ee=ee;
			}
		return examData;
	    }
	    
	    @SuppressWarnings({ "rawtypes", "unused" })
		public void retrieveUserAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        Statement statement = null;
            ResultSet resultSet = null;
            
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
               
            }
             con= DriverManager.getConnection(connString,user, pass );
            Enumeration retrieve = request.getParameterNames();
            statement = con.createStatement();
            HttpSession session = request.getSession();
            
            int marks = 0;
            
           while(retrieve.hasMoreElements()){
              
           String var = (String) retrieve.nextElement();
           resultSet = statement.executeQuery("");  // query statement 
           
           String [] useranswers = request.getParameterValues(var);
           
           for(String i:useranswers){
               
                  while (resultSet.next()){ 
                        String rightAnswers = resultSet.getString("answer");
                        

                    if(i.equals(rightAnswers)){
                        marks++;
                      
                    }
                  
                  }
               }
           
           }
	   }
        catch(SQLException e) {
        	
        }
        
	 }
}
	   
	    

	    
	    
