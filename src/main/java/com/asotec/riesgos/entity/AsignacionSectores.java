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

/**
 *
 * @author rolan
 */
@Entity
public class AsignacionSectores implements Serializable {
    private AsignacionSectoresId id;
    private String nomEmpleado;
    private String nomSector;
    private String codUsuario;
    private long codAsignacion;

    
    

    
    

    public AsignacionSectores() {
    }
    
    @AttributeOverrides({
        @AttributeOverride(name = "cod_empresa", column = @Column(name = "cod_empresa")),
        @AttributeOverride(name = "cod_empleado", column = @Column(name = "cod_empleado")),
        @AttributeOverride(name = "cod_sector", column = @Column(name = "cod_sector")),
    
    })


    @EmbeddedId
    @Id
    public AsignacionSectoresId getId() {
        return id;
    }

    public void setId(AsignacionSectoresId id) {
        this.id = id;
    }

    @Column(name = "nom_ape_empleado")
    public String getNomEmpleado() {
        return nomEmpleado;
    }

    public void setNomEmpleado(String nomEmpleado) {
        this.nomEmpleado = nomEmpleado;
    }

    @Column(name = "nom_sector")
    public String getNomSector() {
        return nomSector;
    }

    public void setNomSector(String nomSector) {
        this.nomSector = nomSector;
    }
    
    @Column(name = "cod_usuario")
    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }
    
    @Column(name = "cod_asignacion")
    public long getCodAsignacion() {
        return codAsignacion;
    }

    public void setCodAsignacion(long codAsignacion) {
        this.codAsignacion = codAsignacion;
    }
    
    
}
