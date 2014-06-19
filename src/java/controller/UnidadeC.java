package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Unidade;
import DAO.UnidadeDAO;

@ManagedBean(name = "unidadeC")
@ViewScoped
public class UnidadeC {

    private Unidade unidade = new Unidade();
    private List<Unidade> unidadeLista;
        
    public void UnidadeC(){
        unidadeLista = new UnidadeDAO().findAll();
        if (unidade == null) {
            unidade = new Unidade();
        }
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public List<Unidade> getUnidadeLista() {
        return unidadeLista;
    }

    public void setUnidadeLista(List<Unidade> unidadeLista) {
        this.unidadeLista = unidadeLista;
    }
    
    public void salvarUnidade(){
        new UnidadeDAO().save(unidade);
        unidadeLista = new UnidadeDAO().findAll();
        unidade = new Unidade();
    }
    
    public void alterarUnidade(){
        new UnidadeDAO().update(unidade);
        unidadeLista = new UnidadeDAO().findAll();
        unidade = new Unidade();
    }
    
    public void excluirUnidade(){
        new UnidadeDAO().delete(unidade);
        unidadeLista = new UnidadeDAO().findAll();
        unidade = new Unidade();
    }
}
