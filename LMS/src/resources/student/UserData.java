package resources.student;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import resources.exam.ExamData;


@NamedQueries({
	 @NamedQuery(name  = "userData_searchStudents", 
         	 	query = " select c " +
         	 		 " from student c " +
         			 " where (:P_ID = -1 or c.id = :P_ID )" +
         			 " and (:P_username = '-1' or c.username = :P_username ) " +
         			 " order by c.username desc , c.id "
			 	)
}) 

@SuppressWarnings("serial")
@Entity

@Table(name = "student")
public class UserData implements Serializable {
	  private static final long serialVersionUID = 6081417964063918994L;
	 
	   
	 
	   


	   
	   
 
}

