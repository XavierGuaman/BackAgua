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
@Table(name = "sja_abonado",
        schema = "public")
public class SjaAbonado implements Serializable{
    private SjaAbonadoId id;
    private String codTipoId;
    private String numId;
    private String nomAbonado;
    private String txtCorreo;
    private String txtTelefono;
    private String txtDireccion;
    private String stsAbonado;
    private long codSector;
    private String numMedidor;

    

    public SjaAbonado() {
    }
    @AttributeOverrides({
        @AttributeOverride(name = "cod_empresa", column = @Column(name = "cod_empresa")),
        @AttributeOverride(name = "cod_abonado", column = @Column(name = "cod_abonado")),
    })

    @EmbeddedId
    @Id
    public SjaAbonadoId getId() {
        return id;
    }

    public void setId(SjaAbonadoId id) {
        this.id = id;
    }

    @Column(name = "cod_tipo_id")
    public String getCodTipoId() {
        return codTipoId;
    }

    public void setCodTipoId(String codTipoId) {
        this.codTipoId = codTipoId;
    }

    @Column(name = "num_id")
    public String getNumId() {
        return numId;
    }

    public void setNumId(String numId) {
        this.numId = numId;
    }

    @Column(name = "nom_abonado")
    public String getNomAbonado() {
        return nomAbonado;
    }

    public void setNomAbonado(String nomAbonado) {
        this.nomAbonado = nomAbonado;
    }

    @Column(name = "txt_correo")
    public String getTxtCorreo() {
        return txtCorreo;
    }

    public void setTxtCorreo(String txtCorreo) {
        this.txtCorreo = txtCorreo;
    }

    @Column(name = "txt_telefono")
    public String getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(String txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    @Column(name = "txt_direccion")
    public String getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(String txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    @Column(name = "sts_abonado")
    public String getStsAbonado() {
        return stsAbonado;
    }

    public void setStsAbonado(String stsAbonado) {
        this.stsAbonado = stsAbonado;
    }
    
    @Column(name = "cod_sector")
    public long getCodSector() {
        return codSector;
    }

    public void setCodSector(long codSector) {
        this.codSector = codSector;
    }

    @Column(name = "num_medidor")
    public String getNumMedidor() {
        return numMedidor;
    }

    public void setNumMedidor(String numMedidor) {
        this.numMedidor = numMedidor;
    }
    
    
        

}
