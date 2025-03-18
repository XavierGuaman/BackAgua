/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.SjaControl;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */

@Repository
public class SjaControlDao extends GenericDao<SjaControl> implements ISjaControlDao{
    
    public SjaControlDao() {
    }

    @Override
    public SjaControl filterByEmpresa(long codEmpresa) {
        try {
            Query query = entityManager.createQuery("from " + SjaControl.class.getName() + " where id.codEmpresa = :empresa");
            query.setParameter("empresa", codEmpresa);
            return (SjaControl) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }
}
