package controller;

import DAO.MarcaDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Marca;

@ManagedBean(name = "marcaC")
@ViewScoped
public class MarcaC{
    
    private Marca marca = new Marca();
    private List<Marca> marcaLista;
    
    public MarcaC(){   
        marcaLista = new MarcaDAO().findAll();
        if (marca == null){
            marca = new Marca();
        }
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Marca> getMarcaLista() {
        return marcaLista;
    }

    public void setMarcaLista(List<Marca> marcaLista) {
        this.marcaLista = marcaLista;
    }
    
    public void salvarMarca(){
        new MarcaDAO().save(marca);
        marcaLista = new MarcaDAO().findAll();
        marca = new Marca();
    }
    
    public void atualizarMarca(){
        new MarcaDAO().update(marca);
        marcaLista = new MarcaDAO().findAll();
        marca = new Marca();
    }
    
    public void deleteMarca(){
        new MarcaDAO().delete(marca);
        marcaLista = new MarcaDAO().findAll();
        marca = new Marca();
    }
    
}
