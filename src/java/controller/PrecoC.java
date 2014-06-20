/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import DAO.PrecoDAO;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Pingada;
import model.Preco;
import util.Options;
/**
 *
 * @author Diogo
 */
@ManagedBean(name = "precoC")
@ViewScoped
public class PrecoC {
    private Preco preco;
    private List<Preco> precoLista;
    
    public PrecoC(){
        precoLista = new PrecoDAO().findAll();        
        if (preco == null) {
            preco = new Preco();
        }
    }

    public Preco getPreco() {
        return preco;
    }

    public void setPreco(Preco preco) {
        this.preco = preco;
    }

    public List<Preco> getPrecoLista() {
        return precoLista;
    }

    public void setPrecoLista(List<Preco> precoLista) {
        this.precoLista = precoLista;
    }
  
    public void salvarPreco(){
        
        try {
            this.preco.setUsuarioscodigo(UsuarioLogadoC.getInstance().getUsuario());
        } catch (Exception ex) {
            Logger.getLogger(LocalidadeC.class.getName()).log(Level.SEVERE, null, ex);
        }
        new PrecoDAO().save(preco);
        precoLista = new PrecoDAO().findAll();
        preco = new Preco();
    }
    
    public void alterarPreco(){
        new PrecoDAO().update(preco);
        precoLista = new PrecoDAO().findAll();
        preco = new Preco();
    }
    
    public void excluirPreco(){
        new PrecoDAO().delete(preco);
        precoLista = new PrecoDAO().findAll();
        preco = new Preco();
    }
    
    public void salvarPingada(){       
        PingadaC pingadaC = new PingadaC();        
        try {
            //pega instancia do usuario
            pingadaC.getPingada().setUsuario(UsuarioLogadoC.getInstance().getUsuario());
            pingadaC.getPingada().setPreco(this.preco);
            pingadaC.getPingada().setData(new Date());            
            pingadaC.salvarPingada();
            
        } catch (Exception ex) {
            Logger.getLogger(LocalidadeC.class.getName()).log(Level.SEVERE, null, ex);
        }        
        //precoLista = new PrecoDAO().findAll();
        //preco = new Preco(); 
        
        try {  
            FacesContext.getCurrentInstance().getExternalContext().redirect(Options.getBaseUrl()+"/");
        } catch (IOException ex) {
            Logger.getLogger(PrecoC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
