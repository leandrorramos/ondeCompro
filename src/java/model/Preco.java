/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diogo
 */
@Entity
@Table(name = "preco")
@XmlRootElement

public class Preco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_preco")
    private Integer codigoPreco;
    @Column(name = "valor")
    private Long valor;
    @Column(name = "promocao")
    private Short promocao;

    @JoinColumn(name = "Usuarios_codigo", referencedColumnName = "codigo_usuario")
    @ManyToOne
    private Usuario usuarioscodigo;
    
    @JoinColumn(name = "Mercados_codigo", referencedColumnName = "codigo_localidade")
    @ManyToOne
    private Localidade localidade;
    
    @JoinColumn(name = "Item_codigo", referencedColumnName = "codigo_item")
    @ManyToOne
    private Item item;
    public Preco() {
    }

    public Preco(Integer codigoPreco) {
        this.codigoPreco = codigoPreco;
    }

    public Integer getCodigoPreco() {
        return codigoPreco;
    }

    public void setCodigoPreco(Integer codigoPreco) {
        this.codigoPreco = codigoPreco;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public Short getPromocao() {
        return promocao;
    }

    public void setPromocao(Short promocao) {
        this.promocao = promocao;
    }

    @Override
    public String toString() {
        return "model.Preco[ codigoPreco=" + codigoPreco + " ]";
    }

    public Usuario getUsuarioscodigo() {
        return usuarioscodigo;
    }

    public void setUsuarioscodigo(Usuario usuarioscodigo) {
        this.usuarioscodigo = usuarioscodigo;
    }

    public Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPreco != null ? codigoPreco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preco)) {
            return false;
        }
        Preco other = (Preco) object;
        if ((this.codigoPreco == null && other.codigoPreco != null) || (this.codigoPreco != null && !this.codigoPreco.equals(other.codigoPreco))) {
            return false;
        }
        return true;
    }

    
    
}
