package model;


import controller.BaseEntity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_usuario")
    private Integer codigoUsuario;
    private short tipo;
    private String nome;
    private String email;
    private String senha;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    private String ativo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioscodigo")
    private Collection<Item> itemCollection;

    public Usuario() {
    }

    public Usuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Usuario(Integer codigoUsuario, short tipo, String nome, String email, String senha, Date data) {
        this.codigoUsuario = codigoUsuario;
        this.tipo = tipo;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.data = data;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public short getTipo() {
        return tipo;
    }

    public void setTipo(short tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    @XmlTransient
    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
    }
}
