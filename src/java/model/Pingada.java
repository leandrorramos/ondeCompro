package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pingada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_pingada")
    private Integer codigoPingada;
    private Date data;
            
    @JoinColumn(name = "Precos_codigo", referencedColumnName = "codigo_preco")
    @ManyToOne
    private Preco preco;
        
    @JoinColumn(name = "Usuarios_codigo", referencedColumnName = "codigo_usuario")
    @ManyToOne
    private Usuario usuario;
    
    public Pingada() {
    }

    public Pingada(Integer codigoPingada) {
        this.codigoPingada = codigoPingada;
    }

    public Integer getCodigoPingada() {
        return codigoPingada;
    }

    public void setCodigoPingada(Integer codigoPingada) {
        this.codigoPingada = codigoPingada;
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public Preco getPreco() {
        return preco;
    }

    public void setPreco(Preco preco) {
        this.preco = preco;
    }    
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    /*@Override
    public Long getId() {
        return new Long(codigoPingada);
    }
    */
}
