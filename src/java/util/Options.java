/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

//@ManagedBean(name = "options")
public class Options {
    
    public static String getBaseUrl(){
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


    
}
