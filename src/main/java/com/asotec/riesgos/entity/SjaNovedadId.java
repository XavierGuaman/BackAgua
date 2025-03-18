/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author rolan
 */
@Embeddable
public class SjaNovedadId implements Serializable {
     private Long codEmpresa;
    private String codMedidor;
    private Date fecNovedad;

    public SjaNovedadId() {}

    @Column(name = "cod_empresa", precision = 3, scale = 0)
    public Long getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(Long codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    @Column(name = "cod_medidor", length = 20)
    public String getCodMedidor() {
        return codMedidor;
    }

    public void setCodMedidor(String codMedidor) {
        this.codMedidor = codMedidor;
    }

    @Column(name = "fec_novedad", columnDefinition = "timestamp without time zone")
    public Date getFecNovedad() {
        return fecNovedad;
    }

    public void setFecNovedad(Date fecNovedad) {
        this.fecNovedad = fecNovedad;
    }
    
    
}
