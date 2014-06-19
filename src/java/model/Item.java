package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "codigo_item")
    private Integer codigoItem;
    private int quantidade;
    
    @JoinColumn(name = "Usuarios_codigo", referencedColumnName = "codigo_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioscodigo;
    
    @JoinColumn(name = "Produto_codigo", referencedColumnName = "codigo_produto")
    @ManyToOne(optional = false)
    private Produto produtocodigo;
    
    @JoinColumn(name = "Unidade_codigo", referencedColumnName = "codigo_unidade")
    @ManyToOne(optional = false)
    private Unidade unidadecodigo;
    
    @JoinColumn(name = "Categoria_codigo", referencedColumnName = "codigo_categoria")
    @ManyToOne(optional = false)
    private Categoria categoriacodigo;
    
    @JoinColumn(name = "Marca_codigo", referencedColumnName = "codigo_marca")
    @ManyToOne(optional = false)
    private Marca marcacodigo;

    public Item() {
    }

    public Item(Integer codigoItem) {
        this.codigoItem = codigoItem;
    }

    public Item(Integer codigoItem, int quantidade) {
        this.codigoItem = codigoItem;
        this.quantidade = quantidade;
    }

    public Integer getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(Integer codigoItem) {
        this.codigoItem = codigoItem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Usuario getUsuarioscodigo() {
        return usuarioscodigo;
    }

    public void setUsuarioscodigo(Usuario usuarioscodigo) {
        this.usuarioscodigo = usuarioscodigo;
    }

    public Produto getProdutocodigo() {
        return produtocodigo;
    }

    public void setProdutocodigo(Produto produtocodigo) {
        this.produtocodigo = produtocodigo;
    }

    public Unidade getUnidadecodigo() {
        return unidadecodigo;
    }

    public void setUnidadecodigo(Unidade unidadecodigo) {
        this.unidadecodigo = unidadecodigo;
    }

    public Categoria getCategoriacodigo() {
        return categoriacodigo;
    }

    public void setCategoriacodigo(Categoria categoriacodigo) {
        this.categoriacodigo = categoriacodigo;
    }

    public Marca getMarcacodigo() {
        return marcacodigo;
    }

    public void setMarcacodigo(Marca marcacodigo) {
        this.marcacodigo = marcacodigo;
    }
}
