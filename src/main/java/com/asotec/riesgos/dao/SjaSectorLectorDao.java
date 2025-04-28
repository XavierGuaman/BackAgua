/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.SjaSectorLector;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */
@Repository
public class SjaSectorLectorDao extends GenericDao<SjaSectorLector> implements ISjaSectorLectorDao{

    public SjaSectorLectorDao(){
    }
    
    @Override
    public List<SjaSectorLector> filterByEmpresa(long codEmpresa) {
        try {
            Query query = entityManager.createQuery("from " + SjaSectorLector.class.getName() + " where id.codEmpresa = :empresa");
            query.setParameter("empresa", codEmpresa);
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }
    
}
