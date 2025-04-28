/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.controller;

import com.asotec.riesgos.entity.GenUsuario;
import com.asotec.riesgos.entity.GenUsuarioId;
import com.asotec.riesgos.entity.NovedadesLecturas;
import com.asotec.riesgos.service.IGenUsuarioService;
import com.asotec.riesgos.service.INovedadesLecturasService;
import com.asotec.riesgos.util.Message;
import com.asotec.riesgos.util.Response;
import com.asotec.riesgos.util.Status;
import com.asotec.riesgos.util.Token;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rolan
 */
@RestController
@RequestMapping("/reportesNovedades")
public class NovedadesLecturasController {
    
    @Autowired
    private IGenUsuarioService srvUsuario;
    
    @Autowired
    private INovedadesLecturasService service;
    
    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> getNovedadesLeecturas(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "filtros", required = true) List<String> filtros,
            @RequestParam(value = "umbral", required = true) long umbral,
            @RequestParam(value = "fecInicial", required = true) String fecInicial,
            @RequestParam(value = "fecFinal", required = true) String fecFinal,
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
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaInicialDate = null;
        Date fechaFinalDate = null;
        try {
            fechaInicialDate = sdf.parse(fecInicial);
            fechaFinalDate = sdf.parse(fecFinal);
        } catch (ParseException e) {
            return Response.get(Status.ERROR.get(), "Formato de fecha incorrecto", null, HttpStatus.BAD_REQUEST);
        }
        
        
        List<NovedadesLecturas> resp;
        
        try {
            resp = service.obtenerNovedadesLecturas(filtros, umbral, fechaInicialDate, fechaFinalDate, sector, usr.getId().getCodEmpresa());
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
