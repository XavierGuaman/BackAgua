/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.SjaNovedad;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rolan
 */
@Repository
public class SjaNovedadDao extends GenericDao<SjaNovedad> implements ISjaNovedadDao {

    public SjaNovedadDao() {
        super();
        setClase(SjaNovedad.class);
    }
    
    
}
