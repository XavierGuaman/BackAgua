/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.IGenEmpresaDao;
import com.asotec.riesgos.entity.GenEmpresa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dell
 */
@Service
@Transactional
public class GenEmpresaService implements IGenEmpresaService{
   
    /**
     * Resuelve la dependencia
     */
    @Autowired
    private IGenEmpresaDao dao;

    /**
     * Constructor
     */
    public GenEmpresaService() {
        super();
    }
    /**
     * Obtiene el registro del socio por su codigo
     *
     * @param id codigo del socio
     * @return registro
     */
    @Override
    public GenEmpresa findOne(final long id) {
        return dao.findOne(id);
    }
    /**
     * Lista los socios registrados
     *
     * @return listado
     */
    @Override
    public List<GenEmpresa> findAll() {
        return dao.findAll();
    }
 
}
