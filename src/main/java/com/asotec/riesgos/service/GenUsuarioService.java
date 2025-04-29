/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.IGenUsuarioDao;
import com.asotec.riesgos.entity.GenUsuario;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Service
@Transactional
public class GenUsuarioService extends GenericService<GenUsuario> implements IGenUsuarioService {
    
    @Autowired
    private IGenUsuarioDao dao;

    public GenUsuarioService(){
        super();
    }

    @Override
    public GenUsuario findById(long codEmpresa, String codUsuario){
        return dao.findById(codEmpresa, codUsuario);
    }

    @Override
    public GenUsuario findByUsername(GenUsuario obj) {
       return dao.findByUsername(obj);
    }

    @Override
    public GenUsuario findByUsuarioAndPassword(String usuario, String password) {
        return dao.findByUsuarioAndPassword(usuario, password);
    }

    @Override
    public GenUsuario findByCodEmpleado(long codEmpresa, long codEmpleado) {
        return dao.findByCodEmpleado(codEmpresa, codEmpleado);
    }

    @Override
    public GenUsuario findOneByAssociation(GenUsuario usuario) {
        return dao.findOneByAssociation(usuario);
    }
}
