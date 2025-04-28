/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.NovedadesAbonados;
import com.asotec.riesgos.entity.ObtenerLecturas;
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
public class NovedadesAbonadoDao extends GenericDao<NovedadesAbonados> implements INovedadesAbonadosDao{

    public NovedadesAbonadoDao() {
        super();
        setClase(NovedadesAbonados.class);
    }
    
    
    @Override
    public List<NovedadesAbonados> obtenerNovedadesAboandos(long codEmpresa, Date fecInicial, Date fecFinal) {
        try {
            // Crea la consulta StoredProcedure
             StoredProcedureQuery query = entityManager.createStoredProcedureQuery("fn_obtener_novedades_abonados", NovedadesAbonados.class);
            query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);  // codEmpresa
            query.registerStoredProcedureParameter(2, Date.class, ParameterMode.IN);  // fechaInicio
            query.registerStoredProcedureParameter(3, Date.class, ParameterMode.IN);  // fechaInicio
            query.setParameter(1, codEmpresa);
            query.setParameter(2, fecInicial);  
            query.setParameter(3, fecFinal);  
            query.execute();
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("ERROR fn_obtener_novedades_abonados: " + e);
            return null;
        } 
    }
    
}
