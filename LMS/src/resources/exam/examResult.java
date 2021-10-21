package resources.exam;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@SuppressWarnings("serial")
@ManagedBean(name = "examResult", eager = true)
@SessionScoped
public class examResult implements Serializable{
	private String result;
	
	public static int points; 

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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
	      points =  Integer.parseInt(params.get("points")); 
	      return "examResult";
	}
	
}
