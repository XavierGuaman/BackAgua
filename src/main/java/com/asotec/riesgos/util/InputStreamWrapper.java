/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.util;

import java.io.ByteArrayInputStream;

/**
 *
 * @author josesanchez
 */
public class InputStreamWrapper {

    private static ByteArrayInputStream byteArrayInputStream;
    private static int byteCount;

    public static ByteArrayInputStream getByteArrayInputStream() {
        return byteArrayInputStream;
    }

    public static void setByteArrayInputStream(ByteArrayInputStream byteArrayInputStream) {
        InputStreamWrapper.byteArrayInputStream = byteArrayInputStream;
    }



    public static int getByteCount() {
        return byteCount;
    }

    public  void setByteCount(int byteCount) {
        this.byteCount = byteCount;
    }
}
