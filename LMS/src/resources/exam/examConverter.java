package resources.exam;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

@Named
@RequestScoped
public class examConverter implements Converter {

    @EJB
    private examService examService;
    private static boolean flag=true; 

    public String  save() {
    	 return "/exam/examQuestions?faces-redirect=true";
    }
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
    	if(flag) {
    		
    	
        if (value == null || value.isEmpty()) {
            return null;
        }

        try {
            int id = Integer.valueOf(value);
//            flag = false; 

            return examService.find(id);

        } catch (NumberFormatException e) {
            //throw new ConverterException("The value is not a valid exam ID: " + value, e);
        	//exam e = new exam();
        
        	return new exam(); 
        }
    	}
    	else flag = true; 
    	return null; 
    }

    @Override    
    public String getAsString(FacesContext context, UIComponent component, Object value) {        
        if (value == null) {
            return "";
        }

        if (value instanceof exam) {
            Long id = (long) ((exam) value).getExam().getExamID();
            return (id != null) ? String.valueOf(id) : null;
        } else {
           // throw new ConverterException("The value is not a valid exam instance: " + value);
        	return null; 
        }
    }

}