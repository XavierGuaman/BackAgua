/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.entity.ObtenerLecturas;
import java.util.List;

/**
 *
 * @author rolan
 */
public interface IObtenerLecturasService extends IGenericService<ObtenerLecturas> {
    public List<ObtenerLecturas> filterByPeriodoAndSector(long codEmpresa, long codSector, long codPeriodoMes, long codPeriodoAnio);
}
