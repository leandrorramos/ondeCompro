/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import DAO.ItemDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Item;

/** 
 *
 * @author 2200319
 */

@ManagedBean(name = "itemC")
@ViewScoped
public class ItemC{
    private Item item;
    private List<Item> itemLista;
    
    public ItemC(){
            itemLista = new ItemDAO().findAll();
        
        if (item == null) {
            item = new Item();
        }
    }

    /**
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * @return the itemLista
     */
    public List<Item> getItemLista() {
        return itemLista;
    }

    /**
     * @param itemLista the itemLista to set
     */
    public void setItemLista(List<Item> itemLista) {
        this.itemLista = itemLista;
    }
  
    public void salvarItem(){
        
        try {
            this.item.setUsuarioscodigo(UsuarioLogadoC.getInstance().getUsuario());
        } catch (Exception ex) {
            Logger.getLogger(LocalidadeC.class.getName()).log(Level.SEVERE, null, ex);
        }
        new ItemDAO().save(item);
        itemLista = new ItemDAO().findAll();
        item = new Item();
    }
    
    public void alterarItem(){
        new ItemDAO().update(item);
        itemLista = new ItemDAO().findAll();
        item = new Item();
    }
    
    public void excluirItem(){
        new ItemDAO().delete(item);
        itemLista = new ItemDAO().findAll();
        item = new Item();
    }
    
}
