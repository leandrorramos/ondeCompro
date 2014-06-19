package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Unidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_unidade")
    private Integer codigoUnidade;   
    private String descricao;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadecodigo")
    private Collection<Item> itemCollection;

    public Unidade() {
    }

    public Unidade(Integer codigoUnidade) {
        this.codigoUnidade = codigoUnidade;
    }

    public Unidade(Integer codigoUnidade, String descricao) {
        this.codigoUnidade = codigoUnidade;
        this.descricao = descricao;
    }

    public Integer getCodigoUnidade() {
        return codigoUnidade;
    }

    public void setCodigoUnidade(Integer codigoUnidade) {
        this.codigoUnidade = codigoUnidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
    }
}
