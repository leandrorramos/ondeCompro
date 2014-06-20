package controller;

import DAO.PingadaDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Pingada;

@ManagedBean(name = "pingadaC")
@ViewScoped
public class PingadaC{
    
    private Pingada pingada = new Pingada();
    private List<Pingada> pingadaLista;
    
    public PingadaC(){
        /*pingadaLista = new PingadaDAO().findAll();
        if (pingada == null){
            pingada = new Pingada();
        }*/
    }
    
    public PingadaC(Integer codigoPreco){
        pingadaLista = new PingadaDAO().findPingada(codigoPreco);
        if (pingada == null){
            pingada = new Pingada();
        }
    }

    public Pingada getPingada() {
        return pingada;
    }

    public void setPingada(Pingada pingada) {
        this.pingada = pingada;
    }

    public List<Pingada> getPingadaLista() {        
        return pingadaLista;
    }
    /*
    public List<Pingada> getPingadaLista(Integer codigoPreco) {
        pingadaLista = new PingadaDAO().findPingada(codigoPreco);
        return pingadaLista;
    }*/

    public void setPingadaLista(List<Pingada> pingadaLista) {
        this.pingadaLista = pingadaLista;
    }
    
    public void salvarPingada(){
        new PingadaDAO().save(pingada);
        pingadaLista = new PingadaDAO().findAll();
        pingada = new Pingada();
    }
    
    public void atualizarPingada(){
        new PingadaDAO().update(pingada);
        pingadaLista = new PingadaDAO().findAll();
        pingada = new Pingada();
    }
    
    public void deletePingada(){
        new PingadaDAO().delete(pingada);
        pingadaLista = new PingadaDAO().findAll();
        pingada = new Pingada();
    }
    
}
