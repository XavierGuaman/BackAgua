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
public class NovedadesLecturas implements Serializable {
    private long codEmpresa;
    private String codMedidor;
    private Date fecLectura;
    private String nomSector;
    private String codAbonado;
    private String nomAbonado;
    private String codUsuario;
    private long valLecturaAnteriorFria;
    private long valLecturaFria;
    private long diferencia;
    private String tipoAnomalia;

    @Column(name = "cod_empresa")
    public long getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(long codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    
    @Id
    @Column(name = "cod_medidor")
    public String getCodMedidor() {
        return codMedidor;
    }

    public void setCodMedidor(String codMedidor) {
        this.codMedidor = codMedidor;
    }

    @Column(name = "fec_lectura")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getFecLectura() {
        return fecLectura;
    }

    public void setFecLectura(Date fecLectura) {
        this.fecLectura = fecLectura;
    }

    @Column(name = "nom_sector")
    public String getNomSector() {
        return nomSector;
    }

    public void setNomSector(String nomSector) {
        this.nomSector = nomSector;
    }

    @Column(name = "cod_abonado")
    public String getCodAbonado() {
        return codAbonado;
    }

    public void setCodAbonado(String codAbonado) {
        this.codAbonado = codAbonado;
    }

    @Column(name = "nom_abonado")
    public String getNomAbonado() {
        return nomAbonado;
    }

    public void setNomAbonado(String nomAbonado) {
        this.nomAbonado = nomAbonado;
    }

    @Column(name = "cod_usuario")
    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    @Column(name = "val_lect_anterior_fria")
    public long getValLecturaAnteriorFria() {
        return valLecturaAnteriorFria;
    }

    public void setValLecturaAnteriorFria(long valLecturaAnteriorFria) {
        this.valLecturaAnteriorFria = valLecturaAnteriorFria;
    }

    @Column(name = "val_lectura_fria")
    public long getValLecturaFria() {
        return valLecturaFria;
    }

    public void setValLecturaFria(long valLecturaFria) {
        this.valLecturaFria = valLecturaFria;
    }

    @Column(name = "diferencia")
    public long getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(long diferencia) {
        this.diferencia = diferencia;
    }

    @Column(name = "tipo_anomalia")
    public String getTipoAnomalia() {
        return tipoAnomalia;
    }

    public void setTipoAnomalia(String tipoAnomalia) {
        this.tipoAnomalia = tipoAnomalia;
    }
    
    
    
    
    
}
