/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.ObtenerInformacion;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rolan
 */
@Repository
public class ObtenerInformacionDao extends GenericDao<ObtenerInformacion> implements IObtenerInformacionDao {

    public ObtenerInformacionDao() {
        super();
        setClase(ObtenerInformacion.class);
    }

    @Override
    public ObtenerInformacion getInfoSocio(String codMedidor, long codEmpresa) {
        try {
            // Consulta SQL para llamar a la función
            String sql = "SELECT * FROM obtener_informacion(:cod_medidor,:cod_empresa )";
            Query query = entityManager.createNativeQuery(sql, ObtenerInformacion.class);
             query.setParameter("cod_medidor", codMedidor);
            query.setParameter("cod_empresa", codEmpresa);
           

            // Ejecutar la consulta y devolver los resultados
             return (ObtenerInformacion) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("ERROR obtener_informacion: " + e);
            return null;
        }
    }
    
}
