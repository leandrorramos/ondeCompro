package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Usuario;
import DAO.UsuarioDAO;

@ManagedBean(name = "usuarioC")
@ViewScoped
public class UsuarioC {
    
    Usuario usuario = new Usuario();
    List<Usuario> usuarioLista;
    
    public UsuarioC(){
        usuarioLista = new UsuarioDAO().findAll();
        if (usuario == null){
            usuario = new Usuario();
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarioLista() {
        return usuarioLista;
    }

    public void setUsuarioLista(List<Usuario> usuarioLista) {
        this.usuarioLista = usuarioLista;
    }
    
    public void salvarUsuario(){
        new UsuarioDAO().save(usuario);
        usuarioLista = new UsuarioDAO().findAll();
        usuario = new Usuario();
    }
    
    public void atualizarUsuario(){
        new UsuarioDAO().update(usuario);
        usuarioLista = new UsuarioDAO().findAll();
        usuario = new Usuario();
    }
    
    public void deleteUsuario(){
        new UsuarioDAO().delete(usuario);
        usuarioLista = new UsuarioDAO().findAll();
        usuario = new Usuario();
    }
    
}
