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
 * @author rolan
 */
@Embeddable
public class GenEmpleadoId implements Serializable {
    private long codEmpresa;
    private long codEmpleado;

    public GenEmpleadoId() {
    }

    @Column(name = "cod_empresa", precision = 3, scale = 0)
    public long getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(long codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    @Column(name = "cod_empleado", precision = 10, scale = 0)
    public long getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(long codEmpleado) {
        this.codEmpleado = codEmpleado;
    }
    
}
