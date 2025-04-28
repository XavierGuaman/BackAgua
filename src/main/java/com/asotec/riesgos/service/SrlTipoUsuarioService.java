/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.ISrlTipoUsuarioDao;
import com.asotec.riesgos.entity.SrlTipoUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASOTEC
 */
@Service
@Transactional
public class SrlTipoUsuarioService extends GenericService<SrlTipoUsuario> implements ISrlTipoUsuarioService{

    @Autowired
    private ISrlTipoUsuarioDao dao;
    public SrlTipoUsuarioService() {
        super();
    }

    
    
    @Override
    public List<SrlTipoUsuario> filterByEmpresa(long codEmpresa) {
        return dao.filterByEmpresa(codEmpresa);
    }
    
}
