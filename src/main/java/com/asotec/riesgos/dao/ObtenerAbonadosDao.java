/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.ObtenerAbonados;
import java.util.Date;
import java.util.List;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rolan
 */
@Repository
public class ObtenerAbonadosDao extends GenericDao<ObtenerAbonados> implements IObtenerAbonadosDao{

    public ObtenerAbonadosDao() {
        super();
        setClase(ObtenerAbonados.class);
    }

    
    @Override
    public List<ObtenerAbonados> filterBySector(long codEmpresa, long codSector) {
        
     
       try {
            // Crea la consulta StoredProcedure
             StoredProcedureQuery query = entityManager.createStoredProcedureQuery("obtener_abonados", ObtenerAbonados.class);
            query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN.IN);  // codEmpresa
            query.registerStoredProcedureParameter(2, Long.class, ParameterMode.IN);  // fechaInicio
            query.setParameter(1, codEmpresa);
            query.setParameter(2, codSector);  // Usar java.sql.Date
            query.execute();
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("ERROR obtener_abonados: " + e);
            return null;
        } 
    }
    
}
