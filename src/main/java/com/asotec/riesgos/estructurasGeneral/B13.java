/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.estructurasGeneral;

import java.util.ArrayList;
import org.w3c.dom.Attr;

/**
 *
 * @author User
 */
public class B13 {
    public void getRegistros(String lineaTabla, org.w3c.dom.Document doc, ArrayList<String> cabecera, org.w3c.dom.Element elemento) {
        int j = 0;
//        System.out.println("\n");
        for (int i = 0; i < lineaTabla.split("\t").length; i++) {
            if ((!lineaTabla.split("\t")[i].equalsIgnoreCase(""))) {
//                System.out.println("--" + cabecera.get(j) + ":: " + lineaTabla.split("\t")[i]);

                String valueAttr = lineaTabla.split("\t")[i];
                Attr attr = doc.createAttribute(cabecera.get(j));
                attr.setValue(valueAttr);
                elemento.setAttributeNode(attr);
                j++;

//                if (valueAttr.contains(".") || valueAttr.contains(",") || valueAttr.equalsIgnoreCase("0")) {
//                    if (valueAttr.equalsIgnoreCase("0")) {
//                        attr.setValue("0.00");
//                        elemento.setAttributeNode(attr);
//                        j++;
//                    } else {
//                        attr.setValue((valueAttr.replace(".", "")).replace(",", "."));
//                        elemento.setAttributeNode(attr);
//                        j++;
//                    }
//                } else {
//                    attr.setValue(valueAttr);
//                    elemento.setAttributeNode(attr);
//                    j++;
//                }
                               
            } else {
                j++;
            }
        }
    }
}
