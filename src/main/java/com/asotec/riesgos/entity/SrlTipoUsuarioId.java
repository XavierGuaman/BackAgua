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
public class SrlTipoUsuarioId implements Serializable{
    
    private long codEmpresa;
    private long codTipoUsuario;

    public SrlTipoUsuarioId() {
    }

    @Column(name = "cod_empresa", precision = 3, scale = 0)
    public long getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(long codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    @Column(name = "cod_tipo_usuario", precision = 3)
    public long getCodTipoUsuario() {
        return codTipoUsuario;
    }

    public void setCodTipoUsuario(long codTipoUsuario) {
        this.codTipoUsuario = codTipoUsuario;
    }
    
}
