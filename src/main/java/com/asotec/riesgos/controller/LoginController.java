/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.controller;

import com.asotec.riesgos.dao.IGenUsuarioDao;
import com.asotec.riesgos.entity.GenUsuario;
import com.asotec.riesgos.entity.GenUsuarioId;
import com.asotec.riesgos.exception.InvalidAttributeException;
import com.asotec.riesgos.service.IGenUsuarioService;
import com.asotec.riesgos.util.Message;
import com.asotec.riesgos.util.Response;
import com.asotec.riesgos.util.Respuesta;
import com.asotec.riesgos.util.Status;
import com.asotec.riesgos.util.Token;
import com.asotec.riesgos.util.Validation;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author josesanchez
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    /**
     * Resuelve la dependencia
     */
    @Autowired
    private IGenUsuarioService service;

    /**
     * Genera token con caducidad
     *
     * @param usuario
     * @param password
     * @return
     * @throws InvalidAttributeException
     */
    @RequestMapping(value = "/auth",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> getUsuario(
            @RequestParam(value = "usuario", required = true) String usuario,
            @RequestParam(value = "password", required = true) String password
    ) throws InvalidAttributeException {
        Validation.checkNullEmpty("usuario", usuario);
        Validation.checkNullEmpty("password", password);
        
        
        
        //Add MD5.
        String md5password = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(password.getBytes(StandardCharsets.UTF_8));
            md5password = DatatypeConverter.printHexBinary(digest);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("ErrorCrypt: " + e);
        }
        //Add MD5.
        
        GenUsuario target = service.findByUsuarioAndPassword(usuario, password);
        

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
            if (!target.getCodPassword().equalsIgnoreCase(password)){
                return Response.get(Status.ERROR.get(), Message.ERROR.get(), "INVALID_PASSWORD", HttpStatus.OK);
            }
        }
        Respuesta respuesta = Token.generar(target.getId().getCodUsuario());
        //credenciales ok
        return Response.get(Status.OK.get(), Message.OK.get(), respuesta, HttpStatus.OK);
    }

    @RequestMapping(value = "/auth2", //App Movil
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> getSessionApp(
            @RequestParam(value = "usuario", required = true) String usuario,
            @RequestParam(value = "password", required = true) String password
            
    ) throws InvalidAttributeException {
//        Validation.checkNullEmpty("usuario", usuario);
//        Validation.checkNullEmpty("password", password);
        if (usuario == null || usuario.isEmpty()) {
            return Response.get(Status.ERROR.get(), Message.ERROR.get(), "EMPTY_USERNAME", HttpStatus.OK);
        } else if (password == null || password.isEmpty()) {
            return Response.get(Status.ERROR.get(), Message.ERROR.get(), "EMPTY_PASSWORD", HttpStatus.OK);
        }
        GenUsuarioId id = new GenUsuarioId();
        id.setCodEmpresa(1);
        id.setCodUsuario(usuario);
        GenUsuario target = new GenUsuario();
        target.setId(id);
        target = service.findOneByAssociation(target);
        
        //Add MD5.
        String md5password = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(password.getBytes(StandardCharsets.UTF_8));
            md5password = DatatypeConverter.printHexBinary(digest);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("ErrorCrypt: " + e);
        }
        //Add MD5.

        if (target == null) {
            //return Response.get(Status.ERROR.get(), Message.NO_RESULT.get(), null, HttpStatus.OK);
                return Response.get(Status.ERROR.get(), Message.ERROR.get(), "INVALID_USER", HttpStatus.OK);
        } else if (target.getStsUsuario() != 'A') {
            return Response.get(Status.ERROR.get(), "Inactivo", "DISABLE_USER", HttpStatus.OK);
        } else if (target.getCodPassword().length() == 32) {//Usando MD5
            if (!target.getCodPassword().equalsIgnoreCase(md5password)){
                return Response.get(Status.ERROR.get(), Message.ERROR.get(), "INVALID_PASSWORD", HttpStatus.OK);
            }
        } else if (target.getCodPassword().length() != 32) {//SIN usar MD5
            if (!target.getCodPassword().equalsIgnoreCase(password)){
                return Response.get(Status.ERROR.get(), Message.ERROR.get(), "INVALID_PASSWORD", HttpStatus.OK);
            }
        }
        Respuesta respuesta = Token.generar(target.getId().getCodUsuario());
        //credenciales ok
        return Response.get(Status.OK.get(), Message.OK.get(), respuesta, HttpStatus.OK);
    }
    /**
     * Obtiene las credenciales del socio
     *
     * @param token sesion
     * @return registro
     */
    @RequestMapping(value = "/mostrar",
            method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> getCredencial(
            @RequestParam(value = "token", required = true) String token
    ) {
        //System.out.println(token);
        token = token.replace(" ", "+"); //a los espacios en blanco colocar +
        String[] valida = Token.validar(token);
        if (valida[0].equals("0")) { //token ha expirado
            return Response.get(Status.ERROR.get(), valida[1], null, HttpStatus.OK);
        }
        String usuario = valida[0];
        GenUsuario repuesta = service.findById(1, usuario); //cod_empresa = 1

        return Response.get(Status.OK.get(), Message.OK.get(), repuesta, HttpStatus.OK);
    }

}
