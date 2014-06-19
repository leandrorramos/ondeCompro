package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Localidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_localidade")
    private Integer codigoLocalidade;
    private String nome;
    private String descricao;
    //private Integer usuariocodigo;
        
    @JoinColumn(name = "Usuario_codigo", referencedColumnName = "codigo_usuario")
    @ManyToOne
    private Usuario usuario;
    
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "localidadecodigo")
    //private Collection<Item> itemCollection;

    public Localidade() {
    }

    public Localidade(Integer codigoLocalidade) {
        this.codigoLocalidade = codigoLocalidade;
    }

    public Localidade(Integer codigoLocalidade, String descricao) {
        this.codigoLocalidade = codigoLocalidade;
        this.descricao = descricao;
    }

    public Integer getCodigoLocalidade() {
        return codigoLocalidade;
    }

    public void setCodigoLocalidade(Integer codigoLocalidade) {
        this.codigoLocalidade = codigoLocalidade;
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
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /*@XmlTransient    
    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
    }*/
}
