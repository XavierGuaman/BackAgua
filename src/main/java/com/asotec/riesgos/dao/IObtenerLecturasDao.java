/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.ObtenerLecturas;
import java.util.List;

/**
 *
 * @author rolan
 */
public interface IObtenerLecturasDao extends IGenericDao<ObtenerLecturas>{
    public List<ObtenerLecturas> filterByPeriodoAndSector(long codEmpresa, long codSector, long codPeriodoMes, long codPeriodoAnio);
    
    
}
