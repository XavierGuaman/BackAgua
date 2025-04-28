/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.util;

/**
 * Estado de la peticion
 *
 * @author edwin
 */
public enum Status {
    OK(1),
    ERROR(0),
    NORESULT(-4),
    NOTOKEN(-5),
    FAILURE(-1),
    TIMEOUT(-3),
    DUPLICATE(-2),
    NOSETUP(-2),
    EXEDEDDAY(-6),
    EXEDEDMONTH(-7),
    OFFLINE(-9),
    EXEDED(-8);
    private int value;

    Status(int v) {
        value = v;
    }

    public int get() {
        return value;
    }
}