/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author josesanchez
 */
@Entity
@Table(name = "gen_usuario",
        schema = "public")
public class GenUsuario implements Serializable {
    
     private GenUsuarioId id;
    private String nomUsuario;
    private String codPassword;
    private Character stsUsuario;
    private long codEmpleado;

    

    public GenUsuario() {
    }

    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name = "cod_empresa", column = @Column(name = "cod_empresa")),
        @AttributeOverride(name = "cod_usuario", column = @Column(name = "cod_usuario")),
    })

    @Id
    public GenUsuarioId getId() {
        return id;
    }

    public void setId(GenUsuarioId id) {
        this.id = id;
    }


    @Basic(optional = false)
    @Column(name = "nom_usuario")
    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    @Column(name = "cod_password")
    public String getCodPassword() {
        return codPassword;
    }

    public void setCodPassword(String codPassword) {
        this.codPassword = codPassword;
    }

    @Basic(optional = false)
    @Column(name = "sts_usuario")
    public Character getStsUsuario() {
        return stsUsuario;
    }

    public void setStsUsuario(Character stsUsuario) {
        this.stsUsuario = stsUsuario;
    }
    
    @Column(name = "cod_empleado")
    public long getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(long codEmpleado) {
        this.codEmpleado = codEmpleado;
    }
}
