/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.IMedidoresPendientesDao;
import com.asotec.riesgos.entity.MedidoresPendientes;
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
public class MedidoresPendientesService extends GenericService<MedidoresPendientes> implements IMedidoresPendientesService{

    @Autowired
    private IMedidoresPendientesDao dao;
    public MedidoresPendientesService() {
        super();
    }

    @Override
    public List<MedidoresPendientes> filterByPeriodo(long codEmpresa, long codSector, String periodo) {
        return dao.filterByPeriodo(codEmpresa, codSector, periodo);
    }
    
}
