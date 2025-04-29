/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ASOTEC
 */
@Embeddable
public class SjaLecturaId implements Serializable{
    private long codEmpresa;
    private String codMedidor;
    private Date fecLectura;

    public SjaLecturaId() {
    }

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

    @Column(name = "fec_lectura")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getFecLectura() {
        return fecLectura;
    }

    public void setFecLectura(Date fecLectura) {
        this.fecLectura = fecLectura;
    }
    
}
