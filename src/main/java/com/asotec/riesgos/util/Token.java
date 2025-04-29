/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.util;

import java.net.URLEncoder;
import java.security.spec.KeySpec;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * crea y valida el token de sesion
 *
 * @author josesanchez
 */
public class Token {

    private static final String SECRET_KEY = "SolucionesInformaticasASOTEC1234@";
    private static final String SALT = "Asotec2020abc";


    public static String[] validar(String token) {
        String[] respuesta = {"", ""};
        try {
            String str = decode(token, SECRET_KEY);
            String[] parametros = str.split("#");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date expira = sdf.parse(parametros[1]);
            Date actual = new Date();
            if (actual.before(expira)) {
                respuesta[0] = parametros[0];
                respuesta[1] = token;
            } else {
                respuesta[0] = "0";
                respuesta[1] = "EXPIRED_TOKEN";
            }
            return respuesta;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            respuesta[0] = "0";
            respuesta[1] = "INVALID_TOKEN";
            return respuesta;
        }
    }

    public static Respuesta generar(String id) {
        Respuesta result = new Respuesta();
        try {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.HOUR, 15);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String token = id + "#" + sdf.format(cal.getTime()) + "#" + SECRET_KEY;
            String encriptado = encriptar(token, SECRET_KEY);
            result.setToken(encriptado);
            result.setCaducidad(sdf.format(cal.getTime()));
            return result;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            String msg = "NO_TOKEN";
            result.setToken(msg);
            return result;
        }
    }

    public static String encriptar(String clave, String secret) {
    try {
        byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        IvParameterSpec ivspec = new IvParameterSpec(iv);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(secret.toCharArray(), SALT.getBytes(), 65536, 256);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
        // Devuelve el resultado en Base64 sin URL encoding
        return Base64.getEncoder().encodeToString(cipher.doFinal(clave.getBytes()));
    } catch (Exception e) {
        System.out.println("Error al encriptar: " + e.toString());
    }
    return null;
}

    public static String decode(String clave, String secret) {
    try {
        // Asegúrate de que la clave esté correctamente decodificada de Base64
        clave = clave.replaceAll("[^A-Za-z0-9+/=]", ""); // Elimina caracteres no válidos

        byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        IvParameterSpec ivspec = new IvParameterSpec(iv);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(secret.toCharArray(), SALT.getBytes(), 65536, 256);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
        
        // Decodifica de Base64 y pasa por el cipher
        return new String(cipher.doFinal(Base64.getDecoder().decode(clave)));
    } catch (Exception e) {
        System.out.println("Error al desencriptar: " + e.toString());
    }
    return null;
}

}
