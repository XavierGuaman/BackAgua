/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.ObtenerAbonados;
import java.util.List;

/**
 *
 * @author rolan
 */
public interface IObtenerAbonadosDao extends IGenericDao<ObtenerAbonados>{
    public List<ObtenerAbonados> filterBySector(long codEmpresa, long codSector);
    
}
