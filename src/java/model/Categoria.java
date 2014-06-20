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
public class Categoria implements Serializable,BaseEntity{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_categoria")
    private Integer codigoCategoria;
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriacodigo")
    private Collection<Item> itemCollection;

    public Categoria() {
    }

    public Categoria(Integer codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public Categoria(Integer codigoCategoria, String descricao) {
        this.codigoCategoria = codigoCategoria;
        this.descricao = descricao;
    }

    public Integer getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(Integer codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
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

    @Override
    public Long getId() {
        return new Long(codigoCategoria);
    }
    @Override
    public int hashCode() { return getDescricao().length() * 8; }

    @Override
    public boolean equals(Object obj) {
    
        return (obj instanceof Categoria) && ((Categoria) obj).getCodigoCategoria().equals(this.getCodigoCategoria());
    }
}
