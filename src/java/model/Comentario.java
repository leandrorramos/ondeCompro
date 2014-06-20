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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 2200319
 */
@Entity
public class Comentario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    
    
    @Column(name = "codigo_comentario")
    private Integer codigoComentario;
    private String descricao;
    private Short qualificacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    
     @JoinColumn(name = "Usuario_codigo", referencedColumnName = "codigo_usuario")
    @ManyToOne
    private Usuario usuario;
     
     @JoinColumn(name = "Item_codigo", referencedColumnName = "codigo_item")
    @ManyToOne
    private Item item;

    public Comentario() {
    }

    public Comentario(Integer codigoComentario) {
        this.codigoComentario = codigoComentario;
    }

    public Integer getCodigoComentario() {
        return codigoComentario;
    }

    public void setCodigoComentario(Integer codigoComentario) {
        this.codigoComentario = codigoComentario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Short getQualificacao() {
        return qualificacao;
    }

    public void setQualificacao(Short qualificacao) {
        this.qualificacao = qualificacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

  
    public Usuario getUsuario() {
        return usuario;
    }

   
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

  
    public Item getItem() {
        return item;
    }

       public void setItem(Item item) {
        this.item = item;
    }
    
    
}
