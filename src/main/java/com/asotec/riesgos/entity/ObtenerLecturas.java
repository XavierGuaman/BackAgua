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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rolan
 */
@Entity
public class ObtenerLecturas implements Serializable{
    private long secuencia;
    private Date fecLectura;
    private long codSector;
    private String nomSector;
    private String codMedidor;
    private String codAbonado;
    private String nomAbonado;
    private long valLecturaFria;
    private long valLecturaCaliente;
    private String codUsuario;
    private String txtObservacion;
    private long codUsrMood;
    private String txtLongitud;
    private String txtLatitud;
    private String ipDispositivo;
    private long codEmpresa;
    private String urlFoto;
    private String stsLectura;
    private long codPeriodoAnio;
    private long codPeriodoMes;

    public ObtenerLecturas() {
    }
    
    @Id
    @Column(name = "secuencia")
    public long getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(long secuencia) {
        this.secuencia = secuencia;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fec_lectura")
    public Date getFecLectura() {
        return fecLectura;
    }

    public void setFecLectura(Date fecLectura) {
        this.fecLectura = fecLectura;
    }

    @Column(name="cod_sector")
    public long getCodSector() {
        return codSector;
    }

    public void setCodSector(long codSector) {
        this.codSector = codSector;
    }

    @Column(name="nom_sector")
    public String getNomSector() {
        return nomSector;
    }

    public void setNomSector(String nomSector) {
        this.nomSector = nomSector;
    }

    @Column(name="cod_medidor")
    public String getCodMedidor() {
        return codMedidor;
    }

    public void setCodMedidor(String codMedidor) {
        this.codMedidor = codMedidor;
    }

    @Column(name="cod_abonado")
    public String getCodAbonado() {
        return codAbonado;
    }

    public void setCodAbonado(String codAbonado) {
        this.codAbonado = codAbonado;
    }

    @Column(name="nom_abonado")
    public String getNomAbonado() {
        return nomAbonado;
    }

    public void setNomAbonado(String nomAbonado) {
        this.nomAbonado = nomAbonado;
    }

    @Column(name="val_lectura_fria")
    public long getValLecturaFria() {
        return valLecturaFria;
    }

    public void setValLecturaFria(long valLecturaFria) {
        this.valLecturaFria = valLecturaFria;
    }

    @Column(name="val_lectura_caliente")
    public long getValLecturaCaliente() {
        return valLecturaCaliente;
    }

    public void setValLecturaCaliente(long valLecturaCaliente) {
        this.valLecturaCaliente = valLecturaCaliente;
    }

    @Column(name="cod_usuario")
    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    @Column(name="txt_observacion")
    public String getTxtObservacion() {
        return txtObservacion;
    }

    public void setTxtObservacion(String txtObservacion) {
        this.txtObservacion = txtObservacion;
    }

    @Column(name="cod_usr_mod")
    public long getCodUsrMood() {
        return codUsrMood;
    }

    public void setCodUsrMood(long codUsrMood) {
        this.codUsrMood = codUsrMood;
    }

    @Column(name="txt_longitud_lector")
    public String getTxtLongitud() {
        return txtLongitud;
    }

    public void setTxtLongitud(String txtLongitud) {
        this.txtLongitud = txtLongitud;
    }

    @Column(name="txt_latitud_lector")
    public String getTxtLatitud() {
        return txtLatitud;
    }

    public void setTxtLatitud(String txtLatitud) {
        this.txtLatitud = txtLatitud;
    }

    @Column(name="ip_dispositivo")
    public String getIpDispositivo() {
        return ipDispositivo;
    }

    public void setIpDispositivo(String ipDispositivo) {
        this.ipDispositivo = ipDispositivo;
    }

    @Column(name="cod_empresa")
    public long getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(long codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    @Column(name="url_foto")
    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    @Column(name="sts_lectura")
    public String getStsLectura() {
        return stsLectura;
    }

    public void setStsLectura(String stsLectura) {
        this.stsLectura = stsLectura;
    }

    @Column(name="cod_periodo_anio")
    public long getCodPeriodoAnio() {
        return codPeriodoAnio;
    }

    public void setCodPeriodoAnio(long codPeriodoAnio) {
        this.codPeriodoAnio = codPeriodoAnio;
    }

    @Column(name="cod_periodo_mes")
    public long getCodPeriodoMes() {
        return codPeriodoMes;
    }

    public void setCodPeriodoMes(long codPeriodoMes) {
        this.codPeriodoMes = codPeriodoMes;
    }
    
    
    
    
}
