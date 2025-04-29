/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.estructurasSeg3;

import java.util.ArrayList;
import org.w3c.dom.Attr;

/**
 *
 * @author User
 */
public class C02 {
    public void getRegistros(String lineaTabla, org.w3c.dom.Document doc, ArrayList<String> cabecera, org.w3c.dom.Element elemento) {
        int j = 0;
//        System.out.println("\n");
        for (int i = 0; i < lineaTabla.split("\t").length; i++) {
            if (!lineaTabla.split("\t")[i].equalsIgnoreCase("")) {
//                System.out.println("--("+i+")--("+j+")"+cabecera.get(j)+":: "+lineaTabla.split("\t")[i]);
                Attr attr = doc.createAttribute(cabecera.get(j));
                attr.setValue(lineaTabla.split("\t")[i]);
                elemento.setAttributeNode(attr);
                j++;
            } else {
                j++;
            }
        }
    }
}
