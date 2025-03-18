/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.SjaMedidor;
import com.asotec.riesgos.entity.SjaSector;
import java.util.List;

/**
 *
 * @author ASOTEC
 */
public interface ISjaMedidorDao extends IGenericDao<SjaMedidor>{
    public List<SjaMedidor> filterByEmpresa(long codEmpresa);
    public SjaMedidor filterByEmpresaAndCodMedidor(long codEmpresa, String codMedidor);
    
    public void createBatch(List<SjaMedidor> medidores);
    public void updateBatch(List<SjaMedidor> medidores);
    
    public List<SjaMedidor> filterByEmpleadoMovil(long codEmpresa, long codEmpleado);
    public void updateStsLecturaByEmpresa(Long empresaId, String status);
    public void updateStsMedidorByEmpresa(Long empresaId, String status);
   
}
