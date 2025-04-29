/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.GenEmpresa;
import org.springframework.stereotype.Repository;

/**
 *
 * @author josesanchez
 */
@Repository
public class GenEmpresaDao extends GenericDao<GenEmpresa> implements IGenEmpresaDao{
    
    /**
     * Constructor general
     */
    public GenEmpresaDao() {
        super();
        setClase(GenEmpresa.class);
    }
   /**
     * Obtiene el registro dado el id
     *
     * @param obj objeto con id
     * @return registro
     */
    @Override
    public GenEmpresa findOne(GenEmpresa obj) {
        try {
            return entityManager.find(GenEmpresa.class, obj.getCodEmpresa());
        } catch (Exception ex) {
            return null;
        }
    }
}
