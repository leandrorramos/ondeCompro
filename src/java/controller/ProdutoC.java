/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import DAO.ProdutoDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Produto;

/**
 *
 * @author 2200319
 */
@ManagedBean(name = "produtoC")
@ViewScoped
public class ProdutoC {
     private Produto produto = new Produto();
     private List<Produto> produtoLista;
        
    public ProdutoC(){
            produtoLista = new ProdutoDAO().findAll();
        
        if (produto == null) {
            produto = new Produto();
        }
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutoLista() {
        return produtoLista;
    }

    public void setProdutoLista(List<Produto> produtoLista) {
        this.produtoLista = produtoLista;
    }
    
    public void salvarProduto(){
        new ProdutoDAO().save(produto);
        produtoLista = new ProdutoDAO().findAll();
        produto = new Produto();
    }
    
    public void alterarProduto(){
        new ProdutoDAO().update(produto);
        produtoLista = new ProdutoDAO().findAll();
        produto = new Produto();
    }
    
    public void excluirProduto(){
        new ProdutoDAO().delete(produto);
        produtoLista = new ProdutoDAO().findAll();
        produto = new Produto();
    }
}
