/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.ObtenerMedidores;
import java.util.List;

/**
 *
 * @author rolan
 */
public interface IObtenerMedidoresDao extends IGenericDao<ObtenerMedidores>{
    public List<ObtenerMedidores> filterBySector(long codEmpresa, long codSector);
    
}
