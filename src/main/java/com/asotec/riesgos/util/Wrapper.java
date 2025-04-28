/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.util;

import java.util.List;

/**
 * Encapsula respuesta de varios registros
 *
 * @param <T> clase
 * @author edwin
 */
public class Wrapper<T> {

    private String id;// ruc
    private String[] token; //api
    private String corte; //fecha corte aaaa-mm-dd

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
    private List<T> data;

    /**
     * Object
     */
    private T obj;

    public Wrapper() {
    }

    /**
     * Constructor
     *
     * @param status  estado de la peticion
     * @param message mensaje para frontend
     * @param data    dataset
     */
    public Wrapper(int status, String message, List<T> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    /**
     * Modifica los parametros
     *
     * @param status  estado de la peticion
     * @param message mensaje para frontend
     * @param data    datase
     */
    public void set(int status, String message, List<T> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<T> getList() {
        return data;
    }

    public void setList(List<T> data) {
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String[] getToken() {
        return token;
    }

    public void setToken(String[] token) {
        this.token = token;
    }

    public String getToken(int idx) {
        return token[idx];
    }


    /*public void setToken(String token) {
        this.token = token;
    }*/
    public String getCorte() {
        return corte;
    }

    public void setCorte(String corte) {
        this.corte = corte;
    }


    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
