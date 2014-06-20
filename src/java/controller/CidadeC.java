package controller;

import DAO.CidadeDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Cidade;

@ManagedBean(name = "cidadeC")
@ViewScoped
public class CidadeC{
    
    private Cidade cidade = new Cidade();
    private List<Cidade> cidadeLista;
    
    public CidadeC(){   
        cidadeLista = new CidadeDAO().findAll();
        if (cidade == null){
            cidade = new Cidade();
        }
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Cidade> getCidadeLista() {
        return cidadeLista;
    }

    public void setCidadeLista(List<Cidade> cidadeLista) {
        this.cidadeLista = cidadeLista;
    }
    
    public void salvarCidade(){
        new CidadeDAO().save(cidade);
        cidadeLista = new CidadeDAO().findAll();
        cidade = new Cidade();
    }
    
    public void atualizarCidade(){
        new CidadeDAO().update(cidade);
        cidadeLista = new CidadeDAO().findAll();
        cidade = new Cidade();
    }
    
    public void deleteCidade(){
        new CidadeDAO().delete(cidade);
        cidadeLista = new CidadeDAO().findAll();
        cidade = new Cidade();
    }
    
}
