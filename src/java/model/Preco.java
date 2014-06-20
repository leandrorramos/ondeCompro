/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import DAO.PingadaDAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
public class Preco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_preco")
    private Integer codigoPreco;
    private float valor;
    private String promocao;
    private Integer pingadas;

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

    public float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getPromocao() {
        /*System.out.println("Entrei aqui");
        if(promocao != null)
            if (promocao.equals("1")){
                promocao = "SIM";
            }
            else{
                promocao = "NÃO";
            }*/
        return promocao;
    }

    public void setPromocao(String promocao) {
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

    public Integer getPingadas() {
        Integer contador = 0;
        if(this.codigoPreco != null){
            contador = new PingadaDAO().findCountPingada(codigoPreco);
        }
        setPingadas(contador);
        return pingadas;
    }

    public void setPingadas(Integer pingadas) {        
        this.pingadas = pingadas;
    }
    
}
