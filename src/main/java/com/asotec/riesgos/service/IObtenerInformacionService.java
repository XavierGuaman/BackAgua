/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.entity.ObtenerInformacion;

/**
 *
 * @author rolan
 */
public interface IObtenerInformacionService extends IGenericService<ObtenerInformacion> {
    public ObtenerInformacion getInfoSocio(String codMedidor, long codEmpresa);
    
}
