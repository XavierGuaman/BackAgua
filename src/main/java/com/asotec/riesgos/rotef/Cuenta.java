/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.rotef;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author ASOTEC
 */
@XmlRootElement(name = "cuenta")
@XmlType(propOrder = {
    "tipoIDCliente", "idCliente","razonSocial","paisNacionalidad",
    "dirProv","dirCanton","tipoProducto","numProducto","saldoInic","valCredito",
    "numOperCred","valDebito","numOperDeb","saldoFinal","codMoneda"})
public class Cuenta {

    private String tipoIDCliente;
    private String idCliente;
    private String razonSocial;
    private String paisNacionalidad;
    private String dirProv;
    private String dirCanton;
    private String tipoProducto;
    private String numProducto;
    private BigDecimal saldoInic;
    private BigDecimal valCredito;
    private long numOperCred;
    private BigDecimal valDebito;
    private long numOperDeb;
    private BigDecimal saldoFinal;
    private String codMoneda;

    @XmlElement(name = "TipoIDCliente")
    public String getTipoIDCliente() {
        return tipoIDCliente;
    }

    public void setTipoIDCliente(String tipoIDCliente) {
        this.tipoIDCliente = tipoIDCliente;
    }

    @XmlElement(name = "IDCliente")
    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    
    @XmlElement(name = "RazonSocial")
    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    @XmlElement(name = "PaisNacionalidad")
    public String getPaisNacionalidad() {
        return paisNacionalidad;
    }

    public void setPaisNacionalidad(String paisNacionalidad) {
        this.paisNacionalidad = paisNacionalidad;
    }

    @XmlElement(name = "DirProv")
    public String getDirProv() {
        return dirProv;
    }

    public void setDirProv(String dirProv) {
        this.dirProv = dirProv;
    }

    @XmlElement(name = "DirCanton")
    public String getDirCanton() {
        return dirCanton;
    }

    public void setDirCanton(String dirCanton) {
        this.dirCanton = dirCanton;
    }

    @XmlElement(name = "TipoProducto")
    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    @XmlElement(name = "NumProducto")
    public String getNumProducto() {
        return numProducto;
    }

    public void setNumProducto(String numProducto) {
        this.numProducto = numProducto;
    }

    @XmlElement(name = "SaldoInic")
    public BigDecimal getSaldoInic() {
        return saldoInic;
    }

    public void setSaldoInic(BigDecimal saldoInic) {
        this.saldoInic = saldoInic;
    }

    @XmlElement(name = "ValCredito")
    public BigDecimal getValCredito() {
        return valCredito;
    }

    public void setValCredito(BigDecimal valCredito) {
        this.valCredito = valCredito;
    }

    @XmlElement(name = "NumOperCred")
    public long getNumOperCred() {
        return numOperCred;
    }

    public void setNumOperCred(long numOperCred) {
        this.numOperCred = numOperCred;
    }

    @XmlElement(name = "ValDebito")
    public BigDecimal getValDebito() {
        return valDebito;
    }

    public void setValDebito(BigDecimal valDebito) {
        this.valDebito = valDebito;
    }

    @XmlElement(name = "NumOperDeb")
    public long getNumOperDeb() {
        return numOperDeb;
    }

    public void setNumOperDeb(long numOperDeb) {
        this.numOperDeb = numOperDeb;
    }

    @XmlElement(name = "SaldoFinal")
    public BigDecimal getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(BigDecimal saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    @XmlElement(name = "CodMoneda")
    public String getCodMoneda() {
        return codMoneda;
    }

    public void setCodMoneda(String codMoneda) {
        this.codMoneda = codMoneda;
    }
}
