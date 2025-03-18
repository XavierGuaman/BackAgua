/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.ISjaControlSecuenciaDao;
import com.asotec.riesgos.entity.SjaControlSecuencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rolan
 */
@Service
@Transactional
public class SjaControlSecuenciaIService  extends GenericService<SjaControlSecuencia> implements ISjaControlSecuenciaIService{

    @Autowired
    private ISjaControlSecuenciaDao dao;
    
    public SjaControlSecuenciaIService() {
        super();
    }
    
}
