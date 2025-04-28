/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.controller;

import com.asotec.riesgos.entity.EmpleadosUpdateRequest;
import com.asotec.riesgos.entity.GenEmpleado;
import com.asotec.riesgos.entity.GenEmpleadoId;
import com.asotec.riesgos.entity.GenUsuario;
import com.asotec.riesgos.entity.GenUsuarioId;
import com.asotec.riesgos.entity.SjaControlSecuencia;
import com.asotec.riesgos.entity.UsuarioEmpleado;

import com.asotec.riesgos.service.IGenEmpleadoService;
import com.asotec.riesgos.service.IGenUsuarioService;
import com.asotec.riesgos.service.ISjaControlSecuenciaIService;
import com.asotec.riesgos.service.IUsuarioEmpleadoService;

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
 * @author rolan
 */
@RestController
@RequestMapping("/empleados")
public class GenEmpleadoController {
    
    @Autowired
    private IGenEmpleadoService service;
    @Autowired
    private IGenUsuarioService srvUsuario;
    @Autowired
    private ISjaControlSecuenciaIService srvCtrSecuencia;
    @Autowired
    private IUsuarioEmpleadoService serviceUsuarioEmpleado;
    
    
    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> getEjmpleados(
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
        List<UsuarioEmpleado> resp;
        try {
            resp = serviceUsuarioEmpleado.filterByEmpresa(usr.getId().getCodEmpresa());
            System.out.println("resp:"+resp);
        } catch (Exception e) {
            System.out.println("error: "+e);
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
    public ResponseEntity<Map<String, Object>> crearEmpleado(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password,
            @RequestBody GenEmpleado empleadoBody
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
        //para aggregar el empleado
        SjaControlSecuencia ctr = srvCtrSecuencia.findOne(empleadoBody.getId().getCodEmpresa());
        GenEmpleadoId id = new GenEmpleadoId();
        long numSecuencuaEmpleado = ctr.getNumSecEmpleado()+1;
        id.setCodEmpleado(numSecuencuaEmpleado);
        id.setCodEmpresa(usr.getId().getCodEmpresa());
        GenEmpleado nuevo = empleadoBody;
        nuevo.setId(id);
        
        try {
            nuevo = service.create(nuevo);
        } catch (Exception e) {
            System.out.println("Empleado duplicado"+ e);
            return Response.get(Status.ERROR.get(), Message.ERROR.get(), nuevo, HttpStatus.OK);
        }
        ctr.setNumSecEmpleado(numSecuencuaEmpleado);
        srvCtrSecuencia.update(ctr);
        
        //para agregar el usuario
        GenUsuarioId idUsuario = new GenUsuarioId();
        idUsuario.setCodEmpresa(usr.getId().getCodEmpresa());
        idUsuario.setCodUsuario(username);
        //long numSecUsuario = ctr.getNumSecUsuario()+1;
        GenUsuario user = new GenUsuario();
        user.setId(idUsuario);
        user.setCodEmpleado(numSecuencuaEmpleado);
        user.setCodPassword(password);
        user.setNomUsuario(empleadoBody.getNomApeEmpleado());
        user.setStsUsuario(empleadoBody.getStsEmpleado());
        
        try {
            user = srvUsuario.create(user);
        } catch (Exception e) {
            System.out.println("Usuario duplicado"+e);
            return Response.get(Status.ERROR.get(), Message.ERROR.get(), user, HttpStatus.OK);
        }
        //ctr.setNumSecUsuario(numSecUsuario);
        //srvCtrSecuencia.update(ctr);
        return Response.get(Status.OK.get(), Message.OK.get(), nuevo, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> updateEmpleado(
            @RequestParam(value = "token", required = true) String token,
            @RequestBody EmpleadosUpdateRequest request
    ) {

        GenEmpleado empleadoBody = request.getEmpleado();
        GenUsuario usuarioBody = request.getUsuario();

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
        //Para hacer update a un empleado  
        System.out.println("Esto se trae de empleado: " + empleadoBody.getNomApeEmpleado());
        System.out.println("Esto se trae de usuario: " + usuarioBody.getId().getCodUsuario());
        GenEmpleado actualiza = service.update(empleadoBody);
        String msg;
        if (actualiza == null) {
            msg = "Error, empleado no actualizado";
            return Response.get(Status.ERROR.get(), msg, actualiza, HttpStatus.OK);
        }
        //Para hacer update a un usuario
        GenUsuario actualizaUsuario = srvUsuario.update(usuarioBody);

        if (actualizaUsuario == null) {
            msg = "Error, usuario no actualizado";
            return Response.get(Status.ERROR.get(), msg, actualizaUsuario, HttpStatus.OK);
        }
        return Response.get(Status.OK.get(), Message.OK.get(), actualizaUsuario, HttpStatus.OK);

    }
    
    
    
    @RequestMapping(value = "/lectores",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> getLectores(
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
        List<GenEmpleado> resp;
        try {
            resp = service.filterByLectores(usr.getId().getCodEmpresa());
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
