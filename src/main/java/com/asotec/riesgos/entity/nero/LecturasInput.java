/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity.nero;

/**
 *
 * @author ASOTEC
 */
public class LecturasInput {
    private String token;
    private long sector;
    private long mes;
    private long anio;

    public LecturasInput() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getSector() {
        return sector;
    }

    public void setSector(long sector) {
        this.sector = sector;
    }

    public long getMes() {
        return mes;
    }

    public void setMes(long mes) {
        this.mes = mes;
    }

    public long getAnio() {
        return anio;
    }

    public void setAnio(long anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "LecturasInput{" + "token=" + token + ", sector=" + sector + ", mes=" + mes + ", anio=" + anio + '}';
    }
    
}
