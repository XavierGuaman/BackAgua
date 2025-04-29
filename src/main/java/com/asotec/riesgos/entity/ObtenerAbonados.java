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
 * @author rolan
 */
@Entity
public class ObtenerAbonados implements Serializable {
    private long secuencial;
    private String nomSector;
    private String nomAbonado;
    private String numId;
    private String numMedidor;

    public ObtenerAbonados() {
    }

    @Id
    @Column(name = "secuencial")
    public long getSecuencial() {
        return secuencial;
    }

    public void setSecuencial(long secuencial) {
        this.secuencial = secuencial;
    }

    @Column(name = "nom_sector")
    public String getNomSector() {
        return nomSector;
    }

    public void setNomSector(String nomSector) {
        this.nomSector = nomSector;
    }

    @Column(name = "nom_abonado")
    public String getNomAbonado() {
        return nomAbonado;
    }

    public void setNomAbonado(String nomAbonado) {
        this.nomAbonado = nomAbonado;
    }

    @Column(name = "num_id")
    public String getNumId() {
        return numId;
    }

    public void setNumId(String numId) {
        this.numId = numId;
    }

    @Column(name = "num_medidor")
    public String getNumMedidor() {
        return numMedidor;
    }

    public void setNumMedidor(String numMedidor) {
        this.numMedidor = numMedidor;
    }
    
    
    
}
