/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.controller;

import com.asotec.riesgos.entity.GenEmpleado;
import com.asotec.riesgos.entity.GenEmpleadoId;
import com.asotec.riesgos.entity.GenUsuario;
import com.asotec.riesgos.entity.GenUsuarioId;
import com.asotec.riesgos.entity.SjaAbonado;
import com.asotec.riesgos.entity.SjaControl;
import com.asotec.riesgos.entity.SjaControlId;
import com.asotec.riesgos.entity.SjaControlSecuencia;
import com.asotec.riesgos.entity.SjaMedidor;
import com.asotec.riesgos.entity.SrlTipoUsuario;
import com.asotec.riesgos.service.IGenUsuarioService;
import com.asotec.riesgos.service.ISjaControlService;
import com.asotec.riesgos.service.ISjaMedidorService;
import com.asotec.riesgos.service.ISrlTipoUsuarioService;
import com.asotec.riesgos.util.Message;
import com.asotec.riesgos.util.Response;
import com.asotec.riesgos.util.Status;
import com.asotec.riesgos.util.Token;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController

@RequestMapping("/periodo")
public class SjaControlController {

    @Autowired
    private ISjaControlService service;//
    @Autowired
    private IGenUsuarioService srvUsuario;

    @Autowired
    private ISjaMedidorService serviceMedidor;

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> getPeriodo(
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

        SjaControl resp;//
        try {
            resp = service.filterByEmpresa(usr.getId().getCodEmpresa());
        } catch (Exception e) {
            resp = null;
        }

        if (resp == null) {
            return Response.get(Status.ERROR.get(), Message.ERROR.get(), resp, HttpStatus.OK);
        }
        return Response.get(Status.OK.get(), Message.OK.get(), resp, HttpStatus.OK);

    }

    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> crearPeriodo(
            @RequestParam(value = "token", required = true) String token,
            @RequestBody SjaControl periodoBody
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

        //Para agregar un perido
        SjaControl actualiza = service.update(periodoBody);
        serviceMedidor.updateStsLecturaByEmpresa(usr.getId().getCodEmpresa(), "A");

        String msg;
        if (actualiza == null) {

            msg = "Error, control no actualizado";
            return Response.get(Status.ERROR.get(), msg, null, HttpStatus.OK);
        }
        return Response.get(Status.OK.get(), Message.OK.get(), actualiza, HttpStatus.OK);
    }

}
