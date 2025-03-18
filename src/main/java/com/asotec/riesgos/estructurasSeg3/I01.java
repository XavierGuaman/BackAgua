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
public class I01 {

    public void getRegistros(String lineaTabla, org.w3c.dom.Document doc, ArrayList<String> cabecera, org.w3c.dom.Element elemento) {
        int j = 0;
        boolean noAgregarValor = false;
//        System.out.println("\n");
        for (int i = 0; i < lineaTabla.split("\t").length; i++) {
            if (!lineaTabla.split("\t")[i].equalsIgnoreCase("")) {
//                System.out.println("--(" + i + ")--(" + j + ")" + cabecera.get(j) + ":: " + lineaTabla.split("\t")[i]);

                if (i == 5) {//tipo instrumento
                    if (lineaTabla.split("\t")[i].equalsIgnoreCase("T36")
                            || lineaTabla.split("\t")[i].equalsIgnoreCase("T37")) { //Son FONDOS DISPONIBLES
                        //NO agrega valorCompra(i=7) y valorNominal(i=8)
                        noAgregarValor = true;
                    }
                    
                    Attr attr = doc.createAttribute(cabecera.get(j));
                    attr.setValue(lineaTabla.split("\t")[i]);
                    elemento.setAttributeNode(attr);
                } else {
                    if (i == 7 || i == 8) {
                        if (noAgregarValor) {
                            //No agrega i=8 e i=7
                            if (i==8) {
                                noAgregarValor = false;
                            }
                        } else {
                            Attr attr = doc.createAttribute(cabecera.get(j));
                            attr.setValue(lineaTabla.split("\t")[i]);
                            elemento.setAttributeNode(attr);
                        }
                    } else {
                        Attr attr = doc.createAttribute(cabecera.get(j));
                        attr.setValue(lineaTabla.split("\t")[i]);
                        elemento.setAttributeNode(attr);
                    }

                }
                j++;
            } else {
                j++;
            }
        }
    }
}
