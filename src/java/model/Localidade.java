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
    
    private String logradouro;
    private String numero;
    private String bairro;
    private String cep;        
    private String latitude;
    private String longitude;
    
    @JoinColumn(name = "id_cidade", referencedColumnName = "id_cidade")
    @ManyToOne
    private Cidade cidade;
        
    @JoinColumn(name = "Usuario_codigo", referencedColumnName = "codigo_usuario")
    @ManyToOne
    private Usuario usuario;
    
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
    
    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
       
    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    /*public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }*/

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
