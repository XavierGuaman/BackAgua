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
@XmlRootElement(name = "inversion")
@XmlType(propOrder = {
    "tipoIDCliente", "idCliente","razonSocial","paisNacionalidad",
    "dirProv","dirCanton","capitalInvers","codMoneda"})
public class Inversion {

    private String tipoIDCliente;
    private String idCliente;
    private String razonSocial;
    private String paisNacionalidad;
    private String dirProv;
    private String dirCanton;
    private BigDecimal capitalInvers;
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

    @XmlElement(name = "CapitalInvers")
    public BigDecimal getCapitalInvers() {
        return capitalInvers;
    }

    public void setCapitalInvers(BigDecimal capitalInvers) {
        this.capitalInvers = capitalInvers;
    }

    @XmlElement(name = "CodMoneda")
    public String getCodMoneda() {
        return codMoneda;
    }

    public void setCodMoneda(String codMoneda) {
        this.codMoneda = codMoneda;
    }
}
