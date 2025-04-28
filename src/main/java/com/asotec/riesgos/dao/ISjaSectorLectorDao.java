/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.SjaSectorLector;
import java.util.List;

/**
 *
 * @author USER
 */
public interface ISjaSectorLectorDao extends IGenericDao<SjaSectorLector>{
    public List<SjaSectorLector> filterByEmpresa(long codEmpresa);
}
