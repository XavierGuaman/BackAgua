/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.INovedadesAbonadosDao;
import com.asotec.riesgos.entity.NovedadesAbonados;
import java.util.Date;
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
public class NovedadesAbonadoService extends GenericService<NovedadesAbonados> implements INovedadesAbonadoService{

    
    @Autowired
    private INovedadesAbonadosDao dao;

    public NovedadesAbonadoService() {
        
        super();
    }
    
    
    @Override
    public List<NovedadesAbonados> obtenerNovedadesAboandos(long codEmpresa, Date fecInicial, Date fecFinal) {
        return dao.obtenerNovedadesAboandos(codEmpresa, fecInicial, fecFinal);
    }
    
}
