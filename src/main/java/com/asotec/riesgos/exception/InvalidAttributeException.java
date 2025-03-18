/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.exception;

/**
 * Clase de excepciones personalizadas
 *
 * @author edwin
 */
public class InvalidAttributeException extends Exception {

    private String attribute;
    private Object value;

    public InvalidAttributeException(String atributo, Object valor, String string) {
        super(string);
        this.attribute = atributo;
        this.value = valor;
    }

    public InvalidAttributeException(String atributo, Object valor, String string, Throwable thrwbl) {
        super(string, thrwbl);
        this.attribute = atributo;
        this.value = valor;
    }

    public InvalidAttributeException(String atributo, Object valor, Throwable thrwbl) {
        super(thrwbl);
        this.attribute = atributo;
        this.value = valor;
    }

    public String getAttribute() {
        return this.attribute;
    }

    public Object getValue() {
        return this.value;
    }
}
