/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.IObtenerInformacionDao;
import com.asotec.riesgos.entity.ObtenerInformacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rolan
 */
@Service
@Transactional
public class ObtenerInformacionService extends GenericService<ObtenerInformacion> implements IObtenerInformacionService {

    @Autowired
    private IObtenerInformacionDao dao;

    public ObtenerInformacionService() {
        super();
    }

    @Override
    public ObtenerInformacion getInfoSocio(String codMedidor, long codEmpresa) {
        return dao.getInfoSocio(codMedidor, codEmpresa);
    }
    
}
