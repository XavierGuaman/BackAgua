/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.MedidoresPendientes;
import com.asotec.riesgos.entity.NovedadesLecturas;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import org.postgresql.util.PGobject;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rolan
 */
@Repository
public class NovedadesLecturasDao extends GenericDao<NovedadesLecturas> implements INovedadesLecturasDao{

    public NovedadesLecturasDao() {
        super();
        setClase(NovedadesLecturas.class);
    }

    
    @Override
    public List<NovedadesLecturas> obtenerNovedadesLecturas(List<String> filtros, long umbral, Date fecInicio, Date fecFinal, long sector) {
       try {
        String filtrosPG = "{" + String.join(",", filtros) + "}"; // Genera '{mayores,iguales}'
        String sql = "SELECT * FROM obtener_novedades(CAST(? AS text[]), ?, ?, ?, ?)";

        Query query = entityManager.createNativeQuery(sql, NovedadesLecturas.class);
        query.setParameter(1, filtrosPG);  // Pasamos como String con formato ARRAY{}
        query.setParameter(2, umbral);  
        query.setParameter(3, fecInicio != null ? new Timestamp(fecInicio.getTime()) : null);
        query.setParameter(4, fecFinal != null ? new Timestamp(fecFinal.getTime()) : null);
        query.setParameter(5, sector);

        return query.getResultList();
    } catch (Exception e) {
        System.out.println("ERROR list novedades lecturas: " + e);
        return null;
    }
    }
    
}
