/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.exception;

/**
 *
 * @author edwin
 */
public class DuplicateIdException extends Exception {

    Object id;

    public DuplicateIdException(String message, String id) {
        super(message);
        this.id = id;
    }

    public DuplicateIdException(Object id, String message, Throwable cause) {
        super(message, cause);
        this.id = id;
    }

}
