/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.SjaLectura;
import com.asotec.riesgos.entity.SrlTipoUsuario;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASOTEC
 */
@Repository
public class SjaLecturaDao extends GenericDao<SjaLectura> implements ISjaLecturaDao {

    public SjaLecturaDao() {
        super();
        setClase(SjaLectura.class);
    }

    @Override
    public List<SjaLectura> filterByEmpresa(long codEmpresa) {
        try {
            Query query = entityManager.createQuery("from " + SjaLectura.class.getName() + " where id.codEmpresa = :empresa and stsLectura = 'A'");
            query.setParameter("empresa", codEmpresa);
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public SjaLectura filterLecturaByPeriodo(long codEmpresa, String codMedidor, long codPeriodoMes, long codPeriodoAnio) {
        try {

            Query query = entityManager.createQuery("from " + SjaLectura.class.getName()
                    + " where id.codEmpresa = :empresa and id.codMedidor = :medidor "
                    + "and codPeriodoMes = :mes and codPeriodoAnio = :anio and stsLectura = 'A'");
            query.setParameter("empresa", codEmpresa);
            query.setParameter("medidor", codMedidor);
            query.setParameter("mes", codPeriodoMes);
            query.setParameter("anio", codPeriodoAnio);

            List<SjaLectura> resultList = query.getResultList();
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

}
