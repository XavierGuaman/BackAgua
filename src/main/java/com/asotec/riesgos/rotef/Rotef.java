/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.rotef;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author ASOTEC
 */
@XmlRootElement(name = "rotef")
@XmlType(propOrder = {"codigoFinanciera", "idInformante", "anio", "mes", "codigoOperativo", "cuentas", "inversiones", "prestamos"})
public class Rotef {
    private String codigoFinanciera;
    private String idInformante;
    private String anio;
    private String mes;
    private String codigoOperativo;
    private List<Cuenta> cuentas;
    private List<Inversion> inversiones;
    private List<Prestamo> prestamos;

    @XmlElement(name = "CodigoFinanciera")
    public String getCodigoFinanciera() {
        return codigoFinanciera;
    }

    public void setCodigoFinanciera(String codigoFinanciera) {
        this.codigoFinanciera = codigoFinanciera;
    }

    @XmlElement(name = "IdInformante")
    public String getIdInformante() {
        return idInformante;
    }

    public void setIdInformante(String idInformante) {
        this.idInformante = idInformante;
    }

    @XmlElement(name = "Anio")
    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    @XmlElement(name = "Mes")
    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    @XmlElement(name = "codigoOperativo")
    public String getCodigoOperativo() {
        return codigoOperativo;
    }

    public void setCodigoOperativo(String codigoOperativo) {
        this.codigoOperativo = codigoOperativo;
    }

    @XmlElementWrapper(name = "cuentas")
    @XmlElement(name = "cuenta")
    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    @XmlElementWrapper(name = "inversiones")
    @XmlElement(name = "inversion")
    public List<Inversion> getInversiones() {
        return inversiones;
    }

    public void setInversiones(List<Inversion> inversiones) {
        this.inversiones = inversiones;
    }

    @XmlElementWrapper(name = "prestamos")
    @XmlElement(name = "prestamo")
    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }
}
