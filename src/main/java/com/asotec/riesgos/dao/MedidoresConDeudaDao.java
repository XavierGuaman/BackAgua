/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.MedidoresConDeuda;
import java.util.List;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rolan
 */
@Repository
public class MedidoresConDeudaDao extends GenericDao<MedidoresConDeuda> implements IMedidoresConDeudaDao {

    public MedidoresConDeudaDao() {
        super();
        setClase(MedidoresConDeuda.class);
    }

    
    
    
    @Override
    public List<MedidoresConDeuda> getMedidoresConDeuda(long codEmpresa, long codSector, long mesesPendientes) {
        try {
            // Crea la consulta StoredProcedure
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("get_medidores_con_deuda", MedidoresConDeuda.class);

            // Registra los parámetros de entrada
            query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN); // codEmpresa
            query.registerStoredProcedureParameter(2, Long.class, ParameterMode.IN); // codSector
            query.registerStoredProcedureParameter(3, Long.class, ParameterMode.IN); // numMesPendientes

            // Establece los valores de los parámetros
            query.setParameter(1, codEmpresa);
            query.setParameter(2, codSector);
            query.setParameter(3, mesesPendientes);

            // Ejecuta la consulta
            query.execute();

            // Devuelve la lista de resultados
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("ERROR get_medidores_con_deuda: " + e);
            return null;
        }
    }
    
}
