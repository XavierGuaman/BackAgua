/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.entity.AsignacionSectores;
import java.util.List;

/**
 *
 * @author rolan
 */
public interface IAsignacionSectoresService extends IGenericService<AsignacionSectores>{
    public List<AsignacionSectores> filterByEmpresa(long codEmpresa);
}
