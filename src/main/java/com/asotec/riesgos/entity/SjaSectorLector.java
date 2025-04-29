/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "sja_sector_lector",
        schema = "public")
public class SjaSectorLector implements Serializable{
    
    private SjaSectorLectorId id;
    private long codEmpleado;
    private long codProvincia;
    private long codCanton;
    private long codSector;
    private Character stsAsignacion;
   
    
    
    public SjaSectorLector(){
    }

    @EmbeddedId    
    @AttributeOverrides({
        @AttributeOverride(name = "cod_empresa", column = @Column(name = "cod_empresa")),
        @AttributeOverride(name = "cod_asignacion", column = @Column(name = "cod_asignacion")),
        
    })

    @Id
    public SjaSectorLectorId getId() {
        return this.id;
    }

    public void setId(SjaSectorLectorId id) {
        this.id = id;
    }
    
    
    
    @Column(name = "sts_asignacion")
    public Character getStsAsignacion() {
        return this.stsAsignacion;
    }

    public void setStsAsignacion(Character stsAsignacion) {
        this.stsAsignacion = stsAsignacion;
    }
    
    @Column(name = "cod_empleado", precision = 12, scale = 0)
    public long getCodEmpleado() {
        return this.codEmpleado;
    }

    public void setCodEmpleado(long codEmpleado) {
        this.codEmpleado = codEmpleado;
    }
    
    @Column(name = "cod_provincia", precision = 2, scale = 0)
    public long getCodProvincia() {
        return this.codProvincia;
    }

    public void setCodProvincia(long codProvincia) {
        this.codProvincia = codProvincia;
    }
    
    @Column(name = "cod_canton", precision = 4, scale = 0)
    public long getCodCanton() {
        return this.codCanton;
    }

    public void setCodCanton(long codCanton) {
        this.codCanton = codCanton;
    }
    
    @Column(name = "cod_sector", precision = 3, scale = 0)
    public long getCodSector() {
        return this.codSector;
    }

    public void setCodSector(long codSector) {
        this.codSector= codSector;
    }

    @Override
    public String toString() {
        return "SjaSectorLector{" + "id=" + id + ", codEmpleado=" + codEmpleado + ", codProvincia=" + codProvincia + ", codCanton=" + codCanton + ", codSector=" + codSector + ", stsAsignacion=" + stsAsignacion + '}';
    }
    
    
    
    
    
    
}
