/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.INovedadesLecturasDao;
import com.asotec.riesgos.entity.NovedadesLecturas;
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
public class NovedadesLecturasService extends GenericService<NovedadesLecturas> implements INovedadesLecturasService {
    @Autowired
    private INovedadesLecturasDao dao;
    
    public NovedadesLecturasService() {
        super();
    }
    
    @Override
    public List<NovedadesLecturas> obtenerNovedadesLecturas(List<String> filtros, long umbral, Date fecInicio, Date fecFinal, long sector, long codEmpresa) {
        return dao.obtenerNovedadesLecturas(filtros, umbral, fecInicio, fecFinal, sector, codEmpresa);
    }
    
}
