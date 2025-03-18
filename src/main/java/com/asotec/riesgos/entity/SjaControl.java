/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity;

import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author rolan
 */
@Entity
@Table(name = "sja_control",
        schema = "public")
public class SjaControl implements Serializable{
    private SjaControlId id;
    private long codMes;
    private long codAnio;

    

    public SjaControl() {
    }
    
    
    @AttributeOverrides({
        @AttributeOverride(name = "cod_empresa", column = @Column(name = "cod_empresa")),
        
    })

    @EmbeddedId
    @Id
    public SjaControlId getId() {
        return id;
    }

    public void setId(SjaControlId id) {
        this.id = id;
    }
    
    @Column(name = "cod_mes", precision = 2, scale = 0)
    public long getCodMes() {
        return codMes;
    }

    public void setCodMes(long codMes) {
        this.codMes = codMes;
    }

    @Column(name = "cod_anio", precision = 4, scale = 0)
    public long getCodAnio() {
        return codAnio;
    }

    public void setCodAnio(long codAnio) {
        this.codAnio = codAnio;
    }
    
    
}
