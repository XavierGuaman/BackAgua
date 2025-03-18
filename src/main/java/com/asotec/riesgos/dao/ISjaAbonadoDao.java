/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.SjaAbonado;
import com.asotec.riesgos.entity.SjaMedidor;
import java.util.List;

/**
 *
 * @author rolan
 */
public interface ISjaAbonadoDao extends IGenericDao<SjaAbonado>{
    public List<SjaAbonado> filterByEmpesa(long codEmpresa);
    public SjaAbonado filterByEmpresaAndAbonado(long codEmpresa, String codAbonado);
    
    
    public void createBatch(List<SjaAbonado> abonados);
    public void updateBatch(List<SjaAbonado> abonados);
    public List<SjaAbonado> filterByEmpleadoMovil(long codEmpresa, long codEmpleado);
}
