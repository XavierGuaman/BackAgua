/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.IUsuarioEmpleadoDao;
import com.asotec.riesgos.entity.UsuarioEmpleado;
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
public class UsuarioEmpleadoService extends GenericService<UsuarioEmpleado> implements IUsuarioEmpleadoService {

    @Autowired
    private IUsuarioEmpleadoDao dao;
    public UsuarioEmpleadoService() {
        super();
    }
    @Override
    public List<UsuarioEmpleado> filterByEmpresa(long codEmpresa) {
        return dao.filterByEmpresa(codEmpresa);
    }
    
    
    
}
