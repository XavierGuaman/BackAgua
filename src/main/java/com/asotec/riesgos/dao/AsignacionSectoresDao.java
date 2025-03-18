/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.AsignacionSectores;

import java.util.List;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rolan
 */
@Repository
public class AsignacionSectoresDao extends GenericDao<AsignacionSectores> implements IAsignacionSectoresDao {

    
    public AsignacionSectoresDao() {
        super();
        setClase(AsignacionSectores.class);
    }

    
    
    @Override
    public List<AsignacionSectores> filterByEmpresa(long codEmpresa) {
        try {
             StoredProcedureQuery query = entityManager.createStoredProcedureQuery("obtener_asignacion_sectores", AsignacionSectores.class);
            query.registerStoredProcedureParameter(1, long.class, ParameterMode.IN);
            query.setParameter(1, codEmpresa);
            query.execute();
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("ERROR obtener_asignacion_sectores: "+e);
            return null;
        }
    }
    
}
