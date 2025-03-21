/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.IMedidoresConDeudaDao;
import com.asotec.riesgos.entity.MedidoresConDeuda;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rolan
 */
@Service
@Transactional
public class MedidoresConDeudaService extends GenericService<MedidoresConDeuda> implements IMedidoresConDeudaService {

    @Autowired
    private IMedidoresConDeudaDao dao;
    public MedidoresConDeudaService() {
        super();
    }

    
    
    
    @Override
    public List<MedidoresConDeuda> getMedidoresConDeuda(long codEmpresa, long codSector, long mesesPendientes) {
        return dao.getMedidoresConDeuda(codEmpresa, codSector, mesesPendientes);
    }
    
}
