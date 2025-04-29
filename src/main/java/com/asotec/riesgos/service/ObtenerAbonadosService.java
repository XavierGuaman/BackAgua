/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.IObtenerAbonadosDao;
import com.asotec.riesgos.entity.ObtenerAbonados;
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
public class ObtenerAbonadosService extends GenericService<ObtenerAbonados> implements IObtenerAbonadosService{

    
    @Autowired
    private IObtenerAbonadosDao dao;
    
    
    public ObtenerAbonadosService() {
        super();
    }

    
    
    
    
    @Override
    public List<ObtenerAbonados> filterBySector(long codEmpresa, long codSector) {
        return dao.filterBySector(codEmpresa, codSector);
    }
    
}
