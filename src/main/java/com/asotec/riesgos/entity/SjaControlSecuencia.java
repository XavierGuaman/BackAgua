/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author rolan
 */
@Entity
@Table(name = "sja_control_secuencia",
        schema = "public")
public class SjaControlSecuencia implements Serializable{
    
    private long codEmpresa;
    private long numSecUsuario;
    private long numSecMedidor;
    private long numSecSector;
    private long numSecEmpleado;
    private long numSecLectura;
    private long numSecAsignacion;

    
    

    
    

    

    public SjaControlSecuencia() {
    }

    @Id
    @Column(name = "cod_empresa", precision = 3, scale = 0)
    public long getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(long codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    @Column(name = "num_sec_usuario", precision = 10, scale = 0)
    public long getNumSecUsuario() {
        return numSecUsuario;
    }

    public void setNumSecUsuario(long numSecUsuario) {
        this.numSecUsuario = numSecUsuario;
    }

    @Column(name = "num_sec_medidor", precision = 10, scale = 0)
    public long getNumSecMedidor() {
        return numSecMedidor;
    }

    
    public void setNumSecMedidor(long numSecMedidor) {
        this.numSecMedidor = numSecMedidor;
    }

    @Column(name = "num_sec_Sector", precision = 10, scale = 0)
    public long getNumSecSector() {
        return numSecSector;
    }

    public void setNumSecSector(long numSecSector) {
        this.numSecSector = numSecSector;
    }
    @Column(name = "num_sec_empleado", precision = 10, scale = 0)
    public long getNumSecEmpleado() {
        return numSecEmpleado;
    }

    public void setNumSecEmpleado(long numSecEmpleado) {
        this.numSecEmpleado = numSecEmpleado;
    }
    
    @Column(name = "num_sec_lectura", precision = 10, scale = 0)
    public long getNumSecLectura() {
        return numSecLectura;
    }

    public void setNumSecLectura(long numSecLectura) {
        this.numSecLectura = numSecLectura;
    }
    
    @Column(name = "num_sec_asignacion", precision = 10, scale = 0)
    public long getNumSecAsignacion() {
        return numSecAsignacion;
    }

    public void setNumSecAsignacion(long numSecAsignacion) {
        this.numSecAsignacion = numSecAsignacion;
    }
    
}
