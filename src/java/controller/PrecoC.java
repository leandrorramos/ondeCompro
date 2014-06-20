/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import DAO.PrecoDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Preco;
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

    /**
     * @return the preco
     */
    public Preco getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(Preco preco) {
        this.preco = preco;
    }

    /**
     * @return the precoLista
     */
    public List<Preco> getPrecoLista() {
        return precoLista;
    }

    /**
     * @param precoLista the precoLista to set
     */
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
}
