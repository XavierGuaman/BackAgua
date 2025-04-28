/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ASOTEC
 */
@Embeddable
public class SjaMedidorId implements Serializable{
    private long codEmpresa;
    private String codMedidor;

    public SjaMedidorId() {
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
}
