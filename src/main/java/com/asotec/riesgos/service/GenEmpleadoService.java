/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.IGenEmpleadoDao;
import com.asotec.riesgos.entity.GenEmpleado;
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
public class GenEmpleadoService extends GenericService<GenEmpleado> implements IGenEmpleadoService{

    
    @Autowired
    IGenEmpleadoDao dao;
    public GenEmpleadoService() {
        super();
    }

    
    
    @Override
    public List<GenEmpleado> filterByEmpresa(long empresa) {
        return dao.filterByEmpresa(empresa);
    }

    @Override
    public List<GenEmpleado> filterByLectores(long empresa) {
        return dao.filterByLectores(empresa);
    }
    
}
