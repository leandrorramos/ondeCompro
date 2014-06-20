package model;

import controller.BaseEntity;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;


@Entity
public class Produto implements Serializable ,BaseEntity{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_produto")
    private Integer codigoProduto;
    private String nome;
    private String descricao;
    private String imagem;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtocodigo")
    private Collection<Item> itemCollection;

    public Produto() {
    }

    public Produto(Integer codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public Produto(Integer codigoProduto, String nome, String descricao) {
        this.codigoProduto = codigoProduto;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Integer getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Integer codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @XmlTransient
    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
    }
    
    @Override
    public Long getId() {
        return new Long(codigoProduto);
    }
}