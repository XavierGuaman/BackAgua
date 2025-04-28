/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.util;

import com.asotec.riesgos.exception.InvalidAttributeException;
import java.util.Date;

/**
 * Clase para la validacion de atributos
 *
 * @author edwin
 */
public class Validation {

    /**
     * Valida que la cadena no sea nula ni este vacía
     *
     * @param attr campo
     * @param value valor
     * @throws InvalidAttributeException
     */
    public static void checkNullEmpty(String attr, String value) throws InvalidAttributeException {
        if (value == null) {
            throw new InvalidAttributeException(attr, value, "VALOR DE " + attr + " NO PUEDE SER VALOR NULO");
        } else if (value.trim().length() == 0) {
            throw new InvalidAttributeException(attr, value, "VALOR DE " + attr + "  NO PUEDE ESTAR VACIO");
        }

    }


    /**
     * Valida que el objecto no sea nulo
     *
     * @param attr campo
     * @param obj objeto
     * @throws InvalidAttributeException
     */
    public static void checkNullObj(String attr, Object obj) throws InvalidAttributeException {
        if (obj == null) {
            throw new InvalidAttributeException(attr, obj, "VALOR DE " + attr + " NO PUEDE SER VALOR NULO");
        }
    }

    /**
     * Valida que dos objecto no sean nulos
     *
     * @param attr campo
     * @param obj objeto
     * @param obj2 objeto
     * @throws InvalidAttributeException
     */
    public static void checkNullObjs(String attr, Object obj, Object obj2) throws InvalidAttributeException {
        if (obj == null && obj2 == null) {
            throw new InvalidAttributeException(attr, obj, "LOS DOS OBJECTOS NO PUEDEN SER NULOS");
        }
    }

    /**
     * Valida que el objeto no sea nulo
     *
     * @param obj objeto
     * @throws InvalidAttributeException
     */
    public static void checkNullObj(Object obj) throws InvalidAttributeException {
        if (obj == null) {
            throw new InvalidAttributeException("", obj, "OBJETO NO PUEDE SER VALOR NULO");
        }
    }

    /**
     * Valida que el valor no sea menor a cero
     *
     * @param attr campo
     * @param value valor
     * @throws InvalidAttributeException
     */
    public static void checkNegative(String attr, float value) throws InvalidAttributeException {
        if (value < 0) {
            throw new InvalidAttributeException(attr, value, "VALOR DE " + attr + " NO PUEDE SER NEGATIVO");
        }
    }

    /**
     * Valida que el valor no sea menor a cero
     *
     * @param attr campo
     * @param value valor
     * @throws InvalidAttributeException
     */
    public static void checkNegative(String attr, long value) throws InvalidAttributeException {
        if (value < 0) {
            throw new InvalidAttributeException(attr, value, "VALOR DE " + attr + " NO PUEDE SER NEGATIVO");
        }
    }

    /**
     * Valida que el valor no sea menor a cero
     *
     * @param attr campo
     * @param value valor
     * @throws InvalidAttributeException
     */
    public static void checkNegative(String attr, int value) throws InvalidAttributeException {
        if (value < 0) {
            throw new InvalidAttributeException(attr, value, "VALOR DE " + attr + " NO PUEDE SER NEGATIVO");
        }
    }

    /**
     * Valida que el valor no sea menor a uno
     *
     * @param attr campo
     * @param value valor
     * @throws InvalidAttributeException
     */
    public static void checkLessThanOne(String attr, float value) throws InvalidAttributeException {
        if (value < 1) {
            throw new InvalidAttributeException(attr, value, "VALOR DE " + attr + " NO PUEDE SER NEGATIVO NI CERO");
        }
    }

    /**
     * Valida que el valor no sea menor a uno
     *
     * @param attr campo
     * @param value valor
     * @throws InvalidAttributeException
     */
    public static void checkLessThanOne(String attr, int value) throws InvalidAttributeException {
        if (value < 1) {
            throw new InvalidAttributeException(attr, value, "VALOR DE " + attr + " NO PUEDE SER NEGATIVO NI CERO");
        }
    }

    /**
     * Valida que la fecha inicial no sea mayor a la fecha final
     *
     * @param attr campo
     * @param ini fecha inicial
     * @param end fecha final
     * @throws InvalidAttributeException
     */
    public static void checkDateDiff(String attr, Date ini, Date end) throws InvalidAttributeException {
        if (ini.compareTo(end) > 0) {
            throw new InvalidAttributeException(attr, ini, "FECHA INICAL " + ini.getDate() + " NO PUEDE SER MAYOR QUE LA FECHA FINAL " + end.getDate());
        }
    }
}
