/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author SauloGóes
 */
@Entity
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_empresa")
    private Integer codigoEmpresa;
    private String cnpj;
    @Column(name = "nomefantasia")
    private String nomeFantasia;
    @JoinColumn(name = "Usuarios_codigo", referencedColumnName = "codigo_usuario")
    @ManyToOne
    private Usuario usuarioscodigo;

    public Empresa() {
    }

    public Empresa(Integer codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public Empresa(Integer codigoEmpresa, String cnpj, Date inicio, Date validade) {
        this.codigoEmpresa = codigoEmpresa;
        this.cnpj = cnpj;
    }

    public Integer getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(Integer codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public Usuario getUsuarioscodigo() {
        return usuarioscodigo;
    }

    public void setUsuarioscodigo(Usuario usuarioscodigo) {
        this.usuarioscodigo = usuarioscodigo;
    }
}
