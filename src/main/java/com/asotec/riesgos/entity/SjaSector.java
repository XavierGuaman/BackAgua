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
 * @author XAVIER
 */
@Entity
@Table(name = "sja_sector",
        schema = "public")
public class SjaSector implements Serializable {

    private SjaSectorId id;
    private String nomSector;
    private String stsSector;

    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name = "cod_empresa", column = @Column(name = "cod_empresa", nullable = false)),
        @AttributeOverride(name = "cod_provincia", column = @Column(name = "cod_provincia", nullable = false)),
        @AttributeOverride(name = "cod_canton", column = @Column(name = "cod_canton", nullable = false)),
        @AttributeOverride(name = "cod_sector", column = @Column(name = "cod_sector", nullable = false)),})
    
    @Id
    public SjaSectorId getId() {
        return id;
    }

    public void setId(SjaSectorId id) {
        this.id = id;
    }

    @Column(name = "nom_sector")
    public String getNomSector() {
        return nomSector;
    }

    public void setNomSector(String nomSector) {
        this.nomSector = nomSector;
    }

    @Column(name = "sts_sector")
    public String getStsSector() {
        return stsSector;
    }

    public void setStsSector(String stsSector) {
        this.stsSector = stsSector;
    }

}
