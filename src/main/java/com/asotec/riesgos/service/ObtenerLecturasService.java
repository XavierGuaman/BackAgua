/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.IObtenerLecturasDao;
import com.asotec.riesgos.entity.ObtenerLecturas;
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
public class ObtenerLecturasService extends GenericService<ObtenerLecturas> implements IObtenerLecturasService{

    
    
    @Autowired
    private IObtenerLecturasDao dao;
    
    public ObtenerLecturasService() {
        super();
    }

    
    
    
    
    @Override
    public List<ObtenerLecturas> filterByPeriodoAndSector(long codEmpresa, long codSector, long codPeriodoMes, long codPeriodoAnio) {
        return dao.filterByPeriodoAndSector(codEmpresa, codSector, codPeriodoMes, codPeriodoAnio);
    }
    
}
