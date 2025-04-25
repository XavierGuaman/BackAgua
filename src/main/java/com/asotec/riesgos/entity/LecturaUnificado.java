/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.entity;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author rolan
 */
public class LecturaUnificado {
    private SjaLectura lectura;
    private byte[] foto;

    public SjaLectura getLectura() {
        return lectura;
    }

    public void setLectura(SjaLectura lectura) {
        this.lectura = lectura;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    } 
}
