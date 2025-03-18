/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.ObtenerAbonados;
import com.asotec.riesgos.entity.ObtenerLecturas;
import java.util.List;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rolan
 */
@Repository
public class ObtenerLecturasDao extends GenericDao<ObtenerLecturas> implements IObtenerLecturasDao{

    public ObtenerLecturasDao() {
        super();
        setClase(ObtenerLecturas.class);
    }

    @Override
    public List<ObtenerLecturas> filterByPeriodoAndSector(long codEmpresa, long codSector, long codPeriodoMes, long codPeriodoAnio) {
        try {
            // Crea la consulta StoredProcedure
             StoredProcedureQuery query = entityManager.createStoredProcedureQuery("obtener_lecturas", ObtenerLecturas.class);
            query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN.IN);  // codEmpresa
            query.registerStoredProcedureParameter(2, Long.class, ParameterMode.IN);  // fechaInicio
            query.registerStoredProcedureParameter(3, Long.class, ParameterMode.IN);  // fechaInicio
            query.registerStoredProcedureParameter(4, Long.class, ParameterMode.IN);  // fechaInicio
            query.setParameter(1, codEmpresa);
            query.setParameter(2, codSector);  
            query.setParameter(3, codPeriodoMes);  
            query.setParameter(4, codPeriodoAnio);  
            query.execute();
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("ERROR obtener_lecturas: " + e);
            return null;
        } 
    }
    
}
