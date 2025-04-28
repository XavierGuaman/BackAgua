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
public class C01 {
    public void getRegistros(String lineaTabla, org.w3c.dom.Document doc, ArrayList<String> cabecera, org.w3c.dom.Element elemento) {
        int j = 0;
//        System.out.println("\n");
        for (int i = 0; i < lineaTabla.split("\t").length -1; i++) {    // -3 : lee solo hasta ANTES de las ultimas 3 columnas

            if ((!lineaTabla.split("\t")[i].equalsIgnoreCase(""))) {
//                System.out.println("--" + cabecera.get(j) + ":: " + lineaTabla.split("\t")[i]);
                Attr attr = doc.createAttribute(cabecera.get(j));
                attr.setValue(lineaTabla.split("\t")[i]);
                elemento.setAttributeNode(attr);
                j++;
            } else {
                j++;
            }

            //Otro formato
//            if (i == lineaTabla.split("\t").length-1) {
//                System.out.println("--"+cabecera.get(j)+":: "+lineaTabla.split("\t")[i]);
//                String ubicacion = lineaTabla.split("\t")[i];
//                String provincia = ubicacion.substring(0, 2);
//                String canton = ubicacion.substring(2, 4);
//                String parroquia = ubicacion.substring(4, 6);
////                System.out.println("**VAL: " + provincia);
////                System.out.println("**VAL: " + canton);
////                System.out.println("**VAL: " + parroquia);
//
//                Attr attr = doc.createAttribute(cabecera.get(j));
//                attr.setValue(provincia);
//                elemento.setAttributeNode(attr);
//                j++;
//                attr = doc.createAttribute(cabecera.get(j));
//                attr.setValue(canton);
//                elemento.setAttributeNode(attr);
//                j++;
//                attr = doc.createAttribute(cabecera.get(j));
//                attr.setValue(parroquia);
//                elemento.setAttributeNode(attr);
//                j++;
//            } else {
//                if ((!lineaTabla.split("\t")[i].equalsIgnoreCase("")) || (!lineaTabla.split("\t")[i].isEmpty())) {
//                    System.out.println("--"+cabecera.get(j)+":: "+lineaTabla.split("\t")[i]);
//                    Attr attr = doc.createAttribute(cabecera.get(j));
//                    attr.setValue(lineaTabla.split("\t")[i]);
//                    elemento.setAttributeNode(attr);
//                    j++;
//                } else {
//                    j++;
//                }
//            }
        }
    }
}
