/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.SjaAbonado;
import com.asotec.riesgos.entity.SjaLectura;
import com.asotec.riesgos.entity.SjaMedidor;
import java.util.List;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rolan
 */
@Repository
public class SjaAbonadoDao extends GenericDao<SjaAbonado> implements ISjaAbonadoDao
{

    public SjaAbonadoDao() {
        super();
        setClase(SjaAbonado.class);
    }

    
    @Override
    public List<SjaAbonado> filterByEmpesa(long codEmpresa) {
        try {
            Query query = entityManager.createQuery("from " + SjaAbonado.class.getName() + " where id.codEmpresa = :empresa and stsAbonado = 'A'");
            query.setParameter("empresa", codEmpresa);
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public SjaAbonado filterByEmpresaAndAbonado(long codEmpresa, String codAbonado) {
        try {
            Query query = entityManager.createQuery("from " + SjaAbonado.class.getName() + " where id.codEmpresa = :empresa   and id.codAbonado = :abonado and stsAbonado = 'A'");
            query.setParameter("empresa", codEmpresa);
            query.setParameter("abonado", codAbonado);
            return (SjaAbonado) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    @Transactional
    public void createBatch(List<SjaAbonado> abonados) {
        for(int i = 0; i< abonados.size(); i++){
            entityManager.merge(abonados.get(i));
            if(i % 100 == 0 && i > 0){
                entityManager.flush();
                entityManager.clear();
            }
        }
        entityManager.flush();
        entityManager.clear();
    }

    @Transactional
    public void updateBatch(List<SjaAbonado> abonados) {
        for(int i = 0; i< abonados.size(); i++){
            entityManager.merge(abonados.get(i));
            if(i % 100 == 0 && i > 0){
                entityManager.flush();
                entityManager.clear();
            }
        }
        entityManager.flush();
        entityManager.clear();
    }

    @Override
    public List<SjaAbonado> filterByEmpleadoMovil(long codEmpresa, long codEmpleado) {

        try {
            // Crea la consulta StoredProcedure
             StoredProcedureQuery query = entityManager.createStoredProcedureQuery("obtener_abonados_movil", SjaAbonado.class);
            query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN.IN);  // codEmpresa
            query.registerStoredProcedureParameter(2, Long.class, ParameterMode.IN);  // fechaInicio
            query.setParameter(1, codEmpresa);
            query.setParameter(2, codEmpleado);  // Usar java.sql.Date
            query.execute();
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("ERROR obtener_abonados_movil: " + e);
            return null;
        } 
    }
    
}
