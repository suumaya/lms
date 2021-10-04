import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


@ManagedBean(name="language")
@SessionScoped
public class language  implements Serializable{
    
    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
 
    public Locale getLocale() {
        return locale;
    }
 
    public String getLanguage() {
        return locale.getLanguage();
    }
 
    public void changeLanguage() {
    	
    	if("en".equals(locale.getLanguage()))
            locale = new Locale("ar");
    	else
        locale = new Locale("en");
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
}
