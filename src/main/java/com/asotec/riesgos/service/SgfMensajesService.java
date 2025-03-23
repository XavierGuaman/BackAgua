/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.ISgfMensajesDao;
import com.asotec.riesgos.entity.SgfMensajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rolan
 */
@Service
@Transactional
public class SgfMensajesService extends GenericService<SgfMensajes> implements ISgfMensajesService {

    @Autowired
    private ISgfMensajesDao dao;
    
    public SgfMensajesService() {
        super();
    }

    @Override
    public SgfMensajes filterByIdNovedad(long idNovedad) {
       return dao.filterByIdNovedad(idNovedad);
    }
    
}
