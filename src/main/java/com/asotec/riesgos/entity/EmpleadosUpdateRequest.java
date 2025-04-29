/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity;

/**
 *
 * @author rolan
 */
public class EmpleadosUpdateRequest {
     private GenEmpleado empleado;
    private GenUsuario usuario;

    public GenEmpleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(GenEmpleado empleado) {
        this.empleado = empleado;
    }

    public GenUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(GenUsuario usuario) {
        this.usuario = usuario;
    }
    
}
