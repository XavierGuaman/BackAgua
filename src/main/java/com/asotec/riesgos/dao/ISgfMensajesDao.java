/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.SgfMensajes;

/**
 *
 * @author rolan
 */
public interface ISgfMensajesDao extends IGenericDao<SgfMensajes> {
    public SgfMensajes filterByIdNovedad(long idNovedad);
}
