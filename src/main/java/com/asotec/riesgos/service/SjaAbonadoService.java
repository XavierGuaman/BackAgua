/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.ISjaAbonadoDao;
import com.asotec.riesgos.entity.SjaAbonado;
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
public class SjaAbonadoService extends GenericService<SjaAbonado> implements ISjaAbonadoService{

    @Autowired
    private ISjaAbonadoDao dao;
    
    public SjaAbonadoService() {
        super();
    }

    @Override
    public List<SjaAbonado> filterByEmpesa(long codEmpresa) {
        
        return dao.filterByEmpesa(codEmpresa);
    }

    @Override
    public SjaAbonado filterByEmpresaAndAbonado(long codEmpresa, String codAbonado) {
        return dao.filterByEmpresaAndAbonado(codEmpresa, codAbonado);
    }

    @Transactional
    public void createBatch(List<SjaAbonado> abonados) {
        dao.createBatch(abonados);
    }

    @Transactional
    public void updateBatch(List<SjaAbonado> abonados) {
        dao.updateBatch(abonados);
    }

    @Override
    public List<SjaAbonado> filterByEmpleadoMovil(long codEmpresa, long codEmpleado) {
        return dao.filterByEmpleadoMovil(codEmpresa, codEmpleado);
    }
    
}
