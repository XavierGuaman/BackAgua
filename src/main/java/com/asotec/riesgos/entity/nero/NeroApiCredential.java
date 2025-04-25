/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity.nero;

import java.io.Serializable;

/**
 *
 * @author ASOTEC
 * Credenciales para la validacion en la api de Nero
 */
public class NeroApiCredential implements Serializable{
    private String username;
    private String password;

    public NeroApiCredential() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "NeroApiCredential{" + "username=" + username + ", password=" + password + '}';
    }
    
    
}
