/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.entity.NovedadesAbonados;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rolan
 */
public interface INovedadesAbonadoService extends IGenericService<NovedadesAbonados>{
    List<NovedadesAbonados> obtenerNovedadesAboandos(long codEmpresa, Date fecInicial, Date fecFinal);
}
