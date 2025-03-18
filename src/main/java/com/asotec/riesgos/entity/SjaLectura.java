/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
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
@Table(name = "sja_lectura",
        schema = "public")
public class SjaLectura implements Serializable {
    private SjaLecturaId id;
    private long codUsrMod;
    private long valLecturaFria;
    private long valLecturaCaliente;
    private String txtObservacion;
    private String urlFoto;
    private String codUsuario;
    private String ipDispositivo;
    private String txtLongitudLector;
    private String txtLatitudLector;
    private String stsLectura;
    private long codPeriodoMes;
    private long codPeriodoAnio;
    private long codSector;

    public SjaLectura() {
    }

    @AttributeOverrides({
        @AttributeOverride(name = "cod_empresa", column = @Column(name = "cod_empresa")),
        @AttributeOverride(name = "cod_medidor", column = @Column(name = "cod_medidor")),
        @AttributeOverride(name = "fec_lectura", column = @Column(name = "fec_lectura")),
    })
    @EmbeddedId
    @Id
    public SjaLecturaId getId() {
        return id;
    }

    public void setId(SjaLecturaId id) {
        this.id = id;
    }

    @Column(name = "cod_usr_mod")
    public long getCodUsrMod() {
        return codUsrMod;
    }

    public void setCodUsrMod(long codUsrMod) {
        this.codUsrMod = codUsrMod;
    }

    @Column(name = "val_lectura_fria")
    public long getValLecturaFria() {
        return valLecturaFria;
    }

    public void setValLecturaFria(long valLecturaFria) {
        this.valLecturaFria = valLecturaFria;
    }

    @Column(name = "val_lectura_caliente")
    public long getValLecturaCaliente() {
        return valLecturaCaliente;
    }

    public void setValLecturaCaliente(long valLecturaCaliente) {
        this.valLecturaCaliente = valLecturaCaliente;
    }

    @Column(name = "txt_observacion")
    public String getTxtObservacion() {
        return txtObservacion;
    }

    public void setTxtObservacion(String txtObservacion) {
        this.txtObservacion = txtObservacion;
    }

    @Column(name = "url_foto")
    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    @Column(name = "ip_dispositivo")
    public String getIpDispositivo() {
        return ipDispositivo;
    }

    public void setIpDispositivo(String ipDispositivo) {
        this.ipDispositivo = ipDispositivo;
    }

    @Column(name = "txt_longitud_lector")
    public String getTxtLongitudLector() {
        return txtLongitudLector;
    }

    public void setTxtLongitudLector(String txtLongitudLector) {
        this.txtLongitudLector = txtLongitudLector;
    }

    @Column(name = "txt_latitud_lector")
    public String getTxtLatitudLector() {
        return txtLatitudLector;
    }

    public void setTxtLatitudLector(String txtLatitudLector) {
        this.txtLatitudLector = txtLatitudLector;
    }

    @Column(name = "sts_lectura")
    public String getStsLectura() {
        return stsLectura;
    }

    public void setStsLectura(String stsLectura) {
        this.stsLectura = stsLectura;
    }

    @Column(name = "cod_usuario")
    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }
    
    @Column(name = "cod_periodo_mes")
    public long getCodPeriodoMes() {
        return codPeriodoMes;
    }

    public void setCodPeriodoMes(long codPeriodoMes) {
        this.codPeriodoMes = codPeriodoMes;
    }

    @Column(name = "cod_periodo_anio")
    public long getCodPeriodoAnio() {
        return codPeriodoAnio;
    }

    public void setCodPeriodoAnio(long codPeriodoAnio) {
        this.codPeriodoAnio = codPeriodoAnio;
    }

    @Column(name = "cod_sector")
    public long getCodSector() {
        return codSector;
    }

    public void setCodSector(long codSector) {
        this.codSector = codSector;
    }
    
    
}
