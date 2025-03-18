/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.entity.SjaControl;
import java.util.List;

/**
 *
 * @author USER
 */

public interface ISjaControlService extends IGenericService<SjaControl>{
    public SjaControl filterByEmpresa(long codEmpresa);
}
