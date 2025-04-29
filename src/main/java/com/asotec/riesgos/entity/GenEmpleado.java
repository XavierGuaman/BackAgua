/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity;

import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author rolan
 */
@Entity
@Table(name = "gen_empleado",
        schema = "public")
public class GenEmpleado implements Serializable {
    private GenEmpleadoId id;
    private String nomApeEmpleado;
    private String numId;
    private String numTelefono;
    private String txtDireccion;
    private Character codTipoUsuario;
    private String urlImagen;
    private Character stsEmpleado;

    
    
    
    
    public GenEmpleado() {
    } 
    
    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name = "cod_empresa", column = @Column(name = "cod_empresa")),
        @AttributeOverride(name = "cod_empleado", column = @Column(name = "cod_empleado")),
    })

    @Id
    public GenEmpleadoId getId() {
        return id;
    }

    public void setId(GenEmpleadoId id) {
        this.id = id;
    }

    @Column(name = "nom_ape_empleado")
    public String getNomApeEmpleado() {
        return nomApeEmpleado;
    }

    public void setNomApeEmpleado(String nomApeEmpleado) {
        this.nomApeEmpleado = nomApeEmpleado;
    }

    @Column(name = "num_id")
    public String getNumId() {
        return numId;
    }

    public void setNumId(String numId) {
        this.numId = numId;
    }

    @Column(name = "num_telefono")
    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    @Column(name = "txt_direccion")
    public String getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(String txtDirección) {
        this.txtDireccion = txtDirección;
    }

    @Column(name = "tipo_usuario")
    public Character getCodTipoUsuario() {
        return codTipoUsuario;
    }

    public void setCodTipoUsuario(Character codTipoUsuario) {
        this.codTipoUsuario = codTipoUsuario;
    }


    @Column(name = "url_imagen")
    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    @Column(name = "sts_empleado")
    public Character getStsEmpleado() {
        return stsEmpleado;
    }

    public void setStsEmpleado(Character stsEmpleado) {
        this.stsEmpleado = stsEmpleado;
    }       
}
