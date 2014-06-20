package util;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name = "optionC")
@ViewScoped
public class Options {
    
    public String getBaseUrl(){
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        StringBuffer buffer = new StringBuffer();
        buffer.append(request.getScheme());  //http,https,...
        buffer.append("://");
        buffer.append(request.getServerName()); //localhost
        if (request.getServerPort() != 80){
            buffer.append(":"); //localhost
            buffer.append(request.getServerPort()); //8080
        }
        if (request.getContextPath() !=""){
            //buffer.append("/");
            buffer.append(request.getContextPath());
        }
        else 
            buffer.append("/");
        return buffer.toString();
    }
    
    public String getRandomName() {
        int i = (int) (Math.random() * 10000000);

        return String.valueOf(i);
    }

    public String getURLContext(){
        ServletContext sc = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        return sc.getRealPath("");
    }
    
}
