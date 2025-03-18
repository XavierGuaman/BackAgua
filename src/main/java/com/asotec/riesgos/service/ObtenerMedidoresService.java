/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.IObtenerMedidoresDao;
import com.asotec.riesgos.entity.ObtenerMedidores;
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
public class ObtenerMedidoresService extends GenericService<ObtenerMedidores> implements IObtenerMedidoresService {

    
    @Autowired
    private IObtenerMedidoresDao dao;
    public ObtenerMedidoresService() {
        super();
    }

    
    
    
    @Override
    public List<ObtenerMedidores> filterBySector(long codEmpresa, long codSector) {
        return dao.filterBySector(codEmpresa, codSector);
    }
    
}
