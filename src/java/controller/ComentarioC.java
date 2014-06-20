package controller;

import DAO.ComentarioDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Comentario;



@ManagedBean(name = "comentarioC")
@ViewScoped
public class ComentarioC {
    
    private Comentario comentario = new Comentario();
    private List<Comentario> comentarioLista;
    
    public ComentarioC(){
        comentarioLista = new ComentarioDAO().findAll();
        if (comentario == null){
            comentario = new Comentario();
        }
    }

    
    public Comentario getComentario() {
        return comentario;
    }

    
    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    
    public List<Comentario> getComentarioLista() {
        return comentarioLista;
    }

    
    public void setComentarioLista(List<Comentario> comentarioLista) {
        this.comentarioLista = comentarioLista;
    }

    
    public void salvarComentario(){
        new ComentarioDAO().save(comentario);
        comentarioLista = new ComentarioDAO().findAll();
        comentario = new Comentario();
    }
    
    public void atualizarComentario(){
        new ComentarioDAO().update(comentario);
        comentarioLista = new ComentarioDAO().findAll();
        comentario = new Comentario();
    }
    
    public void deleteComentario(){
        new ComentarioDAO().delete(comentario);
        comentarioLista = new ComentarioDAO().findAll();
        comentario = new Comentario();
    }
    
}
