package controller;

import DAO.LocalidadeDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Localidade;

@ManagedBean(name = "localidadeC")
@ViewScoped
public class LocalidadeC{
    
    private Localidade localidade = new Localidade();
    private List<Localidade> localidadeLista;
    
    public LocalidadeC(){
        localidadeLista = new LocalidadeDAO().findAll();
        if (localidade == null){
            localidade = new Localidade();
        }
    }

    public Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }

    public List<Localidade> getLocalidadeLista() {
        return localidadeLista;
    }

    public void setLocalidadeLista(List<Localidade> localidadeLista) {
        this.localidadeLista = localidadeLista;
    }
    
    public void salvarLocalidade(){
        try {
            this.localidade.setUsuario(UsuarioLogadoC.getInstance().getUsuario());
        } catch (Exception ex) {
            Logger.getLogger(LocalidadeC.class.getName()).log(Level.SEVERE, null, ex);
        }
        new LocalidadeDAO().save(localidade);
        localidadeLista = new LocalidadeDAO().findAll();
        localidade = new Localidade();
    }
    
    public void atualizarLocalidade(){
        new LocalidadeDAO().update(localidade);
        localidadeLista = new LocalidadeDAO().findAll();
        localidade = new Localidade();
    }
    
    public void deleteLocalidade(){
        new LocalidadeDAO().delete(localidade);
        localidadeLista = new LocalidadeDAO().findAll();
        localidade = new Localidade();
    }
    
}
