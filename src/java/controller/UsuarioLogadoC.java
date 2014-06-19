package controller;  
  
//import com.estagio.business.UsuarioBO;  
//import dao.UsuarioDAO;
import DAO.UsuarioDAO;
import model.Usuario;  
import java.io.IOException;  
import java.io.Serializable;
import javax.annotation.PostConstruct;  
import javax.faces.application.FacesMessage;  
import javax.faces.bean.ManagedBean;  
import javax.faces.bean.SessionScoped;  
import javax.faces.context.FacesContext;  
  
/** 
* @author Cristian Urbainski 
* @since 01/05/2012 
*/  
@ManagedBean(name="usuarioLogadoC")  
@SessionScoped
public class UsuarioLogadoC implements Serializable{  
      
    private Usuario usuario;  
    private Boolean usuarioLogado;        
    private static UsuarioLogadoC instance;  
  
    @PostConstruct  
    public void inicializa()  
    {  
        usuario = new Usuario();  
        usuarioLogado = Boolean.FALSE;  
        instance = this;  
    }  
      
    public Usuario getUsuario() {  
        return usuario;  
    }  
  
    public void setUsuario(Usuario usuario) {  
        this.usuario = usuario;  
    }
    
    
    
    public static UsuarioLogadoC getInstance() throws Exception  
    {  
        if(instance == null)  
        {  
            throw new Exception("Não há usuario logado no sistema, Oh my god!");  
        }  
        return instance;  
    }  
      
    public void logout() throws IOException  
    {  
        this.usuario = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();  
        FacesContext.getCurrentInstance().getExternalContext().redirect("../login.xhtml");  
        this.inicializa();
    }  
      
    public void fazerLogin()  
    {  
        try {
            Usuario u = null;
            u = new UsuarioDAO().findById(this.usuario.getCodigoUsuario());
              
            if(u == null)  
            {  
                FacesContext.getCurrentInstance().addMessage(null,   
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Usuario não encontrado ou senha incorreta, tente novamente."));  
            }  
            else  
            {  
                usuarioLogado = Boolean.TRUE;  
                usuario = u;  
                
                //redirecionar usuario logado
                FacesContext.getCurrentInstance().getExternalContext().redirect("usuario/index.xhtml");  
            }  
              
        } catch (Exception e) {  
            FacesContext.getCurrentInstance().addMessage(null,   
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao efetuar login, tente novamente."));  
        }  
    }  
    
    public String getNomeUsuario() throws IOException  
    {  
        if(usuarioLogado)  
        {  
            return usuario.getNome();
        }  
          
        FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");  
        return "";  
    }  
      
}  