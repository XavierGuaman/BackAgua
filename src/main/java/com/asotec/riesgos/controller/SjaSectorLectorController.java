/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.controller;

import com.asotec.riesgos.entity.AsignacionSectores;
import com.asotec.riesgos.entity.GenUsuario;
import com.asotec.riesgos.entity.GenUsuarioId;
import com.asotec.riesgos.entity.SjaControlSecuencia;
import com.asotec.riesgos.entity.SjaSectorLector;
import com.asotec.riesgos.entity.SjaSectorLectorId;
import com.asotec.riesgos.service.IAsignacionSectoresService;
import com.asotec.riesgos.service.IGenUsuarioService;
import com.asotec.riesgos.service.ISjaControlSecuenciaIService;
import com.asotec.riesgos.service.ISjaSectorLectorService;
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
 * @author USER
 */
@RestController
@RequestMapping("/asignacion")
public class SjaSectorLectorController {
    
    @Autowired
    private ISjaSectorLectorService service;//
    
    @Autowired
    private IGenUsuarioService srvUsuario;
    @Autowired
    private ISjaControlSecuenciaIService srvSecuencia;
    
    @Autowired
    private IAsignacionSectoresService serviceAsignacion;
    
    
    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> getAsignacion(
            @RequestParam(value = "token", required = true) String token
    ){
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
        
        List<AsignacionSectores> resp;//
        try {
            resp = serviceAsignacion.filterByEmpresa(usr.getId().getCodEmpresa());
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
    public ResponseEntity<Map<String, Object>> crearAsignacion(
            @RequestParam(value = "token", required = true) String token,
            
            @RequestBody SjaSectorLector asignacionBody
    ){
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
        
        SjaControlSecuencia ctr = srvSecuencia.findOne(usr.getId().getCodEmpresa());
        long secAsignacion = ctr.getNumSecAsignacion() + 1;
        SjaSectorLectorId id = new SjaSectorLectorId();
        id.setCodAsignacion(secAsignacion);
        id.setCodEmpresa(usr.getId().getCodEmpresa());
        
        //para agregar una nueva asignacion
        SjaSectorLector asignacion = asignacionBody;
        asignacion.setId(id);
        
        try {
            asignacion = service.create(asignacion);
        } catch (Exception e) {
            System.out.println("Asignacion duplicada"+e);
            return Response.get(Status.ERROR.get(), Message.ERROR.get(), asignacion, HttpStatus.OK);
        }
        ctr.setNumSecAsignacion(secAsignacion);
        srvSecuencia.update(ctr);
        return Response.get(Status.OK.get(), Message.OK.get(), asignacion, HttpStatus.OK);
    }
    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> updateAsignacion(
            @RequestParam(value = "token", required = true) String token,
            
            @RequestBody SjaSectorLector asignacionBody
    ){
    
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
        SjaSectorLector actualiza = service.update(asignacionBody);
        if (actualiza == null) {
            
            msg = "Error, asignacion no actualizado";
            return Response.get(Status.ERROR.get(), msg, null, HttpStatus.OK);
        }
        return Response.get(Status.OK.get(), Message.OK.get(), actualiza, HttpStatus.OK);
    
    
    }
    
    
    
    
}
