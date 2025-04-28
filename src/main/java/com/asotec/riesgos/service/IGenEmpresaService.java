/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.entity.GenEmpresa;
import com.asotec.riesgos.util.NoResultException;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface IGenEmpresaService {
    GenEmpresa findOne(long id);
    
    List<GenEmpresa> findAll();

}
