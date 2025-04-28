/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.ISjaLecturaDao;
import com.asotec.riesgos.entity.SjaLectura;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASOTEC
 */
@Service
@Transactional
public class SjaLecturaService extends GenericService<SjaLectura> implements ISjaLecturaService{

    @Autowired
    private ISjaLecturaDao dao;
    
    public SjaLecturaService() {
        super();
    }

    
    @Override
    public List<SjaLectura> filterByEmpresa(long codEmpresa) {
        return dao.filterByEmpresa(codEmpresa);
    }

    @Override
    public SjaLectura filterLecturaByPeriodo(long codEmpresa, String codMedidor, long codPeriodoMes, long codPeriodoAnio) {
        return dao.filterLecturaByPeriodo(codEmpresa, codMedidor, codPeriodoMes, codPeriodoAnio);
    }
    
    @Override
    public SjaLectura save(SjaLectura lectura){
        return dao.save(lectura);
    }
    
}
