/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.controller;

import com.asotec.riesgos.entity.GenUsuario;
import com.asotec.riesgos.entity.GenUsuarioId;
import com.asotec.riesgos.entity.ObtenerLecturas;
import com.asotec.riesgos.entity.nero.LecturasInput;
import com.asotec.riesgos.entity.nero.NeroApiCredential;
import com.asotec.riesgos.exception.InvalidAttributeException;
import com.asotec.riesgos.service.IGenUsuarioService;
import com.asotec.riesgos.service.IObtenerLecturasService;
import com.asotec.riesgos.util.Message;
import com.asotec.riesgos.util.Response;
import com.asotec.riesgos.util.Respuesta;
import com.asotec.riesgos.util.Status;
import com.asotec.riesgos.util.Token;
import com.asotec.riesgos.util.Validation;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import javax.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASOTEC
 */
@RestController
@RequestMapping("/api")
public class NeroApiController {
    
    @Autowired
    private IGenUsuarioService service;
    
    @Autowired
    private IGenUsuarioService srvUsuario;
    
    @Autowired
    private IObtenerLecturasService serviceLecturas;
    
    @RequestMapping(value = "/genToken",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> genToken(
            @RequestBody NeroApiCredential credenciales 
    ) throws InvalidAttributeException {
        //Verificaion de datos de entrada no sean nulos o esten vacios
        if(credenciales.getUsername()== null || credenciales.getUsername().trim().isEmpty()){
            return Response.get(Status.ERROR.get(), "El campo 'username' no puede estar vacio", null, HttpStatus.BAD_REQUEST);
        }
        if(credenciales.getPassword()== null || credenciales.getPassword().trim().isEmpty()){
            return Response.get(Status.ERROR.get(), "El campo 'password' no puede estar vacio", null, HttpStatus.BAD_REQUEST);
        }
        
        //Add MD5.
        String md5password = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(credenciales.getPassword().getBytes(StandardCharsets.UTF_8));
            md5password = DatatypeConverter.printHexBinary(digest);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("ErrorCrypt: " + e);
        }
        //Add MD5.
        
        GenUsuario target = service.findByUsuarioAndPassword(credenciales.getUsername(), credenciales.getPassword());
        

        if (target == null) {
            //return Response.get(Status.ERROR.get(), Message.NO_RESULT.get(), null, HttpStatus.OK);
                return Response.get(Status.ERROR.get(), Message.ERROR.get(), "INVALID_USER", HttpStatus.OK);
        } else if (target.getStsUsuario() != 'A') {
            return Response.get(Status.ERROR.get(), "Inactivo", "DISABLE_USERT", HttpStatus.OK);
        } else if (target.getCodPassword().length() == 32) {//Usando MD5
            if (!target.getCodPassword().equalsIgnoreCase(md5password)){
                return Response.get(Status.ERROR.get(), Message.ERROR.get(), "INVALID_PASSWORD", HttpStatus.OK);
            }
        } else if (target.getCodPassword().length() != 32) {//SIN usar MD5
            if (!target.getCodPassword().equalsIgnoreCase(credenciales.getPassword())){
                return Response.get(Status.ERROR.get(), Message.ERROR.get(), "INVALID_PASSWORD", HttpStatus.OK);
            }
        }
        Respuesta respuesta = Token.generar(target.getId().getCodUsuario());
        //credenciales ok
        return Response.get(Status.OK.get(), Message.OK.get(), respuesta, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/getLecturas",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> getLecturas(
            @RequestBody LecturasInput input
    ) {
        //Verificaion de datos de entrada no sean nulos o esten vacios
        if(input.getToken()== null || input.getToken().trim().isEmpty()){
            return Response.get(Status.ERROR.get(), "El campo 'token' no puede estar vacio", null, HttpStatus.BAD_REQUEST);
        }
        /*
        if(String.valueOf(input.getSector()).trim().length()<0){
            return Response.get(Status.ERROR.get(), "El campo 'sector' no puede estar vacio", null, HttpStatus.BAD_REQUEST);
        }
        if(String.valueOf(input.getMes()).trim().length()<0){
            return Response.get(Status.ERROR.get(), "El campo 'mes' no puede estar vacio", null, HttpStatus.BAD_REQUEST);
        }
        if(String.valueOf(input.getAnio()).trim().length()<3){
            return Response.get(Status.ERROR.get(), "El campo 'anio' tiene que contener un valor valido", null, HttpStatus.BAD_REQUEST);
        }
        */
        String token=input.getToken();
        long anio=input.getAnio();
        long mes=input.getMes();
        long sector=input.getSector();
        
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
    
}
