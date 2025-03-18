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
public class S01 {

    public void getRegistros(String lineaTabla, org.w3c.dom.Document doc, ArrayList<String> cabecera, org.w3c.dom.Element elemento) {
        int j = 0;
        boolean banderafecNull = false;
        boolean banderaTipoR = false;
        System.out.println("");
        for (int i = 0; i < lineaTabla.split("\t").length; i++) {
            if (!lineaTabla.split("\t")[i].equalsIgnoreCase("")) {
                System.out.println("--" + cabecera.get(j) + ":: " + lineaTabla.split("\t")[i]);
                
                //VALIDACION tipo id = R, y condicionar con: 
                //fec_nacmiento -> NO
                //pais_nac -> NO
                //gnero => N
                if (i == 0) {
                    String tipoId = lineaTabla.split("\t")[i];
                    if (tipoId.equalsIgnoreCase("R")) {
                        System.out.println("ADD--" + cabecera.get(j) + ":: " + lineaTabla.split("\t")[i]);   
                        banderaTipoR = true;
                    }
                    Attr attr = doc.createAttribute(cabecera.get(j));
                    attr.setValue(tipoId);
                    elemento.setAttributeNode(attr);
                }
                
                // Tags ASAMBLEA y DIRECTIVA posicion de "asambleaGeneral"
                if (i == 8 || i == 10) {
                    if (lineaTabla.split("\t")[i].equalsIgnoreCase("NO")) {
                        //System.out.println("**NO en AsamGeneral | Directiva");
                        banderafecNull = true;
                    } else {
                        //System.out.println("**SI en AsamGeneral | Directiva");
                    }
                    Attr attr = doc.createAttribute(cabecera.get(j));
                    attr.setValue(lineaTabla.split("\t")[i]);
                    elemento.setAttributeNode(attr);
                } else {
                    if (((i == 9) && banderafecNull) || ((i == 11) && banderafecNull)) {
                        //No guarda tag de fechas
                        //System.out.println("**No mostrar Fec AsamGeneral | Directiva");
                        banderafecNull = false;
                    } else if (((i == 2) && banderaTipoR) || ((i == 4) && banderaTipoR) ) {//fec nacimiento
                        if (i == 4) {
                            //no se agrega fecNacimiento y pais -- termina de omitir el i=2(fec_nac) y el i=4(cod_pais)
                            banderaTipoR = false;
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
