/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.SgfMensajes;
import com.asotec.riesgos.entity.SjaControl;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rolan
 */
@Repository
public class SgfMensajesDao extends GenericDao<SgfMensajes> implements ISgfMensajesDao {

    public SgfMensajesDao() {
        super();
        setClase(SgfMensajes.class);
    }

    @Override
    public SgfMensajes filterByIdNovedad(long idNovedad) {
         try {
            Query query = entityManager.createQuery("from " + SgfMensajes.class.getName() + " where numMensaje = :idNovedad ");
            query.setParameter("idNovedad", idNovedad);
            return (SgfMensajes) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }
    
}
