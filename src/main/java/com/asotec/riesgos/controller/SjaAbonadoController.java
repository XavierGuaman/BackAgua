/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.controller;

import com.asotec.riesgos.entity.GenUsuario;
import com.asotec.riesgos.entity.GenUsuarioId;
import com.asotec.riesgos.entity.ObtenerAbonados;
import com.asotec.riesgos.entity.SjaAbonado;
import com.asotec.riesgos.entity.SjaAbonadoId;
import com.asotec.riesgos.entity.SjaMedidor;
import com.asotec.riesgos.service.IGenUsuarioService;
import com.asotec.riesgos.service.IObtenerAbonadosService;
import com.asotec.riesgos.service.ISjaAbonadoService;
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

@RequestMapping("/abonados")
public class SjaAbonadoController {
    
    @Autowired
    private IGenUsuarioService srvUsuario;
    @Autowired
    private ISjaAbonadoService service;
    
    @Autowired
    private IObtenerAbonadosService serviceAbonado;
    
    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> getAbonados(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "sector", required = true) long sector
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
        
        List<ObtenerAbonados> resp;
        
        try {
            resp = serviceAbonado.filterBySector(usr.getId().getCodEmpresa(),sector);
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
    public ResponseEntity<Map<String, Object>> crearMedidores(
            @RequestParam(value = "token", required = true) String token,
            @RequestBody List<SjaAbonado> abonadosBody
    ){
        
    
        if (abonadosBody == null || abonadosBody.isEmpty()) {
            System.out.println("La lista de abonados esta vacia");
        }
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
        
        List<SjaAbonado> abonadosParaInsertar = new ArrayList<>();
        List<SjaAbonado> abonadosParaActualizar = new ArrayList<>();
        
        System.out.println("Tamaño de lista de abonados:  "+abonadosBody.size());
        
        
        for (SjaAbonado abonado:abonadosBody){
            
            SjaAbonadoId id = abonado.getId();
            System.out.println("Procesa: "+id.getCodAbonado());
            SjaAbonado abonadoBuscado = service.filterByEmpresaAndAbonado(id.getCodEmpresa(), id.getCodAbonado());
            if(abonadoBuscado == null){
                abonadosParaInsertar.add(abonado);
            }else{
                abonadosParaActualizar.add(abonado);
            }
        }
        if(!abonadosParaInsertar.isEmpty()){
            service.createBatch(abonadosParaInsertar);
        }
        if(!abonadosParaActualizar.isEmpty()){
            service.updateBatch(abonadosParaActualizar);
        }
        return Response.get(Status.OK.get(), Message.OK.get(), "Abonados procesados correctamente", HttpStatus.OK);
    }
    
    @RequestMapping(
            value = "/movil",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> getAbonadosMovil(
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
        
        List<SjaAbonado> resp;
        
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
