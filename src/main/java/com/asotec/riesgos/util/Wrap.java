/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.util;

import java.util.List;

/**
 * Encapsula la respuesta de un solo registro
 *
 * @author edwin
 */
public class Wrap<T> {

    private String[] token; //api
    /**
     * Estado de la peticion
     */
    private int status;
    /**
     * Mensaje descriptivo para el usuario
     */
    private String message;
    /**
     * Dataset
     */
    private T data;
    
    /**
     * Dataset
     */
    private Object dataset;

    public Wrap() {
    }

    /**
     * Constructor
     *
     * @param status estado de la peticion
     * @param message mensaje para frontend
     * @param data dataset
     */
    public Wrap(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    /**
     * Modifica los parametros
     *
     * @param status estado de la peticion
     * @param message mensaje para frontend
     * @param data datase
     */
    public void set(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getList() {
        return data;
    }

    public void setList(T data) {
        this.data = data;
    }

    public Object getDataset() {
        return dataset;
    }

    public void setDataset(Object dataset) {
        this.dataset = dataset;
    }

    
}
