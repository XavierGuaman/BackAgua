/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.controller;

import com.asotec.riesgos.entity.GenEmpleado;
import com.asotec.riesgos.entity.GenUsuario;
import com.asotec.riesgos.entity.GenUsuarioId;
import com.asotec.riesgos.entity.LecturaUnificado;
import com.asotec.riesgos.entity.ObtenerLecturas;
import com.asotec.riesgos.entity.SjaControl;
import com.asotec.riesgos.entity.SjaControlSecuencia;
import com.asotec.riesgos.entity.SjaLectura;
import com.asotec.riesgos.entity.SjaLecturaId;
import com.asotec.riesgos.entity.SjaMedidor;
import com.asotec.riesgos.service.IGenUsuarioService;
import com.asotec.riesgos.service.IObtenerLecturasService;
import com.asotec.riesgos.service.ISjaControlSecuenciaIService;
import com.asotec.riesgos.service.ISjaControlService;
import com.asotec.riesgos.service.ISjaLecturaService;
import com.asotec.riesgos.service.ISjaMedidorService;
import com.asotec.riesgos.util.Message;
import com.asotec.riesgos.util.Response;
import com.asotec.riesgos.util.Status;
import com.asotec.riesgos.util.Token;
import java.util.List;
import java.util.Map;
import java.nio.file.Files;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ASOTEC
 */
@RestController
@RequestMapping("/lecturas")
public class SjaLecturaController {

    private static final String pathImgsRecoleccion = "C:/webserver/www/file-recoleccion";

    @Autowired
    private ISjaLecturaService service;
    @Autowired
    private IGenUsuarioService srvUsuario;
    @Autowired
    private ISjaControlSecuenciaIService srvCtrSecuencia;

    @Autowired
    private ISjaMedidorService serviceMedidor;

    @Autowired
    private ISjaControlService servicePeriodo;

    @Autowired
    private IObtenerLecturasService serviceLecturas;

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> getLecturas(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "sector", required = true) long sector,
            @RequestParam(value = "mes", required = true) long mes,
            @RequestParam(value = "anio", required = true) long anio
    ) {

        
        token = token.replace(" ", "+"); //a los espacios en blanco colocar +
        String[] valida = Token.validar(token);
        if (valida[0].equals("0")) { //token ha expirado
            return Response.get(Status.ERROR.get(), valida[1], null, HttpStatus.OK);
        }
        String usuario = valida[0];
        GenUsuario target = new GenUsuario();
        GenUsuarioId genUsuarioId = new GenUsuarioId();
        genUsuarioId.setCodUsuario(usuario);
        target.setId(genUsuarioId);
        GenUsuario usr = srvUsuario.findByUsername(target);
        if (usr == null) {
            return Response.get(Status.ERROR.get(), "No existe el usuario", null, HttpStatus.OK);
        }
        List<ObtenerLecturas> resp;
        try {
            System.out.println("mes: " + mes);
            System.out.println("anio: " + anio);
            System.out.println("sector: " + sector);
            resp = serviceLecturas.filterByPeriodoAndSector(usr.getId().getCodEmpresa(), sector, mes, anio);
        } catch (Exception e) {
            resp = null;
        }

        if (resp == null) {
            return Response.get(Status.ERROR.get(), Message.ERROR.get(), resp, HttpStatus.OK);
        } else if (resp.isEmpty()) {
            return Response.get(Status.NORESULT.get(), Message.NO_DATA.get(), resp, HttpStatus.OK);
        }
        return Response.get(Status.OK.get(), Message.OK.get(), resp, HttpStatus.OK);

    }

    @RequestMapping(value = "/create",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> crearLectura(
            @RequestParam(value = "token", required = true) String token,
            @RequestBody SjaLectura lecturaBody
    ) {

        token = token.replace(" ", "+"); //a los espacios en blanco colocar +
        String[] valida = Token.validar(token);
        if (valida[0].equals("0")) { //token ha expirado
            return Response.get(Status.ERROR.get(), valida[1], null, HttpStatus.OK);
        }
        String usuario = valida[0];
        GenUsuario target = new GenUsuario();
        GenUsuarioId genUsuarioId = new GenUsuarioId();
        genUsuarioId.setCodUsuario(usuario);
        target.setId(genUsuarioId);
        GenUsuario usr = srvUsuario.findByUsername(target);
        if (usr == null) {
            return Response.get(Status.ERROR.get(), "No existe el usuario", null, HttpStatus.OK);
        }

        GenUsuario user = srvUsuario.findByCodEmpleado(usr.getId().getCodEmpresa(), lecturaBody.getCodUsrMod());
        String codUsuario = user.getId().getCodUsuario();

        System.out.println("Esto es el username: " + codUsuario);
        SjaControl periodo = servicePeriodo.filterByEmpresa(usr.getId().getCodEmpresa());

        SjaMedidor medidor = serviceMedidor.filterByEmpresaAndCodMedidor(usr.getId().getCodEmpresa(), lecturaBody.getId().getCodMedidor());

        //para agregar la lectura
        SjaLectura nuevo = lecturaBody;
        nuevo.setCodUsuario(codUsuario);
        nuevo.setCodPeriodoMes(periodo.getCodMes());
        nuevo.setCodPeriodoAnio(periodo.getCodAnio());

        if (medidor != null) {
            nuevo.setCodSector(medidor.getCodSector());
            medidor.setStsLectura("L");
            medidor.setPeriodo(periodo.getCodMes());

            SjaMedidor actualiza = serviceMedidor.update(medidor);
            if (actualiza == null) {
                return Response.get(Status.ERROR.get(), "Error, medidor no actualizado", null, HttpStatus.OK);
            }
        }
        try {
            nuevo = service.create(nuevo);
        } catch (Exception e) {
            System.out.println("Lectura duplicada" + e);
            return Response.get(Status.ERROR.get(), Message.ERROR.get(), nuevo, HttpStatus.OK);
        }
        return Response.get(Status.OK.get(), Message.OK.get(), nuevo, HttpStatus.OK);

    }

    @RequestMapping(value = "/upload",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> crearLoteLectura(
            @RequestParam(value = "token", required = true) String token,
            @RequestBody  List<LecturaUnificado> lecturas
    ) {
        if(lecturas.isEmpty()){ 
            return Response.get(Status.OK.get(), Message.NO_DATA.get(), null, HttpStatus.NO_CONTENT);
        }
        Logger logger = Logger.getLogger(this.getClass().getName());

        token = token.replace(" ", "+"); //a los espacios en blanco colocar +
        String[] valida = Token.validar(token);
        if (valida[0].equals("0")) { //token ha expirado
            return Response.get(Status.ERROR.get(), valida[1], null, HttpStatus.OK);
        }
        String usuario = valida[0];
        GenUsuario target = new GenUsuario();
        GenUsuarioId genUsuarioId = new GenUsuarioId();
        genUsuarioId.setCodUsuario(usuario);
        target.setId(genUsuarioId);
        GenUsuario usr = srvUsuario.findByUsername(target);
        if (usr == null) {
            return Response.get(Status.ERROR.get(), "No existe el usuario", null, HttpStatus.OK);
        }
        
        System.out.println("Tamaño de lista: " + lecturas.size());
        int count = 0;
        String urlFoto;
        SjaControl periodo = servicePeriodo.filterByEmpresa(usr.getId().getCodEmpresa());
        for (LecturaUnificado lecturasconFoto : lecturas) {
            SjaLectura lectura = lecturasconFoto.getLectura();
            System.out.println("Lect fecha: "+lectura.getId().getFecLectura());
            
            byte[] imagen = lecturasconFoto.getFoto();
            if (imagen != null && imagen.length > 0 ) {
                System.out.println("\n Imegen que llega: "+imagen.toString());
                urlFoto = saveImage(imagen, usr, lectura.getId().getFecLectura(), lectura.getId().getCodMedidor());
            } else {
                urlFoto = "";
            }

            SjaLecturaId id = new SjaLecturaId();
            SjaLecturaId idPorLectura = lectura.getId();
            id.setCodEmpresa(usr.getId().getCodEmpresa());
            id.setCodMedidor(idPorLectura.getCodMedidor());
            id.setFecLectura(idPorLectura.getFecLectura());
            SjaLectura nuevo = lectura;
            nuevo.setId(id);
            nuevo.setCodUsrMod(usr.getCodEmpleado());
            nuevo.setCodUsuario(usr.getId().getCodUsuario());
            nuevo.setCodPeriodoMes(periodo.getCodMes());
            nuevo.setCodPeriodoAnio(periodo.getCodAnio());
            nuevo.setUrlFoto(urlFoto);
            SjaMedidor medidor = serviceMedidor.filterByEmpresaAndCodMedidor(usr.getId().getCodEmpresa(), idPorLectura.getCodMedidor());
            if (medidor != null) {
                
                SjaMedidor actualizar = medidor;
                if (actualizar.getTxtLatitud().isEmpty() && actualizar.getTxtLongitud().isEmpty()) {
                    actualizar.setTxtLongitud(lectura.getTxtLongitudLector());
                    actualizar.setTxtLatitud(lectura.getTxtLatitudLector());
                }
               
                nuevo.setCodSector(medidor.getCodSector());
                actualizar.setStsLectura("L");                
                actualizar.setPeriodo(periodo.getCodMes());
                
                SjaMedidor actualiza = serviceMedidor.update(actualizar);
                if (actualiza == null) {
                    return Response.get(Status.ERROR.get(), "Error, medidor no actualizado", null, HttpStatus.OK);
                }
            }

            try {
                nuevo = service.save(nuevo);
                count++;
            } catch (Exception e) {
                System.out.println("Recaudacion duplicado");
                logger.info("\n\n\nEl error es: "+e+"\n\n\n");
                //return Response.get(Status.ERROR.get(), Message.ERROR.get(), nuevo, HttpStatus.OK);
            }
        }
        logger.info("\n*****************************************************************\nLOG:  Total de lecturas procesadas: " + count+ "\nEl usuario es: "+usr.getId().getCodUsuario()+"\n************************************************************");
        System.out.println("tam lista procesada: "+count);
        return Response.get(Status.OK.get(), Message.OK.get(), "", HttpStatus.OK);
    }

   public String saveImage(byte[] file, GenUsuario usr, Date fecLectura, String codMedidor) {
    try {
        if (file == null || file.length == 0) {
            throw new IllegalArgumentException("El archivo está vacío o no tiene contenido.");
        }
        
        long codEmpresa = usr.getId().getCodEmpresa();
        SjaControl periodo = servicePeriodo.filterByEmpresa(usr.getId().getCodEmpresa());
        
        // Formato de fecha con hora para evitar duplicados en el nombre del archivo
        String formattedDate = new SimpleDateFormat("yyyyMMdd_HHmmss").format(fecLectura);
        System.out.println("Fecha de foto es: "+formattedDate);
        // Construcción del path de la imagen
        String pathImg = "/" + codEmpresa + "/" + periodo.getCodAnio() + "/"
                + periodo.getCodMes() + "/" + codMedidor + formattedDate + ".png";
        
        String fullPath = pathImgsRecoleccion + pathImg;
        
        // Crear los directorios necesarios si no existen
        Files.createDirectories(Paths.get(fullPath).getParent());
        
        // Guardar el archivo en el sistema de archivos
        File destinationFile = new File(fullPath);
        try (FileOutputStream fos = new FileOutputStream(destinationFile)) {
            fos.write(file); // Escribir los bytes en el archivo
        }
        
        return pathImg;
    } catch (IOException e) {
        System.out.println("Error al guardar la imagen: " + e.getMessage());
        return "";
    }
}


    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> updateLectura(
            @RequestParam(value = "token", required = true) String token,
            @RequestBody SjaLectura lecturaBody
    ) {
        token = token.replace(" ", "+"); //a los espacios en blanco colocar +
        String[] valida = Token.validar(token);
        if (valida[0].equals("0")) { //token ha expirado
            return Response.get(Status.ERROR.get(), valida[1], null, HttpStatus.OK);
        }
        String usuario = valida[0];
        GenUsuario target = new GenUsuario();
        GenUsuarioId genUsuarioId = new GenUsuarioId();
        genUsuarioId.setCodUsuario(usuario);
        target.setId(genUsuarioId);
        GenUsuario usr = srvUsuario.findByUsername(target);
        if (usr == null) {
            return Response.get(Status.ERROR.get(), "No existe el usuario", null, HttpStatus.OK);
        }
        SjaLectura actualiza = service.update(lecturaBody);
        SjaMedidor medidor = serviceMedidor.filterByEmpresaAndCodMedidor(usr.getId().getCodEmpresa(), lecturaBody.getId().getCodMedidor());
        String msg;
        if (actualiza == null) {
            msg = "Error, control no actualizado";
            return Response.get(Status.ERROR.get(), msg, null, HttpStatus.OK);
        } else {
            if ("C".equals(lecturaBody.getStsLectura())) {
                SjaLectura lectura = service.filterLecturaByPeriodo(lecturaBody.getId().getCodEmpresa(), lecturaBody.getId().getCodMedidor(), lecturaBody.getCodPeriodoMes(), lecturaBody.getCodPeriodoAnio());
                if (lectura == null) {
                    medidor.setPeriodo(0);
                    medidor.setStsLectura("A");
                    serviceMedidor.update(medidor);
                } else {
                    System.out.println("Aún hay otra lectura hecha por el mismo medidors");
                }

            }
        }
        return Response.get(Status.OK.get(), Message.OK.get(), actualiza, HttpStatus.OK);

    }

}
