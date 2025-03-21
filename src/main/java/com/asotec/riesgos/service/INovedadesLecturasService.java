/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.entity.NovedadesLecturas;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rolan
 */
public interface INovedadesLecturasService extends IGenericService<NovedadesLecturas> {
    List<NovedadesLecturas> obtenerNovedadesLecturas(List<String> filtros, long umbral, Date fecInicio, Date fecFinal, long sector , long codEmpresa);
}
