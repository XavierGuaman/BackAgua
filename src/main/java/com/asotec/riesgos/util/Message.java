/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.util;

/**
 * Mensajes personalizados para el frontend
 *
 * @author edwin
 */
public enum Message {
    OK("OK"),
    ERROR("Error al procesar la peticion"),
    NO_RESULT("NO_RESULT"),
    NULL_OBJECT("Error al procesar la consulta"),
    NO_DATA("No hay datos"),
    NO_OPERACION("No recibiendo datos"),
    EXEDED_DIARIO("Ha excedito limite transferencias diaria"),
    EXEDED_MENSUAL("Ha excedito limite transferencias mensual"),
    OFFLINE("Fuera de linea"),
    INVALID_TOKEN("INVALID TOKEN"),
    EXPIRED_TOKEN("EXPIRED TOKEN"),
    EXEDED("Monto excedido"),
    MORETANONE("Ya existe");
    private final String msg;

    Message(String msg) {
        this.msg = msg;
    }

    public String get() {
        return msg;
    }
}
