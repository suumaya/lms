
package resources.exam;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

@Named
@RequestScoped
public class questionConverter implements Converter {

    @EJB
    private examService examService;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        try {
            int id = Integer.valueOf(value);
            return examService.getExamQuestions(id);
        } catch (NumberFormatException e) {
            //throw new ConverterException("The value is not a valid exam ID: " + value, e);
        	//exam e = new exam();
        
        	return new exam(); 
        }
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