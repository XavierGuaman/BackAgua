/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity.nero;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author ASOTEC
 */
public class LecturasOutput implements Serializable{
    private Date fecLectura;
    private long codSector;
    private String nomSector;
    private String codMedidot;
    private String codAbonado;
    private String nomAbonado;
    private long valLecturaFria;
    private long valLecturaCaliente;
    private long codPeriodoAnio;
    private long codPeriodoMes;

    public LecturasOutput() {
    }

    public Date getFecLectura() {
        return fecLectura;
    }

    public void setFecLectura(Date fecLectura) {
        this.fecLectura = fecLectura;
    }

    public long getCodSector() {
        return codSector;
    }

    public void setCodSector(long codSector) {
        this.codSector = codSector;
    }

    public String getNomSector() {
        return nomSector;
    }

    public void setNomSector(String nomSector) {
        this.nomSector = nomSector;
    }

    public String getCodMedidot() {
        return codMedidot;
    }

    public void setCodMedidot(String codMedidot) {
        this.codMedidot = codMedidot;
    }

    public String getCodAbonado() {
        return codAbonado;
    }

    public void setCodAbonado(String codAbonado) {
        this.codAbonado = codAbonado;
    }

    public String getNomAbonado() {
        return nomAbonado;
    }

    public void setNomAbonado(String nomAbonado) {
        this.nomAbonado = nomAbonado;
    }

    public long getValLecturaFria() {
        return valLecturaFria;
    }

    public void setValLecturaFria(long valLecturaFria) {
        this.valLecturaFria = valLecturaFria;
    }

    public long getValLecturaCaliente() {
        return valLecturaCaliente;
    }

    public void setValLecturaCaliente(long valLecturaCaliente) {
        this.valLecturaCaliente = valLecturaCaliente;
    }

    public long getCodPeriodoAnio() {
        return codPeriodoAnio;
    }

    public void setCodPeriodoAnio(long codPeriodoAnio) {
        this.codPeriodoAnio = codPeriodoAnio;
    }

    public long getCodPeriodoMes() {
        return codPeriodoMes;
    }

    public void setCodPeriodoMes(long codPeriodoMes) {
        this.codPeriodoMes = codPeriodoMes;
    }

    @Override
    public String toString() {
        return "LecturasOutput{" + "fecLectura=" + fecLectura + ", codSector=" + codSector + ", nomSector=" + nomSector + ", codMedidot=" + codMedidot + ", codAbonado=" + codAbonado + ", nomAbonado=" + nomAbonado + ", valLecturaFria=" + valLecturaFria + ", valLecturaCaliente=" + valLecturaCaliente + ", codPeriodoAnio=" + codPeriodoAnio + ", codPeriodoMes=" + codPeriodoMes + '}';
    }
    
}
