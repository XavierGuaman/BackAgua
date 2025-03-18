/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.ISjaSectorDao;
import com.asotec.riesgos.entity.SjaSector;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author XAVIER
 */
@Service
@Transactional
public class SjaSectorService extends GenericService<SjaSector> implements ISjaSectorService {

    @Autowired
    private ISjaSectorDao dao;

    public SjaSectorService() {
        super();
    }
    @Override
    public List<SjaSector> filterAll(long codEmpresa) {
      return dao.filterAll(codEmpresa);
    }

    @Override
    public List<SjaSector> filterByEmpleadoMovil(long codEmpresa, long codEmpleado) {
        return dao.filterByEmpleadoMovil(codEmpresa, codEmpleado);
    }

}
