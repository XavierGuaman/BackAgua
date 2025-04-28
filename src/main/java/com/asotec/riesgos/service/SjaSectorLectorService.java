/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.ISjaSectorLectorDao;
import com.asotec.riesgos.entity.SjaSectorLector;
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
public class SjaSectorLectorService extends GenericService<SjaSectorLector> implements ISjaSectorLectorService{
        
    @Autowired
    private ISjaSectorLectorDao dao;
    
    public SjaSectorLectorService() {
        super();
    }

    @Override
    public List<SjaSectorLector> filterByEmpresa(long codEmpresa) {
        return dao.filterByEmpresa(codEmpresa);
    }
    
}
