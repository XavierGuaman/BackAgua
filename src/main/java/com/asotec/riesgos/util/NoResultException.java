/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.util;

/**
 * Clase que maneja las excepciones de consultas
 *
 * @author edwin
 */
public class NoResultException extends Exception {

    private String attribute;
    private Object value;

    public NoResultException(String attribute, Object value, String message) {
        super(message);
        this.attribute = attribute;
        this.value = value;
    }

    public NoResultException(String get) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
