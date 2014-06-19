package model;

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
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Marca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_marca")
    private Integer codigoMarca;
    private String descricao;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marcacodigo")
    private Collection<Item> itemCollection;

    public Marca() {
    }

    public Marca(Integer codigoMarca) {
        this.codigoMarca = codigoMarca;
    }

    public Marca(Integer codigoMarca, String descricao) {
        this.codigoMarca = codigoMarca;
        this.descricao = descricao;
    }

    public Integer getCodigoMarca() {
        return codigoMarca;
    }

    public void setCodigoMarca(Integer codigoMarca) {
        this.codigoMarca = codigoMarca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
    }
}
