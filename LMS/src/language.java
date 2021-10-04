import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


@ManagedBean(name="language")
@SessionScoped
public class language  implements Serializable{
	private static final long serialVersionUID = 1L;
    
    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
 
    public Locale getLocale() {
        return locale;
    }
 
    public String getLanguage() {
        return locale.getLanguage();
    }
 
    public void changeLanguage(String language) {
        locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language));
    }
}
