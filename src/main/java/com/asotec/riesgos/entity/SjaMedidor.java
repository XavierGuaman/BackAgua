/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ASOTEC
 */
@Entity
@Table(name = "sja_medidor",
        schema = "public")
public class SjaMedidor implements Serializable{
    private SjaMedidorId id;
    private long codProvincia;
    private long codCanton;
    private long codSector;
    private String txtLongitud;
    private String txtLatitud;
    private BigDecimal valSaldo;
    private String codAbonado;
    private String urlFoto;
    private String stsMedidorActivo;
    private String stsLectura;
    private long numMesPendiente;
    private long valLectAnteriorFria;
    private long valLecAnteriorCaliente;
    private String codCatastro;
    private long valLectActualFria;
    private long valLectActualCaliente;
    private String codTarifa;
    private String txtDireccion;
    private long periodo;

    
    

    public SjaMedidor() {
    }
    
    @AttributeOverrides({
        @AttributeOverride(name = "cod_empresa", column = @Column(name = "cod_empresa")),
        @AttributeOverride(name = "cod_medidor", column = @Column(name = "cod_medidor")),
    })

    @EmbeddedId
    @Id
    public SjaMedidorId getId() {
        return id;
    }

    public void setId(SjaMedidorId id) {
        this.id = id;
    }

    @Column(name = "cod_provincia")
    public long getCodProvincia() {
        return codProvincia;
    }

    public void setCodProvincia(long codProvincia) {
        this.codProvincia = codProvincia;
    }

    @Column(name = "cod_canton")
    public long getCodCanton() {
        return codCanton;
    }

    public void setCodCanton(long codCanton) {
        this.codCanton = codCanton;
    }

    @Column(name = "cod_sector")
    public long getCodSector() {
        return codSector;
    }

    public void setCodSector(long codSector) {
        this.codSector = codSector;
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

    @Column(name = "val_saldo")
    public BigDecimal getValSaldo() {
        return valSaldo;
    }

    public void setValSaldo(BigDecimal valSaldo) {
        this.valSaldo = valSaldo;
    }

    @Column(name = "cod_abonado")
    public String getCodAbonado() {
        return codAbonado;
    }

    public void setCodAbonado(String codAbonado) {
        this.codAbonado = codAbonado;
    }

    @Column(name = "url_foto_estado")
    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    @Column(name = "sts_medidor_activo")
    public String getStsMedidorActivo() {
        return stsMedidorActivo;
    }

    public void setStsMedidorActivo(String stsMedidorActivo) {
        this.stsMedidorActivo = stsMedidorActivo;
    }

    @Column(name = "sts_lectura")
    public String getStsLectura() {
        return stsLectura;
    }

    public void setStsLectura(String stsLectura) {
        this.stsLectura = stsLectura;
    }

    @Column(name = "num_mes_pendientes")
    public long getNumMesPendiente() {
        return numMesPendiente;
    }

    public void setNumMesPendiente(long numMesPendiente) {
        this.numMesPendiente = numMesPendiente;
    }

    @Column(name = "val_lect_anterior_fria")
    public long getValLectAnteriorFria() {
        return valLectAnteriorFria;
    }

    public void setValLectAnteriorFria(long valLectAnteriorFria) {
        this.valLectAnteriorFria = valLectAnteriorFria;
    }

    @Column(name = "val_lect_anterior_caliente")
    public long getValLecAnteriorCaliente() {
        return valLecAnteriorCaliente;
    }

    public void setValLecAnteriorCaliente(long valLecAnteriorCaliente) {
        this.valLecAnteriorCaliente = valLecAnteriorCaliente;
    }

    @Column(name = "cod_catastro")
    public String getCodCatastro() {
        return codCatastro;
    }

    public void setCodCatastro(String codCatastro) {
        this.codCatastro = codCatastro;
    }

    @Column(name = "val_lect_actual_fria")
    public long getValLectActualFria() {
        return valLectActualFria;
    }

    public void setValLectActualFria(long valLectActualFria) {
        this.valLectActualFria = valLectActualFria;
    }

    @Column(name = "val_lect_actual_caliente")
    public long getValLectActualCaliente() {
        return valLectActualCaliente;
    }

    public void setValLectActualCaliente(long valLectActualCaliente) {
        this.valLectActualCaliente = valLectActualCaliente;
    }

    @Column(name = "cod_tarifa")
    public String getCodTarifa() {
        return codTarifa;
    }

    public void setCodTarifa(String codTarifa) {
        this.codTarifa = codTarifa;
    }

    @Column(name = "txt_direccion")
    public String getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(String txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    @Override
    public String toString() {
        return "SjaMedidor{" + "id=" + id + ", codProvincia=" + codProvincia + ", codCanton=" + codCanton + ", codSector=" + codSector + ", txtLongitud=" + txtLongitud + ", txtLatitud=" + txtLatitud + ", valSaldo=" + valSaldo + ", codAbonado=" + codAbonado + ", urlFoto=" + urlFoto + ", stsMedidorActivo=" + stsMedidorActivo + ", stsLectura=" + stsLectura + ", numMesPendiente=" + numMesPendiente + ", valLectAnteriorFria=" + valLectAnteriorFria + ", valLecAnteriorCaliente=" + valLecAnteriorCaliente + ", codCatastro=" + codCatastro + ", valLectActualFria=" + valLectActualFria + ", valLectActualCaliente=" + valLectActualCaliente + ", codTarifa=" + codTarifa + ", txtDireccion=" + txtDireccion + '}';
    }
    
    @Column(name = "periodo")
    public long getPeriodo() {
        return periodo;
    }

    public void setPeriodo(long periodo) {
        this.periodo = periodo;
    }
    
    
}
