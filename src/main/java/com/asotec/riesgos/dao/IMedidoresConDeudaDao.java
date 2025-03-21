/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.MedidoresConDeuda;
import java.util.List;

/**
 *
 * @author rolan
 */
public interface IMedidoresConDeudaDao extends IGenericDao<MedidoresConDeuda> {
    public List<MedidoresConDeuda> getMedidoresConDeuda(long codEmpresa, long codSector, long mesesPendientes);
}
