/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import DAO.ProdutoDAO;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;
import model.Produto;
import org.primefaces.event.CaptureEvent;
import util.Options;

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
    
    public void capturarImagem(CaptureEvent ce){
        
        Options o = new Options();
        Produto prod = new Produto();
        
        prod.setImagem(o.getRandomName()+".png");
        
        byte[] dados = ce.getData();
        
        ServletContext sc = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        
        String file = sc.getRealPath("")+File.separator+"resources"+File.separator+"img"+File.separator+prod.getImagem();
        
        FileImageOutputStream stream;
        try {
            stream = new FileImageOutputStream(new File(file));
            stream.write(dados, 0, dados.length);
            stream.close();
        } catch (IOException e) {
            throw new FacesException("Erro ao escrever a imagem." + e.getMessage());
        }
    }
}
