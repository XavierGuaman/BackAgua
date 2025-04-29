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
@XmlRootElement(name = "prestamo")
@XmlType(propOrder = {
    "tipoIDCliente", "idCliente","razonSocial","paisNacionalidad","dirProv",
    "dirCanton","diasMorosidad","tipoCredito","estadoOperacion","totalValorVencer",
    "totalValorVencerNoInteres","totvalorVencido","gastosCarteraVencida","interesOrdinario",
    "interesMora","demandaJudicial","carteraCastigada","codMoneda"})
public class Prestamo {

    private String tipoIDCliente;
    private String idCliente;
    private String razonSocial;
    private String paisNacionalidad;
    private String dirProv;
    private String dirCanton;
    private long diasMorosidad;
    private String tipoCredito;
    private String estadoOperacion;
    private BigDecimal totalValorVencer;
    private BigDecimal totalValorVencerNoInteres;
    private BigDecimal totvalorVencido;
    private BigDecimal gastosCarteraVencida;
    private BigDecimal interesOrdinario;
    private BigDecimal interesMora;
    private BigDecimal demandaJudicial;
    private BigDecimal carteraCastigada;
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

    @XmlElement(name = "DiasMorosidad")
    public long getDiasMorosidad() {
        return diasMorosidad;
    }

    public void setDiasMorosidad(long diasMorosidad) {
        this.diasMorosidad = diasMorosidad;
    }

    @XmlElement(name = "TipoCredito")
    public String getTipoCredito() {
        return tipoCredito;
    }

    public void setTipoCredito(String tipoCredito) {
        this.tipoCredito = tipoCredito;
    }

    @XmlElement(name = "EstadoOperacion")
    public String getEstadoOperacion() {
        return estadoOperacion;
    }

    public void setEstadoOperacion(String estadoOperacion) {
        this.estadoOperacion = estadoOperacion;
    }

    @XmlElement(name = "TotalValorVencer")
    public BigDecimal getTotalValorVencer() {
        return totalValorVencer;
    }

    public void setTotalValorVencer(BigDecimal totalValorVencer) {
        this.totalValorVencer = totalValorVencer;
    }

    @XmlElement(name = "TotalValorVencerNoInteres")
    public BigDecimal getTotalValorVencerNoInteres() {
        return totalValorVencerNoInteres;
    }

    public void setTotalValorVencerNoInteres(BigDecimal totalValorVencerNoInteres) {
        this.totalValorVencerNoInteres = totalValorVencerNoInteres;
    }

    @XmlElement(name = "TotvalorVencido")
    public BigDecimal getTotvalorVencido() {
        return totvalorVencido;
    }

    public void setTotvalorVencido(BigDecimal totvalorVencido) {
        this.totvalorVencido = totvalorVencido;
    }

    @XmlElement(name = "GastosCarteraVencida")
    public BigDecimal getGastosCarteraVencida() {
        return gastosCarteraVencida;
    }

    public void setGastosCarteraVencida(BigDecimal gastosCarteraVencida) {
        this.gastosCarteraVencida = gastosCarteraVencida;
    }

    @XmlElement(name = "InteresOrdinario")
    public BigDecimal getInteresOrdinario() {
        return interesOrdinario;
    }

    public void setInteresOrdinario(BigDecimal interesOrdinario) {
        this.interesOrdinario = interesOrdinario;
    }

    @XmlElement(name = "InteresMora")
    public BigDecimal getInteresMora() {
        return interesMora;
    }

    public void setInteresMora(BigDecimal interesMora) {
        this.interesMora = interesMora;
    }

    @XmlElement(name = "DemandaJudicial")
    public BigDecimal getDemandaJudicial() {
        return demandaJudicial;
    }

    public void setDemandaJudicial(BigDecimal demandaJudicial) {
        this.demandaJudicial = demandaJudicial;
    }

    @XmlElement(name = "CarteraCastigada")
    public BigDecimal getCarteraCastigada() {
        return carteraCastigada;
    }

    public void setCarteraCastigada(BigDecimal carteraCastigada) {
        this.carteraCastigada = carteraCastigada;
    }

    @XmlElement(name = "CodMoneda")
    public String getCodMoneda() {
        return codMoneda;
    }

    public void setCodMoneda(String codMoneda) {
        this.codMoneda = codMoneda;
    }
}
