/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.util;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Clase para indicar el formato de salida del controlador
 *
 * @author edwin
 */
public class Response {

    /**
     * Arma la respuesta
     *
     * @param status codigo de status
     * @param msg mensaje del status
     * @param obj array de datos o null
     * @param hstatus estado del request
     * @return respuesta
     */
    public static ResponseEntity<Map<String, Object>> get(int status, String msg, Object obj, HttpStatus hstatus) {
        return new ResponseEntity<>(
                new WrapMap(status, msg, obj).getInstance(),
                hstatus);
    }

}
