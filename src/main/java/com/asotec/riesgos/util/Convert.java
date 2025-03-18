/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Conversion de valores
 *
 * @author edwin
 */
public class Convert {

    /**
     *
     * @param target
     * @return
     */
    public static String charToString(Character target) {
        try {
            String result = Character.toString(target);
            return result;
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Convierte string a bigdecimal
     *
     * @param target string con formato aaaa-mm-dd
     * @return bigdecimal
     */
    public static BigDecimal strToBigDecimal(String target) {
        /*try {
            Long numero = Long.parseLong(target);
            return BigDecimal.valueOf(numero,0);
        } catch (Exception ex) {
            return null;
        }*/
        try {
            BigDecimal numero = new BigDecimal(target);
            return numero;
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Convierte objeto a string
     *
     * @param target object
     * @return string
     */
    public static String objToStr(Object target) {
        return String.valueOf(target);
    }

    /**
     * Convierte string a entero
     *
     * @param target string
     * @return entero
     */
    public static int strToInt(String target) {
        return Integer.parseInt(target);
    }

    /**
     * Convierte string a long
     *
     * @param target string
     * @return long
     */
    public static long strToLong(String target) {
        try {
            return Long.parseLong(target);
        } catch (NumberFormatException ex) {
            return -1;
        }

    }

    /**
     * Convierte string a char
     *
     * @param target string
     * @return char
     */
    public static char strToChar(String target) {
        return target.charAt(0);
    }

    /**
     * Convierte string a float
     *
     * @param target string
     * @return float
     */
    public static float strToFloat(String target) {
        return Float.parseFloat(target);
    }

    /**
     * Convierte string a double
     *
     * @param target string
     * @return double
     */
    public static double strToDouble(String target) {
        return Double.parseDouble(target);
    }

    /**
     * Convierte string a short
     *
     * @param target string
     * @return short
     */
    public static short strToShort(String target) {
        return Short.valueOf(target);
    }

    /**
     * Convierte string a BigInteger
     *
     * @param target string
     * @return BigInteger
     */
    public static BigInteger strToBigInteger(String target) {
        BigInteger bigIntegerStr = new BigInteger(target);
        //System.out.println("Converted String to BigInteger: "+bigIntegerStr);
        return bigIntegerStr;
    }

    /**
     * Convierte string a date
     *
     * @param target string con formato aaaa-mm-dd
     * @return date
     */
    public static Date strToDate(String target) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = formato.parse(target);
            return fecha;
        } catch (ParseException ex) {
            return null;
        }
    }

    /**
     * Convierte string a date time
     *
     * @param target string con formato aaaa-mm-dd hh:mm:ss
     * @return date
     */
    public static Date strToDateTimeStamp(String target) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date fecha = formato.parse(target);
            return fecha;
        } catch (ParseException ex) {
            return null;
        }
    }

    /**
     * Convierte string a BigInteger
     *
     * @param target string
     * @return BigInteger
     */
    public static float BigDecimalToFloat(BigDecimal target) {
        float rounded = target.setScale(4, RoundingMode.DOWN).floatValue();
        return rounded;
    }

    /**
     * Convierte string a date
     *
     * @param target string con formato aaaa-mm-dd
     * @return date
     */
    public static String dateToStr(Date target) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = sdf.format(target);
        return fecha;

    }

    /**
     * Convierte BigDecimal a Long
     *
     * @param target BigDecimal
     * @return Long
     */
    public static long strToBigLong(BigDecimal target) {
        long bigLong = target.longValue();
        return bigLong;
    }
    /**
     * Convierte long a int
     */
    public static int strToIntLong(long target) {
        // Long object
        Long longnum = target;
        int intnum = longnum.intValue();
        return intnum;
    }
}
