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
public class ObtenerInformacion implements Serializable {
     private String codAbonado;
    private String codTipoId;
    private String numId;
    private String nomAbonado;
    private String txtTelefono;
    private String txtCorreo;
    private Double valSaldo;
    private Long numMesPendientes;

    @Id
    @Column(name = "cod_abonado")
    public String getCodAbonado() {
        return codAbonado;
    }

    public void setCodAbonado(String codAbonado) {
        this.codAbonado = codAbonado;
    }

    @Column(name = "cod_tipo_id")
    public String getCodTipoId() {
        return codTipoId;
    }

    public void setCodTipoId(String codTipoId) {
        this.codTipoId = codTipoId;
    }

    @Column(name = "num_id")
    public String getNumId() {
        return numId;
    }

    public void setNumId(String numId) {
        this.numId = numId;
    }

    @Column(name = "nom_abonado")
    public String getNomAbonado() {
        return nomAbonado;
    }

    public void setNomAbonado(String nomAbonado) {
        this.nomAbonado = nomAbonado;
    }

    @Column(name = "txt_telefono")
    public String getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(String txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    @Column(name = "txt_correo")
    public String getTxtCorreo() {
        return txtCorreo;
    }

    public void setTxtCorreo(String txtCorreo) {
        this.txtCorreo = txtCorreo;
    }

    @Column(name = "val_saldo")
    public Double getValSaldo() {
        return valSaldo;
    }

    public void setValSaldo(Double valSaldo) {
        this.valSaldo = valSaldo;
    }

    @Column(name = "num_mes_pendientes")
    public Long getNumMesPendientes() {
        return numMesPendientes;
    }

    public void setNumMesPendientes(Long numMesPendientes) {
        this.numMesPendientes = numMesPendientes;
    }
    
}
