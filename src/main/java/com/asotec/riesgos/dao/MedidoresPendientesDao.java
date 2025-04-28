/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.MedidoresPendientes;
import com.asotec.riesgos.entity.ObtenerAbonados;
import java.util.List;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rolan
 */
@Repository
public class MedidoresPendientesDao extends GenericDao<MedidoresPendientes> implements IMedidoresPendientesDao{

    public MedidoresPendientesDao() {
        super();
        setClase(MedidoresPendientes.class);
    }

    
    
    
    @Override
    public List<MedidoresPendientes> filterByPeriodo(long codEmpresa, long codSector, String periodo) {
        try {
            // Crea la consulta StoredProcedure
             StoredProcedureQuery query = entityManager.createStoredProcedureQuery("list_medidores_pendientes", MedidoresPendientes.class);
            query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);  // codEmpresa
            query.registerStoredProcedureParameter(2, Long.class, ParameterMode.IN);  
            query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
            query.setParameter(1, codEmpresa);
            query.setParameter(2, codSector);  // Usar java.sql.Date
            query.setParameter(3, periodo);  // Usar java.sql.Date
            query.execute();
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("ERROR list_medidores_pendientes: " + e);
            return null;
        } 
    }
    
}
