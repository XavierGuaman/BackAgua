/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.UsuarioEmpleado;
import java.util.List;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASOTEC
 */
@Repository
public class UsuarioEmpleadoDao extends GenericDao<UsuarioEmpleado> implements IUsuarioEmpleadoDao{

    public UsuarioEmpleadoDao() {
        super();
        setClase(UsuarioEmpleado.class);
    }

    
    
    @Override
    public List<UsuarioEmpleado> filterByEmpresa(long codEmpresa) {
        System.out.println("Ingresaa");
        try {
             StoredProcedureQuery query = entityManager.createStoredProcedureQuery("get_empleados", UsuarioEmpleado.class);
            System.out.println("Query: "+query.toString());
             query.registerStoredProcedureParameter(1, long.class, ParameterMode.IN);
            query.setParameter(1, codEmpresa);
            query.execute();
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("ERROR get_empleados: "+e);
            return null;
        }
    }
    
}
