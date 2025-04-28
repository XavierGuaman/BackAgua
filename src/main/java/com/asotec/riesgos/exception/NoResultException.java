package com.asotec.riesgos.exception;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Clase que maneja las excepciones de consultas
 *
 * @author edwin
 */
public class NoResultException extends Exception {

    private String attribute;
    private Object value;

    public NoResultException(String message) {
        super(message);
    }

    public NoResultException(String attribute, Object value, String message) {
        super(message);
        this.attribute = attribute;
        this.value = value;
    }
}
