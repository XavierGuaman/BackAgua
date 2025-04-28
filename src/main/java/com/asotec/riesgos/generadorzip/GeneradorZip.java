/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.generadorzip;

import com.asotec.riesgos.estructurasGeneral.B13;
import com.asotec.riesgos.estructurasGeneral.D01;
import com.asotec.riesgos.estructurasGeneral.F01;
import com.asotec.riesgos.estructurasGeneral.L01;
import com.asotec.riesgos.estructurasGeneral.S01;
import com.asotec.riesgos.estructurasSeg3.C01;
import com.asotec.riesgos.estructurasSeg3.C02;
import com.asotec.riesgos.estructurasSeg3.C03;
import com.asotec.riesgos.estructurasSeg3.C04;
import com.asotec.riesgos.estructurasSeg3.I01;
import com.asotec.riesgos.estructurasSeg3.I02;
import com.asotec.riesgos.estructurasSeg3.IG01;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.springframework.util.FileSystemUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;

/**
 *
 * @author User
 */
public class GeneradorZip {
    public byte[] generarZip(String nameFileTXT){

//NOTA: veririfacr si da error con RUC sin 0 al inicio

//        String path = "C:\\coop\\SEPS_XML\\";
        String path = "C:\\SEPS\\XML\\";
        System.out.println("\n\tUbicacion de archivos .txt: "+path);

//        System.out.print("\n\tIngrese nombre del archivo Ej: C0120220630.txt: ");
//        Scanner entrada=new Scanner(System.in);
//        String filename = entrada.nextLine();

//        String filename = "B11Test.txt";
        String filename = nameFileTXT;  //Pruebas
//        String filename = args[0];      //Produccion
        System.out.println("\nNombre de archivo: "+filename.trim());

        //Leer por cmd, nombre del archivo

        String headCodEstructura = "";
        String headCodEntidad = "";
        String headFecDatos = "";
        String headNumRegistros = "";
        
        byte[] zipContent = null;

        try {

            DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
            org.w3c.dom.Document doc = docBuilder.newDocument();
            doc.setXmlStandalone(true);

//            InputStream ins = new FileInputStream(path+filename.trim());
//            Scanner obj = new Scanner(ins);

            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(path+filename.trim()), "ISO-8859-1"));

            //Elemento raíz
            org.w3c.dom.Element rootElement = null;
            String codEstruc;
            if (nameFileTXT.contains("IG")) {//Indicadors de GENERO
                codEstruc = filename.trim().substring(0,4);
            }else {
                codEstruc = filename.trim().substring(0,3);
            }
            switch (codEstruc) {
                case "D01":
                    rootElement = doc.createElement("depositos");
                    doc.appendChild(rootElement);
                    break;
                case "S01":
                    rootElement = doc.createElement("socio");
                    doc.appendChild(rootElement);
                    break;

                case "C01": //en <xml> debe ir standalone="yes"
                    rootElement = doc.createElement("ns1:operacion");
                    doc.appendChild(rootElement);
                    break;
                case "C02": //en <xml> debe ir standalone="yes"
                    rootElement = doc.createElement("ns1:saldo");
                    doc.appendChild(rootElement);
                    break;
                case "C03": //en <xml> debe ir standalone="yes"
                    rootElement = doc.createElement("ns1:garantia");
                    doc.appendChild(rootElement);
                    break;
                case "C04":
                    rootElement = doc.createElement("ns1:bien");
                    doc.appendChild(rootElement);
                    break;

                case "F01": 
                    rootElement = doc.createElement("financiero");
                    doc.appendChild(rootElement);
                    break;
                case "L01": 
                    rootElement = doc.createElement("liquidez");
                    doc.appendChild(rootElement);
                    break;

                case "I01": //en <xml> debe ir standalone="yes"
                    //rootElement = doc.createElement("ns1:portafolio");
                    rootElement = doc.createElement("portafolio");
                    doc.appendChild(rootElement);
                    break;
                case "I02": //en <xml> debe ir standalone="yes"
                    //rootElement = doc.createElement("ns1saldos");
                    rootElement = doc.createElement("saldos");
                    doc.appendChild(rootElement);
                    break;

                case "B13":
                    rootElement = doc.createElement("balance");
                    doc.appendChild(rootElement);
                    break;
                case "B11":
                    rootElement = doc.createElement("balance");
                    doc.appendChild(rootElement);
                    break;
                
                case "IG01":
                    rootElement = doc.createElement("indicadoresIG01");
                    doc.appendChild(rootElement);
                    break;
            }

//            while (obj.hasNextLine())
            String sCadena;
            while ((sCadena = in.readLine()) != null){


                String objLinea = cleanString(sCadena);

                int indiceEntidad = 1;
                int indiceEstructura = 1;
                int indiceFecha = 1;
                if (codEstruc.equalsIgnoreCase("L01")) { //Numero de \t para la cabecera del reporte
                    indiceEntidad = 4;
                    indiceEstructura = 3;
                    indiceFecha = 2;
                } else {

                }
//                System.out.println("Linea: "+ objLinea);
                if (objLinea.contains("de la Estructura")) {
                    headCodEstructura = objLinea.split("\t")[indiceEstructura];
                    System.out.println("Leyendo estructura: " + objLinea.split("\t")[indiceEstructura]);

                    //Se agrega un atributo al nodo elemento y su valor
                    Attr attr = doc.createAttribute("estructura");
                    attr.setValue(objLinea.split("\t")[indiceEstructura]);
                    rootElement.setAttributeNode(attr);
                }

                if (objLinea.contains("Entidad")) {
                    headCodEntidad = objLinea.split("\t")[indiceEntidad];
//                    if (objLinea.contains("Fecha de datos")) {
//                        System.out.println("Validacion FechaDatos: " + objLinea.split("\t")[6]);
//                        Attr attr = doc.createAttribute("fechaCorte");
//                        attr.setValue(objLinea.split("\t")[6]);
//                        rootElement.setAttributeNode(attr);
//                    }
                    Attr attr = doc.createAttribute("rucEntidad");
                    attr.setValue(objLinea.split("\t")[indiceEntidad]);
                    rootElement.setAttributeNode(attr);
                }

                if (objLinea.contains("Fecha de datos")) {
                    headFecDatos = objLinea.split("\t")[indiceFecha];
//                    System.out.println(objLinea.split("\t")[1]);

                    Attr attr = doc.createAttribute("fechaCorte");
                    attr.setValue(objLinea.split("\t")[indiceFecha]);
                    rootElement.setAttributeNode(attr);
                }

                if (objLinea.contains("Numero de Registros")) {
                    headNumRegistros = objLinea.split("\t")[0];

                    Attr attr = doc.createAttribute("numRegistro");
                    attr.setValue(objLinea.split("\t")[1]);
                    rootElement.setAttributeNode(attr);

                    ArrayList<String> headEstructAttrXML = new ArrayList<>(Arrays.asList("xmlns:xsi", "xsi:schemaLocation", "xmlns"));
                    ArrayList<String> headEstructAttrXML_IG01 = new ArrayList<>(Arrays.asList("xmlns:xsi", "xsi:schemaLocation","xmlns"));
                    ArrayList<String> headEstructAttrXML_C01_2_3_4 = new ArrayList<>(Arrays.asList("xmlns:ns1"));
                    ArrayList<String> headEstructAttrXML_F01 = new ArrayList<>(Arrays.asList("xmlns"));
                    ArrayList<String> headEstructAttrXML_I01_I02 = new ArrayList<>(Arrays.asList("xmlns:xsi", "xmlns")); //No valida SEPS
                    //ArrayList<String> headEstructAttrXML_I01_I02 = new ArrayList<>(Arrays.asList("xmlns:ns1"));
                    ArrayList<String> headEstructValueXML = null;

                    switch (headCodEstructura) {
                        case "D01":
                            headEstructValueXML = new ArrayList<>(Arrays.asList("http://www.w3.org/2001/XMLSchema-instance", "http://www.seps.gob.ec/depositos deposito/deposito.xsd", "http://www.seps.gob.ec/depositos"));
                            for (int i = 0; i < headEstructAttrXML.size(); i++) {
                                attr = doc.createAttribute(headEstructAttrXML.get(i));
                                attr.setValue(headEstructValueXML.get(i));
                                rootElement.setAttributeNode(attr);
                            }
                            break;

                        case "S01":
                            headEstructValueXML = new ArrayList<>(Arrays.asList("http://www.w3.org/2001/XMLSchema-instance", "http://www.seps.gob.ec/socios socios/socios.xsd", "http://www.seps.gob.ec/socios"));
                            for (int i = 0; i < headEstructAttrXML.size(); i++) {
                                attr = doc.createAttribute(headEstructAttrXML.get(i));
                                attr.setValue(headEstructValueXML.get(i));
                                rootElement.setAttributeNode(attr);
                            }
                            break;
                        case "C01":
                            headEstructValueXML = new ArrayList<>(Arrays.asList("http://www.seps.gob.ec/operaciones"));
                            attr = doc.createAttribute(headEstructAttrXML_C01_2_3_4.get(0));
                            attr.setValue(headEstructValueXML.get(0));
                            rootElement.setAttributeNode(attr);
                            break;
                        case "C02":
                            headEstructValueXML = new ArrayList<>(Arrays.asList("http://www.seps.gob.ec/saldosoperacionales"));
                            attr = doc.createAttribute(headEstructAttrXML_C01_2_3_4.get(0));
                            attr.setValue(headEstructValueXML.get(0));
                            rootElement.setAttributeNode(attr);
                            break;
                        case "C03":
                            headEstructValueXML = new ArrayList<>(Arrays.asList("http://www.seps.gob.ec/garantiasreales"));
                            attr = doc.createAttribute(headEstructAttrXML_C01_2_3_4.get(0));
                            attr.setValue(headEstructValueXML.get(0));
                            rootElement.setAttributeNode(attr);
                            break;
                        case "C04":
                            headEstructValueXML = new ArrayList<>(Arrays.asList("http://www.seps.gob.ec/bienes"));
                            attr = doc.createAttribute(headEstructAttrXML_C01_2_3_4.get(0));
                            attr.setValue(headEstructValueXML.get(0));
                            rootElement.setAttributeNode(attr);
                            break;

                        case "F01":
                            headEstructValueXML = new ArrayList<>(Arrays.asList("http://www.seps.gob.ec/serviciosfinancieros"));
                            attr = doc.createAttribute(headEstructAttrXML_F01.get(0));
                            attr.setValue(headEstructValueXML.get(0));
                            rootElement.setAttributeNode(attr);
                            break;
                        case "L01":
                            headEstructValueXML = new ArrayList<>(Arrays.asList("http://www.w3.org/2001/XMLSchema-instance", "http://www.seps.gob.ec/liquidezEstructural liquidezEstructura.xsd", "http://www.seps.gob.ec/liquidezEstructural"));
                            for (int i = 0; i < headEstructAttrXML.size(); i++) {
                                attr = doc.createAttribute(headEstructAttrXML.get(i));
                                attr.setValue(headEstructValueXML.get(i));
                                rootElement.setAttributeNode(attr);
                            }
                            break;
                        case "I01":
                            headEstructValueXML = new ArrayList<>(Arrays.asList("http://www.w3.org/2001/XMLSchema-instance", "http://www.seps.gob.ec/portafolios"));
                            //headEstructValueXML = new ArrayList<>(Arrays.asList("http://www.seps.gob.ec/portafolios"));
                            for (int i = 0; i < headEstructAttrXML_I01_I02.size(); i++) {
                                attr = doc.createAttribute(headEstructAttrXML_I01_I02.get(i));
                                attr.setValue(headEstructValueXML.get(i));
                                rootElement.setAttributeNode(attr);
                            }
                            break;
                        case "I02":
                            headEstructValueXML = new ArrayList<>(Arrays.asList("http://www.w3.org/2001/XMLSchema-instance", "http://www.seps.gob.ec/saldos"));
                            //headEstructValueXML = new ArrayList<>(Arrays.asList("http://www.seps.gob.ec/saldos"));
                            for (int i = 0; i < headEstructAttrXML_I01_I02.size(); i++) {
                                attr = doc.createAttribute(headEstructAttrXML_I01_I02.get(i));
                                attr.setValue(headEstructValueXML.get(i));
                                rootElement.setAttributeNode(attr);
                            }
                            break;

                        case "B13":
                            headEstructValueXML = new ArrayList<>(Arrays.asList("http://www.w3.org/2001/XMLSchema-instance", "http://www.seps.gob.ec/balances src/balance.xsd", "http://www.seps.gob.ec/balances"));
                            for (int i = 0; i < headEstructAttrXML.size(); i++) {
                                attr = doc.createAttribute(headEstructAttrXML.get(i));
                                attr.setValue(headEstructValueXML.get(i));
                                rootElement.setAttributeNode(attr);
                            }
                            break;
                        case "B11":
                            headEstructValueXML = new ArrayList<>(Arrays.asList("http://www.w3.org/2001/XMLSchema-instance", "http://www.seps.gob.ec/balances src/balance.xsd", "http://www.seps.gob.ec/balances"));
                            for (int i = 0; i < headEstructAttrXML.size(); i++) {
                                attr = doc.createAttribute(headEstructAttrXML.get(i));
                                attr.setValue(headEstructValueXML.get(i));
                                rootElement.setAttributeNode(attr);
                            }
                            break;
                        
                        case "IG01":
                            //headEstructValueXML = new ArrayList<>(Arrays.asList("http://www.w3.org/2001/XMLSchema-instance"));
                            headEstructValueXML = new ArrayList<>(Arrays.asList("http://www.w3.org/2001/XMLSchema-instance","http://www.seps.gob.ec/indicadoresIG01 indicadoresIG01.xsd ","http://www.seps.gob.ec/indicadoresIG01"));
                            for (int i = 0; i < headEstructAttrXML_IG01.size(); i++) {
                                attr = doc.createAttribute(headEstructAttrXML_IG01.get(i));
                                attr.setValue(headEstructValueXML.get(i));
                                rootElement.setAttributeNode(attr);
                            }
                            break;
                    }

                }

                ArrayList<String> cabecera = null;
                // (Tipo) Estruc s,c,d,f -- (CONCEPTO) Estruct: L01
                //  (I01): se debe saber como va el inicio de la tabla: numeroIdentificacionDeposito (Identificacion)
                if (objLinea.contains("Tipo") || objLinea.contains("Concepto") || objLinea.contains("Identificacion") || objLinea.contains("Cuenta	Nombre	Saldo") || objLinea.contains("Numero de deposito")
                    || objLinea.contains("Numero de operacion") || objLinea.contains("Identificador indicador"))  { //Identificador indicador: para IG01 cabecera
                    switch (headCodEstructura) {
                        case "D01":
                            cabecera = new ArrayList<>(Arrays.asList("tipoIdentificacion", "identificacion", "paisNacimiento", "codIdentificacion", "tipoCuenta", "estadoOperacion",
                                    "numCuenta", "provincia", "canton", "parroquia", "saldoInicial", "valorIngresos", "valorEgresos", "saldo",
                                    "interesesPorPagar", "tasaInteres", "numeroIngresos", "numeroEgresos", "fechaTransaccion", "fechaEmision",
                                    "fechaVencimiento", "plazo", "codigoOficina", "tipoDeposito", "estadoCuenta", "fechaCierreCuenta",
                                    "causalCierre", "tarjetaDebito"));
                            break;
                        case "S01":
//                            cabecera = new ArrayList<>(Arrays.asList("tipoIdentificacion", "numeroIdentificacion", "paisNacimiento", "apellidosNombres", "fechaNacimiento",
//                                    "genero", "valorCertifAportacion", "fechaIngreso"));
                            //Actualizacion
                            cabecera = new ArrayList<>(Arrays.asList("tipoIdentificacion", "numeroIdentificacion", "paisNacimiento", "apellidosNombres", "fechaNacimiento",
                                    "genero", "valorCertifAportacion", "fechaIngreso","asambleaGeneral", "fechaRepresentanteAsamblea","directivo","fechaDirectivo"));
                            break;
                        case "C01":
                            // Otro formato
//                            cabecera = new ArrayList<>(Arrays.asList("tipoIdentificacionSujeto","identificacionSujeto","numeroOperacion","valorOperacion","tasaInteresNominal",
//                                            "fechaConcesion","fechaVencimiento","periodicidadPago","oficinaConcesion","garanteCodeudorGarantia","tipoCredito",
//                                            "estadoOperacion","numeroOperacionAnterior","origenOperacion","tipoOperacion","causalVinculacion","actividadEconomicaReceptoraOperacion","geograficoProvincia",
//                                            "geograficoCanton","geograficoParroquia"));
                            //Segmento 3
                            cabecera = new ArrayList<>(Arrays.asList("tipoIdentificacionSujeto", "identificacionSujeto", "numeroOperacion", "valorOperacion", "tasaInteresNominal",
                                    "tasaEfectivaAnual", "fechaConcesion", "fechaVencimiento", "lineaCredito", "periodicidadPago", "frecuenciaRevision", "oficinaConcesion",
                                    "garante", "tipoCredito", "claseCredito", "estadoOperacion", "numeroOperacionAnterior", "origenOperacion", "tipoOperacion", "causalVinculacion",
                                    "destinoFinanciero", "actividadEconomica", "geograficoProvincia", "geograficoCanton", "geograficoParroquia", "totalIngresosSujeto", "totalEgresosSujeto",
                                    "patrimonioSujeto", "actividadSujeto", "nivelEstudios", "tipoVivienda", "nivelEstudioEsperado", "numParticipantesCredito"));
                            break;
                        case "C02":
//                            cabecera = new ArrayList<>(Arrays.asList("tipoIdentificacionSujeto","identificacionSujeto","numeroOperacion","diasMorosidad","calificacion","valorVencer",
//                                            "valorNoDevengaInteres","valorVencido","saldoTotal","formaCancelacion","valorDemandaJudicial","carteraCastigada","fechaCastigo","provisionConstituida",
//                                            "tipoOperacion","valorPrimaDescuento","cuotaCredito","numeroGarantia","tipoGarantia","valorGarantia"));
                            //Segmento 3
                            cabecera = new ArrayList<>(Arrays.asList("tipoIdentificacionSujeto", "identificacionSujeto", "numeroOperacion", "diasMorosidad", "calificacion", "calificacionHomologada",
                                    "tasaInteresEfectiva", "tipoAmortizacion", "valorVencer1_30", "valorVencer31_90", "valorVencer91_180", "valorVencer181_360", "valorVencerMas360", "valorNoDevInteres1_30",
                                    "valorNoDevInteres31_90", "valorNoDevInteres91_180", "valorNoDevInteres181_360", "valorNoDevInteresMas360", "valorVencido1_30", "valorVencido31_90", "valorVencido91_180",
                                    "valorVencido181_360", "valorVencidoMas360", "valorVencido181_270", "valorVencidoMas270", "valorVencido91_270", "valorVencido271_360", "valorVencido361_720", "valorVencidoMas720",
                                    "saldoTotal", "formaCancelacion", "gestionRecuperCarteraVencida", "gastosJudicRecuperCarteraVencida", "interesOrdinario", "interesMora", "valorDemandaJudicial", "carteraCastidada",
                                    "fechaCastigo", "provisionEspecifica", "provisionRequeridaReducida", "provisionConstituida", "tipoOperacion", "objetoFideicomiso", "prima", "cuotaCredito",
                                    "fechaUltimaCuotaCompPagada"));
                            break;
                        case "C03":
                            //Segmento 3
                            cabecera = new ArrayList<>(Arrays.asList("tipoIdentificacionSujeto", "identificacionSujeto", "numeroOperacion", "tipoGaranteCodeudor", "tipoIdentGaranteCodeudor",
                                    "identGaranteCodeudor", "causaElimGaranteCodeudor", "fechElimGaranteCodeudor", "numeroGarantia", "tipoGarantia", "ubicacionGarantiaProvincia",
                                    "ubicacionGarantiaCanton", "ubicacionGarantiaParroquia", "valorAvaluo", "valorAvaluoComercial", "valorAvaluoCatastral", "fechaAvaluo", "numeroRegistroGarantia",
                                    "fechaContabGarantia", "porcentajeCubreGarantia", "estadoRegistro"));
                            break;
                        case "C04":
                            //Segmento 3
                            cabecera = new ArrayList<>(Arrays.asList("numeroOperacion","tipoIdentificacionSujeto","identificacionSujeto","codigoBien","tipoBien","nombreEmisor","fechaEmision",
                                    "fechaVencimiento","valorNominal","fechaContabilizacion","valorEnLibros","valorUltimoAvaluo","valorProvisionConst","fechaRealizacion","valorRealizacion",
                                    "estadoRegistro"));
                            break;


                        case "F01":
                            cabecera = new ArrayList<>(Arrays.asList("tipoServicio", "codigoServicio", "tipoCanal", "valorTarifa", "numeroTransacciones", "ingresoTotal"));
                            break;
                        case "L01":
                            cabecera = new ArrayList<>(Arrays.asList("ConceptoNOXML","DetalleNOXML","codigo","lunes","martes","miercoles","jueves","viernes","promedio"));
                            break;

                        case "I01":
                            //No valida SEPS?
                            cabecera = new ArrayList<>(Arrays.asList("numeroIdentificacionDeposito","tipoIdentificacionEmisorDepositario","identificacionEmisorDepositario",
                                    "fechaEmision","fechaCompra","tipoInstrumento","paisEmisionDepositario","valorNominal","valorCompra","periodicidadPagoCupon",
                                    "clasificacionEmisorDepositario","tipoEmisorDepositario"));
//                            cabecera = new ArrayList<>(Arrays.asList("numeroIdentificacionDeposito","tipoIdentificacionEmisorDepositario","identificacionEmisorDepositario",
//                                    "fechaEmision","tipoInstrumento","paisEmisionDepositario","clasificacionEmisorDepositario","tipoEmisorDepositario"));
                            break;
                        case "I02":
                            //No valida SEPS?
                            cabecera = new ArrayList<>(Arrays.asList("numeroIdentificacionDeposito","tipoIdentificacionEmisorDepositario","identificacionEmisorDepositario",
                                    "fechaEmision","fechaCompra","fechaVencimiento","calificacionRiesgo","calificadoraRiesgo","fechaUltimaCalificacion","cuentaContable",
                                    "valorLibros","estadoTitulo","tasaInteresNominal","montoInteresGenerado","calificacionRiesgoNormativa","provisionConstituida"));
//                            cabecera = new ArrayList<>(Arrays.asList("numeroIdentificacionDeposito","tipoIdentificacionEmisorDepositario","identificacionEmisorDepositario",
//                                    "fechaEmision","fechaCompra","calificacionRiesgo","calificadoraRiesgo","fechaUltimaCalificacion","cuentaContable",
//                                    "valorLibros","estadoTitulo","tasaInteresNominal","montoInteresGenerado","calificacionRiesgoNormativa","provisionConstituida"));
                            break;

                        case "B13":
                            cabecera = new ArrayList<>(Arrays.asList("codigo", "nombre", "total"));
                            break;
                        case "B11":
                            cabecera = new ArrayList<>(Arrays.asList("codigo", "nombre", "total"));
                            break;
                            
                        case "IG01":
                            cabecera = new ArrayList<>(Arrays.asList("codigoIndicador", "grupoIndicador", "nombreIndicador", "valorIndicadorHombre", "valorIndicadorMujer", "valorIndicadorJuridico", "valorIndicadorTotal"));
                            break;

                    }
                    for (int i = 0; i < objLinea.split("\t").length; i++) {
                        System.out.println("-->>: (" + (i + 1) + ")" + objLinea.split("\t")[i]);
                    }
                    for (int i = 0; i < cabecera.size(); i++) {
                        System.out.println("-->>: (" + (i + 1) + ")\t-->>" + cabecera.get(i));
                    }

//                    Thread.sleep(5000);
                    boolean flag = true;

                    //Elementos para B13
                    Element elemB13_elemento = null;
                    Element elemB13_grupo = null;
                    Element elemB13_cuenta = null;
                    Element elemB13_subcuenta = null;

//                    while (obj.hasNextLine())
                    while ((sCadena = in.readLine()) != null) {
                        String lineaTabla = cleanString(sCadena);
                        if (lineaTabla.contains("Impreso por:")) {
                            System.out.println("Validacion (C02): " + lineaTabla);
                            break;
                        }

                        org.w3c.dom.Element elemento = null;
                        if (!headCodEstructura.equalsIgnoreCase("B13") && !headCodEstructura.equalsIgnoreCase("B11")) { //Condicion para != Estructura B13 - B11
                            
                            //Condicion para nsl: en C01,2,3    
                            if (headCodEstructura.equalsIgnoreCase("C01") || 
                                    headCodEstructura.equalsIgnoreCase("C02") || 
                                    headCodEstructura.equalsIgnoreCase("C03") || 
                                    headCodEstructura.equalsIgnoreCase("C04")
//                                    headCodEstructura.equalsIgnoreCase("I01") ||
//                                    headCodEstructura.equalsIgnoreCase("I02")
                                    ) {
                                elemento = doc.createElement("ns1:elemento");
                            } else {
                                elemento = doc.createElement("elemento");
                            }
                            rootElement.appendChild(elemento);
                        }
                        

                        //FOR diferente para cada estructura
                        switch (headCodEstructura) {
                            case "D01":
                                D01 objD01 = new D01();
                                objD01.getRegistros(lineaTabla, doc, cabecera, elemento);
                                break;
                            case "S01":
                                S01 objS01 = new S01();
                                objS01.getRegistros(lineaTabla, doc, cabecera, elemento);
                                break;

                            //Segmento 3
                            case "C01":
                                C01 objC01 = new C01();
                                objC01.getRegistros(lineaTabla, doc, cabecera, elemento);
                                break;
                            case "C02":
                                C02 objC02 = new C02();
                                objC02.getRegistros(lineaTabla, doc, cabecera, elemento);
                                break;
                            case "C03":
                                C03 objC03 = new C03();
                                objC03.getRegistros(lineaTabla, doc, cabecera, elemento);
                                break;
                            case "C04":
                                C04 objC04 = new C04();
                                objC04.getRegistros(lineaTabla, doc, cabecera, elemento);
                                break;

                            case "F01":
                                F01 objf01 = new F01();
                                objf01.getRegistros(lineaTabla, doc, cabecera, elemento);
                                break;
                            case "L01":
                                L01 objl01 = new L01();
                                objl01.getRegistros(lineaTabla, doc, cabecera, elemento);
                                break;

                            case "I01":
                                I01 obji01 = new I01();
                                obji01.getRegistros(lineaTabla, doc, cabecera, elemento);
                                break;
                            case "I02":
                                I02 obji02 = new I02();
                                obji02.getRegistros(lineaTabla, doc, cabecera, elemento);
                                break;
                                
                            case "IG01":
                                IG01 obj = new IG01();
                                obj.getRegistros(lineaTabla, doc, cabecera, elemento);
                                break;

                            case "B13":
                                B13 objB13 = new B13();
                                
                                if (lineaTabla.split("\t")[0].length() == 1) {
                                    elemB13_elemento = doc.createElement("elemento");
                                    rootElement.appendChild(elemB13_elemento);
                                    objB13.getRegistros(lineaTabla, doc, cabecera, elemB13_elemento);
                                }

                                if (lineaTabla.split("\t")[0].length() == 2) {
                                    elemB13_grupo = doc.createElement("grupo");
                                    elemB13_elemento.appendChild(elemB13_grupo);
                                    objB13.getRegistros(lineaTabla, doc, cabecera, elemB13_grupo);
                                }

                                if (lineaTabla.split("\t")[0].length() == 4) {
                                    elemB13_cuenta = doc.createElement("cuenta");
                                    elemB13_grupo.appendChild(elemB13_cuenta);
                                    objB13.getRegistros(lineaTabla, doc, cabecera, elemB13_cuenta);
                                }

                                if (lineaTabla.split("\t")[0].length() == 6) {
                                    elemB13_subcuenta = doc.createElement("subcuenta");
                                    elemB13_cuenta.appendChild(elemB13_subcuenta);
                                    objB13.getRegistros(lineaTabla, doc, cabecera, elemB13_subcuenta);
                                }
                                break;
                            case "B11":
                                B13 objB11 = new B13();
                                
                                if (lineaTabla.split("\t")[0].length() == 1) {
                                    elemB13_elemento = doc.createElement("elemento");
                                    rootElement.appendChild(elemB13_elemento);
                                    objB11.getRegistros(lineaTabla, doc, cabecera, elemB13_elemento);
                                }

                                if (lineaTabla.split("\t")[0].length() == 2) {
                                    elemB13_grupo = doc.createElement("grupo");
                                    elemB13_elemento.appendChild(elemB13_grupo);
                                    objB11.getRegistros(lineaTabla, doc, cabecera, elemB13_grupo);
                                }

                                if (lineaTabla.split("\t")[0].length() == 4) {
                                    elemB13_cuenta = doc.createElement("cuenta");
                                    elemB13_grupo.appendChild(elemB13_cuenta);
                                    objB11.getRegistros(lineaTabla, doc, cabecera, elemB13_cuenta);
                                }

                                if (lineaTabla.split("\t")[0].length() == 6) {
                                    elemB13_subcuenta = doc.createElement("subcuenta");
                                    elemB13_cuenta.appendChild(elemB13_subcuenta);
                                    objB11.getRegistros(lineaTabla, doc, cabecera, elemB13_subcuenta);
                                }
                                break;
                        }

                    }
                    

                }


            }

            //Cerrar archivo leido
            in.close();

            TransformerFactory transfac = TransformerFactory.newInstance();
            transfac.setAttribute("indent-number", new Integer(2));
            Transformer trans = transfac.newTransformer();
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            if (headCodEstructura.equalsIgnoreCase("C01") || 
                    headCodEstructura.equalsIgnoreCase("C02") || 
                    headCodEstructura.equalsIgnoreCase("C03") 
//                    headCodEstructura.equalsIgnoreCase("I01") ||
//                    headCodEstructura.equalsIgnoreCase("I02")
                    ){
                trans.setOutputProperty(OutputKeys.STANDALONE, "yes");
            }
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.setOutputProperty(OutputKeys.CDATA_SECTION_ELEMENTS, "name");

            headFecDatos = headFecDatos.trim();
//            System.out.println("NOMBRE: "+headFecDatos.trim());

            //Comant ============================================================================================
            FileOutputStream fout = new FileOutputStream(path+headCodEstructura+"_"+headCodEntidad+"_"+headFecDatos.replaceAll("/", "-")+".xml");
            BufferedOutputStream bout = new BufferedOutputStream(fout);
            trans.transform(new DOMSource(doc), new StreamResult(new OutputStreamWriter(bout, "utf-8")));
            fout.close();
            

            System.out.println("    Archivo convertido: "+headCodEstructura+"_"+headCodEntidad+"_"+headFecDatos.replaceAll("/", "-")+".xml");
            
            //MD5
            //Create checksum for this file
            File file = new File(path+headCodEstructura+"_"+headCodEntidad+"_"+headFecDatos.replaceAll("/", "-")+".xml");
            //Use MD5 algorithm
            MessageDigest md5Digest = MessageDigest.getInstance("MD5");
            //Get the checksum
            String checksum = getFileChecksum(md5Digest, file);
            //see checksum
            System.out.println("Checksum MD5: "+checksum.toUpperCase());

            FileWriter myWriter = new FileWriter(path+headCodEstructura+"_"+headCodEntidad+"_"+headFecDatos.replaceAll("/", "-")+"-hash.txt");
            myWriter.write(checksum.toUpperCase());
            myWriter.close();
            System.out.println("    Archivo con MD5 creado: "+headCodEstructura+"_"+headCodEntidad+"_"+headFecDatos.replaceAll("/", "-")+"-hash");


            //FILE ZIP
            //Source files  
            String fileName1 = path+headCodEstructura+"_"+headCodEntidad+"_"+headFecDatos.replaceAll("/", "-")+".xml";
            String fileName2 = path+headCodEstructura+"_"+headCodEntidad+"_"+headFecDatos.replaceAll("/", "-")+"-hash.txt"; 
            //Zipped file  
//            String zipFilename = path+headCodEstructura+"_"+headCodEntidad+"_"+headFecDatos.replaceAll("/", "-")+".zip";
//            File zipFile = new File(zipFilename);
//            FileOutputStream fos = new FileOutputStream(zipFile);
//            ZipOutputStream zos = new ZipOutputStream(fos);

            //Zipped file V2
            String zipFilename = path+headCodEstructura+"_"+headCodEntidad+"_"+headFecDatos.replaceAll("/", "-");
            File zipFile = File.createTempFile(zipFilename, ".zip");
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));
            
            zipFile(fileName1, zos);
            zipFile(fileName2, zos);
            zos.close();
            System.out.println("    Archivo zip creado: "+headCodEstructura+"_"+headCodEntidad+"_"+headFecDatos.replaceAll("/", "-")+".zip");

            zipContent = readBytesFromFile(zipFile);
            // Eliminar el archivo temporal
            FileSystemUtils.deleteRecursively(zipFile);
            
            fout.close();
            in.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(GeneradorZip.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(GeneradorZip.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GeneradorZip.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(GeneradorZip.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(GeneradorZip.class.getName()).log(Level.SEVERE, null, ex);
        }
          catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GeneradorZip.class.getName()).log(Level.SEVERE, null, ex);
        }

        return zipContent; 
    }
    
    
    private byte[] readBytesFromFile(File file) throws IOException {
        FileInputStream fileInputStream = null;
        byte[] bytesArray = null;

        try {
            // Crear un FileInputStream para leer el archivo
            fileInputStream = new FileInputStream(file);
            bytesArray = new byte[(int) file.length()];
            // Leer el contenido del archivo en el arreglo de bytes
            fileInputStream.read(bytesArray);
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }

        return bytesArray;
    }

    private static String getFileChecksum(MessageDigest digest, File file) throws IOException {
        //Get file input stream for reading the file content
        FileInputStream fis = new FileInputStream(file);

        //Create byte array to read data in chunks
        byte[] byteArray = new byte[1024];
        int bytesCount = 0;

        //Read file data and update in message digest
        while ((bytesCount = fis.read(byteArray)) != -1) {
            digest.update(byteArray, 0, bytesCount);
        };

        //close the stream; We don't need it now.
        fis.close();

        //Get the hash's bytes
        byte[] bytes = digest.digest();

        //This bytes[] has bytes in decimal format;
        //Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        //return complete hash
        return sb.toString();
    }

    private static void zipFile(String fileName, ZipOutputStream zos) throws IOException {
        final int BUFFER = 1024;
        BufferedInputStream bis = null;
        try {
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis, BUFFER);

            // ZipEntry --- Here file name can be created using the source file  
            ZipEntry zipEntry = new ZipEntry(file.getName());
            zos.putNextEntry(zipEntry);
            byte data[] = new byte[BUFFER];
            int count;
            while ((count = bis.read(data, 0, BUFFER)) != -1) {
                zos.write(data, 0, count);
            }
            // close entry every time  
            zos.closeEntry();
        } finally {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String cleanString(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return texto;
    }

    public static String replaceCharacters(String texto){
        texto = texto.replace("Á", "&Aacute;")
                .replace("É", "&Eacute;")
                .replace("Í", "&Iacute;")
                .replace("Ó", "&Oacute;")
                .replace("Ú", "&Uacute;")
                .replace("Ñ", "&Ntilde;")
                .replace("ñ", "&ntilde;")
                .replace("á", "&aacute;")
                .replace("é", "&eacute;")
                .replace("í", "&iacute;")
                .replace("ó", "&oacute;")
                .replace("ú", "&uacute;")
                .replace("¡", "&iexcl;")
                .replace("ü", "&uuml;")
                .replace("¿", "&iquest;")
                .replace("º", "&ordm;")
                .replace("ª", "&ordf;")
                .replace("Ü", "&Uuml;")
                .replace("¡", "&iexcl;");
        return texto;
    }
}
