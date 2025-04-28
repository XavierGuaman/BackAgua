/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Crea wrapper para cargar en datatable
 *
 * @author edwin
 */
public class WrapMap {

    private Map<String, Object> result;

    /**
     * Agrega parametros
     *
     * @param status estado de la peticion
     * @param msg mensaje descriptivo
     * @param data listado de objetos
     */
    public WrapMap(int status, String msg, Object data) {
        this.result = new HashMap<String, Object>();
        this.result.put("status", status);
        this.result.put("message", msg);
        this.result.put("data", data);
    }

    /**
     * Obtiene la instancia
     *
     * @return Map
     */
    public Map<String, Object> getInstance() {
        return this.result;
    }

}
