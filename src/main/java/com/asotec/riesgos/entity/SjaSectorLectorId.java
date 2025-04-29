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
 * @author USER
 */
@Embeddable
public class SjaSectorLectorId implements Serializable{
    private long codEmpresa;
    private long codAsignacion;
    
    public SjaSectorLectorId(){
    }
    
    @Column(name = "cod_empresa", precision = 3, scale = 0)
    public long getCodEmpresa() {
        return this.codEmpresa;
    }

    public void setCodEmpresa(long codEmpresa) {
        this.codEmpresa = codEmpresa;
    }
    
    @Column(name = "cod_asignacion", precision = 3, scale = 0)
    public long getCodAsignacion() {
        return codAsignacion;
    }

    public void setCodAsignacion(long codAsignacion) {
        this.codAsignacion = codAsignacion;
    }

    @Override
    public String toString() {
        return "SjaSectorLectorId{" + "codEmpresa=" + codEmpresa + ", codAsignacion=" + codAsignacion + '}';
    }
    
    
    
    
    
}
