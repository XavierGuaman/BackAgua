/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.SjaAbonado;
import com.asotec.riesgos.entity.SjaMedidor;
import com.asotec.riesgos.entity.SjaSector;
import com.asotec.riesgos.util.NoResultException;
import java.util.List;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASOTEC
 */
@Repository
public class SjaMedidorDao extends GenericDao<SjaMedidor> implements ISjaMedidorDao {

    public SjaMedidorDao() {
        super();
        setClase(SjaMedidor.class);
    }

    @Override
    public List<SjaMedidor> filterByEmpresa(long codEmpresa) {
        try {
            Query query = entityManager.createQuery("from " + SjaMedidor.class.getName() + " where id.codEmpresa = :empresa and stsLectura = 'A'");
            query.setParameter("empresa", codEmpresa);
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public SjaMedidor filterByEmpresaAndCodMedidor(long codEmpresa, String codMedidor) {
        try {
            Query query = entityManager.createQuery("from " + SjaMedidor.class.getName() + " where id.codEmpresa = :empresa and id.codMedidor = :medidor");
            query.setParameter("empresa", codEmpresa);
            query.setParameter("medidor", codMedidor);

            List<SjaMedidor> resultList = query.getResultList();
            if (resultList.isEmpty()) {
                return null;
            }
            return resultList.get(0);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error al ejecutar la consulta: " + ex.getMessage());
            return null;
        }
    }

    @Transactional
    public void createBatch(List<SjaMedidor> medidores) {
        for (int i = 0; i < medidores.size(); i++) {
            entityManager.persist(medidores.get(i));
            if (i % 100 == 0 && i > 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
        entityManager.flush();
        entityManager.clear();
    }

    @Transactional
    public void updateBatch(List<SjaMedidor> medidores) {
        for (int i = 0; i < medidores.size(); i++) {
            entityManager.merge(medidores.get(i));
            if (i % 100 == 0 && i > 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
        entityManager.flush();
        entityManager.clear();
    }

    @Override
    public List<SjaMedidor> filterByEmpleadoMovil(long codEmpresa, long codEmpleado) {
        try {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("obtener_medidores_movil", SjaMedidor.class);
            query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN.IN);
            query.registerStoredProcedureParameter(2, Long.class, ParameterMode.IN);
            query.setParameter(1, codEmpresa);
            query.setParameter(2, codEmpleado);
            query.execute();
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("ERROR obtener_medidores_movil: " + e);
            return null;
        }
    }

    @Transactional
    public void updateStsLecturaByEmpresa(Long empresaId, String status) {
       Query query = entityManager.createQuery(
        "UPDATE SjaMedidor m SET m.stsLectura = :status WHERE m.id.codEmpresa = :empresaId"
    );

        query.setParameter("status", status);
        query.setParameter("empresaId", empresaId);
        query.executeUpdate();
    }

    @Override
    public void updateStsMedidorByEmpresa(Long empresaId, String status) {
        Query query = entityManager.createQuery(
        "UPDATE SjaMedidor m SET m.stsMedidorActivo = :status WHERE m.id.codEmpresa = :empresaId"
    );

        query.setParameter("status", status);
        query.setParameter("empresaId", empresaId);
        query.executeUpdate();
    }

}
