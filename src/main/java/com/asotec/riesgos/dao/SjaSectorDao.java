/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.ObtenerMedidores;
import com.asotec.riesgos.entity.SjaSector;
import java.util.HashSet;
import java.util.List;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author XAVIER
 */
@Repository
public class SjaSectorDao extends GenericDao<SjaSector> implements ISjaSectorDao {

    public SjaSectorDao() {
        super();
        setClase(SjaSector.class);
        
    }
    

    @Override
    public List<SjaSector> filterAll(long codEmpresa) {
        try {
            Query query = entityManager.createQuery("from " + SjaSector.class.getSimpleName() + " where id.codEmpresa = :codEmpresa and stsSector = 'A' ");
            query.setParameter("codEmpresa", codEmpresa);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<SjaSector> filterByEmpleadoMovil(long codEmpresa, long codEmpleado) {
        
        System.out.println("LLega hasta aca");
        try {
            // Crea la consulta StoredProcedure
             StoredProcedureQuery query = entityManager.createStoredProcedureQuery("obtener_sectores_movil", SjaSector.class);
            query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN.IN);  // codEmpresa
            query.registerStoredProcedureParameter(2, Long.class, ParameterMode.IN);  // fechaInicio
            query.setParameter(1, codEmpresa);
            query.setParameter(2, codEmpleado);  // Usar java.sql.Date
            query.execute();
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("ERROR obtener_sectores_movil: " + e);
            return null;
        } 
    }

}
