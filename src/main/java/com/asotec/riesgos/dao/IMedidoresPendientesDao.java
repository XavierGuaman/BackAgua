/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.MedidoresPendientes;
import java.util.List;

/**
 *
 * @author rolan
 */
public interface IMedidoresPendientesDao extends IGenericDao<MedidoresPendientes>{
    public List<MedidoresPendientes> filterByPeriodo(long codEmpresa, long codSector, String periodo);
}
