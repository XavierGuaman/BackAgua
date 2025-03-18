/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.UsuarioEmpleado;
import java.util.List;

/**
 *
 * @author ASOTEC
 */
public interface IUsuarioEmpleadoDao extends IGenericDao<UsuarioEmpleado>{
    public List<UsuarioEmpleado> filterByEmpresa(long codEmpresa);
}
