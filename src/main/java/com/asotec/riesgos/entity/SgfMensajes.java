/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author rolan
 */
@Entity
@Table(name = "sgf_mensajes", schema = "public")
public class SgfMensajes implements Serializable {
    
    private long numMensaje;
    private String codSocio;
    private String codTipoId;
    private String numId;
    private String nomSocio;
    private String telCelular;
    private String dirCorreo;
    private String codCuenta;
    private String txtObservacion;
    private double valSubtotal1;
    private double valTotal;
    private long numDiasMora;
    private String txtOficina;
    private boolean stsEnviado;

    
    

    @Id
    @Column(name = "num_mensaje")
    public long getNumMensaje() {
        return numMensaje;
    }

    public void setNumMensaje(long numMensaje) {
        this.numMensaje = numMensaje;
    }



    @Column(name = "cod_socio")
    public String getCodSocio() {
        return codSocio;
    }

    public void setCodSocio(String codSocio) {
        this.codSocio = codSocio;
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

    @Column(name = "nom_socio")
    public String getNomSocio() {
        return nomSocio;
    }

    public void setNomSocio(String nomSocio) {
        this.nomSocio = nomSocio;
    }



    @Column(name = "tel_celular")
    public String getTelCelular() {
        return telCelular;
    }

    public void setTelCelular(String telCelular) {
        this.telCelular = telCelular;
    }

    @Column(name = "dir_correo")
    public String getDirCorreo() {
        return dirCorreo;
    }

    public void setDirCorreo(String dirCorreo) {
        this.dirCorreo = dirCorreo;
    }

    @Column(name = "cod_cuenta")
    public String getCodCuenta() {
        return codCuenta;
    }

    public void setCodCuenta(String codCuenta) {
        this.codCuenta = codCuenta;
    }

    @Column(name = "txt_observacion")
    public String getTxtObservacion() {
        return txtObservacion;
    }

    public void setTxtObservacion(String txtObservacion) {
        this.txtObservacion = txtObservacion;
    }

    @Column(name = "val_subtotal1")
    public double getValSubtotal1() {
        return valSubtotal1;
    }

    public void setValSubtotal1(double valSubtotal1) {
        this.valSubtotal1 = valSubtotal1;
    }

    @Column(name = "val_total")
    public double getValTotal() {
        return valTotal;
    }

    public void setValTotal(double valTotal) {
        this.valTotal = valTotal;
    }

    @Column(name = "num_dias_mora")
    public long getNumDiasMora() {
        return numDiasMora;
    }

    public void setNumDiasMora(long numDiasMora) {
        this.numDiasMora = numDiasMora;
    }

    @Column(name = "txt_oficina")
    public String getTxtOficina() {
        return txtOficina;
    }

    public void setTxtOficina(String txtOficina) {
        this.txtOficina = txtOficina;
    }
    
    @Column(name = "sts_enviado")
    public boolean isStsEnviado() {
        return stsEnviado;
    }

    public void setStsEnviado(boolean stsEnviado) {
        this.stsEnviado = stsEnviado;
    }
    
    
}
