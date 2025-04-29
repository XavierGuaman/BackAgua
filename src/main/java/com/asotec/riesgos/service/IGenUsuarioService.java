/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.entity.GenUsuario;

/**
 *
 * @author User
 */
public interface IGenUsuarioService extends IGenericService<GenUsuario> {
    
    public GenUsuario findById(long codEmpresa, String codUsuario);
    public GenUsuario findByUsername(GenUsuario obj);
    public GenUsuario findOneByAssociation(GenUsuario usuario);
    public GenUsuario findByUsuarioAndPassword(String usuario, String password);
    public GenUsuario findByCodEmpleado(long codEmpresa, long codEmpleado);
}
