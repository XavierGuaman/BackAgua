/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.IAsignacionSectoresDao;
import com.asotec.riesgos.entity.AsignacionSectores;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rolan
 */
@Service
@Transactional
public class AsignacionSectoresService extends GenericService<AsignacionSectores> implements IAsignacionSectoresService{

    @Autowired
    private IAsignacionSectoresDao dao;
    
    public AsignacionSectoresService() {
        super();
    }

    
    
    @Override
    public List<AsignacionSectores> filterByEmpresa(long codEmpresa) {
        return dao.filterByEmpresa(codEmpresa);
    }
    
}
