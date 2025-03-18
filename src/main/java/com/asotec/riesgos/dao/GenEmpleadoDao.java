/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.GenEmpleado;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rolan
 */
@Repository
public class GenEmpleadoDao extends GenericDao<GenEmpleado> implements IGenEmpleadoDao{

    public GenEmpleadoDao() {
        super();
        setClase(GenEmpleado.class);
    }

    
    @Override
    public List<GenEmpleado> filterByEmpresa(long empresa) {
        
        try {
            Query query = entityManager.createQuery("from " + GenEmpleado.class.getName() + " where id.codEmpresa = :empresa");
            query.setParameter("empresa", empresa);
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public List<GenEmpleado> filterByLectores(long empresa) {
        try {
            Query query = entityManager.createQuery("from " + GenEmpleado.class.getName() + " where id.codEmpresa = :empresa and codTipoUsuario = '2'");
            query.setParameter("empresa", empresa);
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }
    
}
