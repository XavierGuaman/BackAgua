/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.entity.GenEmpleado;
import java.util.List;

/**
 *
 * @author rolan
 */

public interface IGenEmpleadoService extends IGenericService<GenEmpleado>{
    public List<GenEmpleado> filterByEmpresa(long empresa);
    public List<GenEmpleado> filterByLectores(long empresa);
}
