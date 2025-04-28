/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.SrlTipoUsuario;
import java.util.List;

/**
 *
 * @author ASOTEC
 */
public interface ISrlTipoUsuarioDao extends IGenericDao<SrlTipoUsuario>{
    public List<SrlTipoUsuario> filterByEmpresa(long codEmpresa);
}
