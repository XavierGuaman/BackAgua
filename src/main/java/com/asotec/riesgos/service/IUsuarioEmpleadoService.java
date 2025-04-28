/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.entity.UsuarioEmpleado;
import java.util.List;

/**
 *
 * @author ASOTEC
 */
public interface IUsuarioEmpleadoService extends IGenericService<UsuarioEmpleado> {
    public List<UsuarioEmpleado> filterByEmpresa(long codEmpresa);
}
