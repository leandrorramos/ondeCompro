package controller;

import DAO.CategoriaDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Categoria;

@ManagedBean(name = "categoriaC")
@ViewScoped
public class CategoriaC{
    
    private Categoria categoria = new Categoria();
    private List<Categoria> categoriaLista;
    
    public CategoriaC(){   
        categoriaLista = new CategoriaDAO().findAll();
        if (categoria == null){
            categoria = new Categoria();
        }
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Categoria> getCategoriaLista() {
        return categoriaLista;
    }

    public void setCategoriaLista(List<Categoria> categoriaLista) {
        this.categoriaLista = categoriaLista;
    }
    
    public void salvarCategoria(){
        new CategoriaDAO().save(categoria);
        categoriaLista = new CategoriaDAO().findAll();
        categoria = new Categoria();
    }
    
    public void atualizarCategoria(){
        new CategoriaDAO().update(categoria);
        categoriaLista = new CategoriaDAO().findAll();
        categoria = new Categoria();
    }
    
    public void deleteCategoria(){
        new CategoriaDAO().delete(categoria);
        categoriaLista = new CategoriaDAO().findAll();
        categoria = new Categoria();
    }
    
}
