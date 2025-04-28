/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.ISjaControlDao;
import com.asotec.riesgos.entity.SjaControl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author USER
 */
@Service
@Transactional
public class SjaControlService  extends GenericService<SjaControl> implements ISjaControlService{

    @Autowired
    private ISjaControlDao dao;
    
    public SjaControlService() {
        super();
    }

    @Override
    public SjaControl filterByEmpresa(long codEmpresa) {
        return dao.filterByEmpresa(codEmpresa);
    }
    
}