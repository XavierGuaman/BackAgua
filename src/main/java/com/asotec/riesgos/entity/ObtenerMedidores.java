/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author rolan
 */
@Entity
public class ObtenerMedidores implements Serializable{
    public long secuencial;
    public String codAbonado;
    public String codMedidor;
    public String nomAbonado;
    public long codSector;
    public String nomSector;
    public String txtLongitud;
    public String txtLatitud;

    public ObtenerMedidores() {
    }

    @Id
    @Column(name = "secuencial")
    public long getSecuencial() {
        return secuencial;
    }

    public void setSecuencial(long secuencial) {
        this.secuencial = secuencial;
    }

    @Column(name = "cod_abonado")
    public String getCodAbonado() {
        return codAbonado;
    }

    public void setCodAbonado(String codAbonado) {
        this.codAbonado = codAbonado;
    }

    @Column(name = "cod_medidor")
    public String getCodMedidor() {
        return codMedidor;
    }

    public void setCodMedidor(String codMedidor) {
        this.codMedidor = codMedidor;
    }

    @Column(name = "nom_abonado")
    public String getNomAbonado() {
        return nomAbonado;
    }

    public void setNomAbonado(String nomAbonado) {
        this.nomAbonado = nomAbonado;
    }

    @Column(name = "cod_sector")
    public long getCodSector() {
        return codSector;
    }

    public void setCodSector(long codSector) {
        this.codSector = codSector;
    }

    @Column(name = "nom_sector")
    public String getNomSector() {
        return nomSector;
    }

    public void setNomSector(String nomSector) {
        this.nomSector = nomSector;
    }

    @Column(name = "txt_longitud")
    public String getTxtLongitud() {
        return txtLongitud;
    }

    public void setTxtLongitud(String txtLongitud) {
        this.txtLongitud = txtLongitud;
    }

    @Column(name = "txt_latitud")
    public String getTxtLatitud() {
        return txtLatitud;
    }

    public void setTxtLatitud(String txtLatitud) {
        this.txtLatitud = txtLatitud;
    }
    
}
