/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ASOTEC
 */
@Entity
@Table(name = "srl_tipo_usuario",
        schema = "public")
public class SrlTipoUsuario implements Serializable {
    
    private SrlTipoUsuarioId id;
    private String txtDescripcion;
    private String stsTipoUsuario;

    
    

    public SrlTipoUsuario() {
    }

    @EmbeddedId
    @Id
    public SrlTipoUsuarioId getId() {
        return id;
    }

    public void setId(SrlTipoUsuarioId id) {
        this.id = id;
    }

    @Column(name = "txt_descripcion")
    public String getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(String txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }
    
    @Column(name = "sts_tipo_usuario")
    public String getStsTipoUsuario() {
        return stsTipoUsuario;
    }

    public void setStsTipoUsuario(String stsTipoUsuario) {
        this.stsTipoUsuario = stsTipoUsuario;
    }
    
    
    
    
}
