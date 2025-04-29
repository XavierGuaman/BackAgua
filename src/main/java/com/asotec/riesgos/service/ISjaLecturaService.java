/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.entity.SjaLectura;
import java.util.List;

/**
 *
 * @author ASOTEC
 */
public interface ISjaLecturaService extends IGenericService<SjaLectura>{
    public List<SjaLectura> filterByEmpresa(long codEmpresa);
    public SjaLectura filterLecturaByPeriodo(long codEmpresa, String codMedidor, long codPeriodoMes, long codPeriodoAnio);
    public SjaLectura save(SjaLectura lectura);
}
