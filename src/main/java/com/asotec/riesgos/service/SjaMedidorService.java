/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.ISjaMedidorDao;
import com.asotec.riesgos.entity.SjaMedidor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASOTEC
 */
@Service
@Transactional
public class SjaMedidorService extends GenericService<SjaMedidor> implements ISjaMedidorService{

    @Autowired
    private ISjaMedidorDao dao;
    
    public SjaMedidorService() {
        super();
    }
    
    @Override
    public List<SjaMedidor> filterByEmpresa(long codEmpresa) {
        return dao.filterByEmpresa(codEmpresa);
    }

    @Override
    public SjaMedidor filterByEmpresaAndCodMedidor(long codEmpresa, String codMedidor) {
        return dao.filterByEmpresaAndCodMedidor(codEmpresa, codMedidor);
    }
    // Método para insertar medidores en lote
    @Transactional
    public void createBatch(List<SjaMedidor> medidores) {
        
        dao.createBatch(medidores);  // Llamar al DAO para insertar medidores en lote
    }

    // Método para actualizar medidores en lote
    @Transactional
    public void updateBatch(List<SjaMedidor> medidores) {
        dao.updateBatch(medidores);  // Llamar al DAO para actualizar medidores en lote
    }

    @Override
    public List<SjaMedidor> filterByEmpleadoMovil(long codEmpresa, long codEmpleado) {
        return dao.filterByEmpleadoMovil(codEmpresa, codEmpleado);
    }

    @Transactional
    public void updateStsLecturaByEmpresa(Long empresaId, String status) {
        dao.updateStsLecturaByEmpresa(empresaId, status);
    }

    @Override
    public void updateStsMedidorByEmpresa(Long empresaId, String status) {
        dao.updateStsMedidorByEmpresa(empresaId, status);
    }
    
}
