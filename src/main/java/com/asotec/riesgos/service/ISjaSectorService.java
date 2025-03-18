/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.entity.SjaSector;
import java.util.List;

/**
 *
 * @author XAVIER
 */
public interface ISjaSectorService extends IGenericService<SjaSector> {
    public List<SjaSector> filterAll(long codEmpresa);
    public List<SjaSector> filterByEmpleadoMovil(long codEmpresa, long codEmpleado);
}
