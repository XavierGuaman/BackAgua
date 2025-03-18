/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.GenEmpleado;
import com.asotec.riesgos.entity.SrlTipoUsuario;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASOTEC
 */
@Repository
public class SrlTipoUsuarioDao extends GenericDao<SrlTipoUsuario> implements ISrlTipoUsuarioDao{

    public SrlTipoUsuarioDao() {
        super();
        setClase(SrlTipoUsuario.class);
    }

    
    
    @Override
    public List<SrlTipoUsuario> filterByEmpresa(long codEmpresa) {
       try {
            Query query = entityManager.createQuery("from " + SrlTipoUsuario.class.getName() + " where id.codEmpresa = :empresa and stsTipoUsuario = 'A'");
            query.setParameter("empresa", codEmpresa);
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }
    
}
