/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.util;

/**
 * Revisa el resultado devuelto
 *
 * @author edwin
 */
public class ResultValidation {

    public static void getNoResult(String attribute, Object value) throws NoResultException {
        if (value == null) {
            new NoResultException(attribute, value, "NO HAY RESULTADOS");
        }
    }
}
