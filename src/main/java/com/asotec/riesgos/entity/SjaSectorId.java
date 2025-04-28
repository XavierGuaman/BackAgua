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
 * @author XAVIER
 */
@Embeddable
public class SjaSectorId implements Serializable {

    private long codEmpresa;
    private long codProvincia;
    private long codCanton;
    private long codSector;

    public SjaSectorId() {
    }

    @Column(name = "cod_empresa", precision = 3, scale = 0)
    public long getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(long codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    @Column(name = "cod_provincia", precision = 2, scale = 0)
    public long getCodProvincia() {
        return codProvincia;
    }

    public void setCodProvincia(long codProvincia) {
        this.codProvincia = codProvincia;
    }

    @Column(name = "cod_canton", precision = 4, scale = 0)
    public long getCodCanton() {
        return codCanton;
    }

    public void setCodCanton(long codCanton) {
        this.codCanton = codCanton;
    }

    @Column(name = "cod_sector", precision = 3, scale = 0)
    public long getCodSector() {
        return codSector;
    }

    public void setCodSector(long codSector) {
        this.codSector = codSector;
    }

}
