package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Localidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_localidade")
    private Integer codigoLocalidade;
    private String nome;
    private String descricao;

    private double latitude;
    private double longitude;
            
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
    
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
