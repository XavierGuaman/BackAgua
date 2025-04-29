/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.GenEmpresa;
import com.asotec.riesgos.entity.GenUsuario;
import java.util.logging.Logger;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public class GenUsuarioDao extends GenericDao<GenUsuario> implements IGenUsuarioDao {
    
    public GenUsuarioDao() {
        super();
        setClase(GenUsuario.class);
    }

    @Override
    public GenUsuario findById(long codEmpresa, String codUsuario) {
        try {
            Query query = entityManager.createQuery("from " + GenUsuario.class.getName() + " where id.codEmpresa = :empresa and id.codUsuario = :usuario");
            query.setParameter("empresa", codEmpresa);
            query.setParameter("usuario", codUsuario);
            return (GenUsuario) query.getSingleResult();
        } catch (Exception ex) {
            System.out.println("Error findById: "+ex);
            return null;
        }
    }

    @Override
    public GenUsuario findByUsername(GenUsuario obj) {
         try {
            Query query = entityManager.createQuery("from " + GenUsuario.class.getName() + " where id.codUsuario = :usuario and stsUsuario= 'A'");
            query.setParameter("usuario", obj.getId().getCodUsuario());
            query.setMaxResults(1); //limit 1
            return (GenUsuario) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public GenUsuario findByUsuarioAndPassword(String usuario, String password) {
        try {
            Query query = entityManager.createQuery("from " + GenUsuario.class.getName() + " where id.codUsuario = :usuario and codPassword = :password");
            query.setParameter("usuario", usuario);
            query.setParameter("password", password);
            return (GenUsuario) query.getSingleResult();
        } catch (Exception ex) {
            System.out.println("Error findByUsuarioAndPassword: "+ex);
            return null;
        }
    }

    @Override
    public GenUsuario findByCodEmpleado(long codEmpresa, long codEmpleado) {
        try {
            Query query = entityManager.createQuery("from " + GenUsuario.class.getName() + " where id.codEmpresa = :empresa and codEmpleado = :usuario");
            query.setParameter("empresa", codEmpresa);
            query.setParameter("usuario", codEmpleado);
            return (GenUsuario) query.getSingleResult();
        } catch (Exception ex) {
            System.out.println("Error findByCodEmpleado: "+ex);
            return null;
        }
    }

    @Override
    public GenUsuario findOneByAssociation(GenUsuario usuario) {
        try {
            Query query = entityManager.createQuery("from " + GenUsuario.class.getName() + " where id.codEmpresa = :asociacion and id.codUsuario = :usuario and stsUsuario= 'A'");
            query.setParameter("asociacion", usuario.getId().getCodEmpresa());
            query.setParameter("usuario", usuario.getId().getCodUsuario());
            query.setMaxResults(1); //limit 1
            return (GenUsuario) query.getSingleResult();
        } catch (Exception ex) {
            System.out.println("Error findOneByAssociation: "+ex);
            return null;
        }
    }

}
