/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author rolan
 */
@Entity
public class MedidoresConDeuda implements Serializable{
    
    private long codEmpresa;
    private String codMedidor;
    private String codAbonado;
    private String codTipoId;
    private String numId;
    private String nomAbonado;
    private String txtTelefono;
    private String txtCorreo;
    private double valSaldo;
    private long numMesPendientes;
    private Date fecLecUltima;
    private String nomSector;
    private String txtObservacion;

   

    @Column(name = "cod_empresa")
    public long getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(long codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    @Column(name = "cod_medidor")
    public String getCodMedidor() {
        return codMedidor;
    }

    public void setCodMedidor(String codMedidor) {
        this.codMedidor = codMedidor;
    }

    @Id
    @Column(name = "cod_abonado")
    public String getCodAbonado() {
        return codAbonado;
    }

    public void setCodAbonado(String codAbonado) {
        this.codAbonado = codAbonado;
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

    @Column(name = "txt_telefono")
    public String getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(String txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    @Column(name = "txt_correo")
    public String getTxtCorreo() {
        return txtCorreo;
    }

    public void setTxtCorreo(String txtCorreo) {
        this.txtCorreo = txtCorreo;
    }

    @Column(name = "val_saldo")
    public double getValSaldo() {
        return valSaldo;
    }

    public void setValSaldo(double valSaldo) {
        this.valSaldo = valSaldo;
    }

    @Column(name = "num_mes_pendientes")
    public long getNumMesPendientes() {
        return numMesPendientes;
    }

    public void setNumMesPendientes(long numMesPendientes) {
        this.numMesPendientes = numMesPendientes;
    }

    @Column(name = "fec_lec_ultima")
    public Date getFecLecUltima() {
        return fecLecUltima;
    }

    public void setFecLecUltima(Date fecLecUltima) {
        this.fecLecUltima = fecLecUltima;
    }

    @Column(name = "nom_sector")
    public String getNomSector() {
        return nomSector;
    }

    public void setNomSector(String nomSector) {
        this.nomSector = nomSector;
    }

    @Column(name = "txt_observacion")
    public String getTxtObservacion() {
        return txtObservacion;
    }

    public void setTxtObservacion(String txtObservacion) {
        this.txtObservacion = txtObservacion;
    }
    
}
