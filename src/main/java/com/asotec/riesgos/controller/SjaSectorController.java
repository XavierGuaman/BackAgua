/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.controller;

import com.asotec.riesgos.entity.GenUsuario;
import com.asotec.riesgos.entity.GenUsuarioId;
import com.asotec.riesgos.entity.SjaControlSecuencia;
import com.asotec.riesgos.entity.SjaSector;
import com.asotec.riesgos.entity.SjaSectorId;
import com.asotec.riesgos.service.IGenUsuarioService;
import com.asotec.riesgos.service.ISjaControlSecuenciaIService;
import com.asotec.riesgos.service.ISjaSectorService;
import com.asotec.riesgos.util.Message;
import com.asotec.riesgos.util.Response;
import com.asotec.riesgos.util.Status;
import com.asotec.riesgos.util.Token;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author XAVIER
 */
@RestController
@RequestMapping("/sectores")
public class SjaSectorController {

    @Autowired
    private ISjaSectorService service;
    @Autowired
    private IGenUsuarioService srvUsuario;
    @Autowired
    private ISjaControlSecuenciaIService serviceSecuencia;

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> getEjmpleados(
            @RequestParam(value = "token", required = true) String token
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
        List<SjaSector> resp;
        //SjaSector sector ;
        try {
           
            resp = service.filterAll(usr.getId().getCodEmpresa());
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
    
    // CREAR UN NUEVO SECTOR
    @RequestMapping(value = "/create",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> crearSocio(
            @RequestParam(value = "token", required = true) String token,
            @RequestBody SjaSector sectorBody
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
        //Agrega nuevo sector     
        SjaControlSecuencia ctr = serviceSecuencia.findOne(usr.getId().getCodEmpresa());
        long secuenciaSector = ctr.getNumSecSector() + 1;
        
        SjaSectorId id = new SjaSectorId();
        id.setCodEmpresa(usr.getId().getCodEmpresa());
        id.setCodCanton(101);
        id.setCodProvincia(1);
        id.setCodSector(secuenciaSector);
        SjaSector nuevo = sectorBody; 
        nuevo.setId(id);

        try {
            nuevo = service.create(nuevo);
        } catch (Exception e) {
            System.out.println("Socio duplicado");
            return Response.get(Status.ERROR.get(), Message.ERROR.get(), nuevo, HttpStatus.OK);
        }
        ctr.setNumSecSector(secuenciaSector);
        serviceSecuencia.update(ctr);
        return Response.get(Status.OK.get(), Message.OK.get(), nuevo, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> actualizarSector(
            @RequestParam(value = "token", required = true) String token,
            @RequestBody SjaSector sectorBody
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
        String msg;
        SjaSector actualiza = service.update(sectorBody);
        if (actualiza == null) {
            
            msg = "Error, socio no actualizado";
            return Response.get(Status.ERROR.get(), msg, null, HttpStatus.OK);
        }
        return Response.get(Status.OK.get(), Message.OK.get(), actualiza, HttpStatus.OK);
    
    }
     @RequestMapping(value = "/movil",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> getSectorByEmpleado(
            @RequestParam(value = "token", required = true) String token
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
        List<SjaSector> resp;
        //SjaSector sector ;
         System.out.println("sE VA HACER LA BUSQEUDA CON ESTOS DATOS");
         System.out.println("codEmpresa: "+usr.getId().getCodEmpresa());
         System.out.println("codEmpleado: "+usr.getCodEmpleado());
        try {
           
            resp = service.filterByEmpleadoMovil(usr.getId().getCodEmpresa(), usr.getCodEmpleado());
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
    
}
