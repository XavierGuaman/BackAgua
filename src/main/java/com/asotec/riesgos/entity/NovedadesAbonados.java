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
public class NovedadesAbonados implements Serializable {
    private long codEmpresa;
    private String codMedidor;
    private Date fecNovedad;
    private String txtNovedad;
    private String codAbonado;
    private String nomAbonado;
    private String nomSector;

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

    @Column(name = "fec_novedad")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getFecNovedad() {
        return fecNovedad;
    }

    public void setFecNovedad(Date fecNovedad) {
        this.fecNovedad = fecNovedad;
    }

    @Column(name = "txt_novedad")
    public String getTxtNovedad() {
        return txtNovedad;
    }

    public void setTxtNovedad(String txtNovedad) {
        this.txtNovedad = txtNovedad;
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

    @Column(name = "nom_sector")
    public String getNomSector() {
        return nomSector;
    }

    public void setNomSector(String nomSector) {
        this.nomSector = nomSector;
    }
    
    
    
    
    
}
