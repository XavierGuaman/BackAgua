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

/**
 *
 * @author ASOTEC
 */
@Entity
public class UsuarioEmpleado implements Serializable{
    private UsuarioEmpleadoId id;
    private String codUsuario;
    private String nomApeEmpleado;
    private String txtDireccion;
    private String numTelefono;
    private String tipoUsuario;
    private String stsEmpleado;
    private String numId;
    private String codPassword;

    
    
    

    public UsuarioEmpleado() {
    }

    @AttributeOverrides({
        @AttributeOverride(name = "cod_empresa", column = @Column(name = "cod_empresa")),
        @AttributeOverride(name = "cod_empleado", column = @Column(name = "cod_empleado")),})

    @EmbeddedId
    @Id
    public UsuarioEmpleadoId getId() {
        return id;
    }

    public void setId(UsuarioEmpleadoId id) {
        this.id = id;
    }

    @Column(name = "cod_usuario")
    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    @Column(name = "nom_empleado")
    public String getNomApeEmpleado() {
        return nomApeEmpleado;
    }

    public void setNomApeEmpleado(String nomApeEmpleado) {
        this.nomApeEmpleado = nomApeEmpleado;
    }

    @Column(name = "txt_direccion")
    public String getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(String txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    @Column(name = "num_telefono")
    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    @Column(name = "tipo_usuario")
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Column(name = "sts_empleado")
    public String getStsEmpleado() {
        return stsEmpleado;
    }

    public void setStsEmpleado(String stsEmpleado) {
        this.stsEmpleado = stsEmpleado;
    }
    
    @Column(name = "num_id")
    public String getNumId() {
        return numId;
    }

    public void setNumId(String numId) {
        this.numId = numId;
    }

    @Column(name = "cod_password")
    public String getCodPassword() {
        return codPassword;
    }

    public void setCodPassword(String codPassword) {
        this.codPassword = codPassword;
    }
    
    
}
