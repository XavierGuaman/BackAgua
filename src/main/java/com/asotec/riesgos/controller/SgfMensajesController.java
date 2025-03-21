/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.controller;

import com.asotec.riesgos.entity.GenUsuario;
import com.asotec.riesgos.entity.GenUsuarioId;
import com.asotec.riesgos.entity.SgfMensajes;
import com.asotec.riesgos.entity.SjaControlSecuencia;
import com.asotec.riesgos.entity.SjaNovedad;
import com.asotec.riesgos.entity.SjaNovedadId;
import com.asotec.riesgos.entity.SjaSector;
import com.asotec.riesgos.service.IGenUsuarioService;
import com.asotec.riesgos.service.ISgfMensajesService;
import com.asotec.riesgos.service.ISjaControlSecuenciaIService;
import com.asotec.riesgos.service.ISjaNovedadService;
import com.asotec.riesgos.util.Message;
import com.asotec.riesgos.util.Response;
import com.asotec.riesgos.util.Status;
import com.asotec.riesgos.util.Token;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
@RequestMapping("/mensajes")
public class SgfMensajesController {

    @Autowired
    private IGenUsuarioService srvUsuario;

    @Autowired
    private ISgfMensajesService service;

    @Autowired
    private ISjaControlSecuenciaIService serviceSecuencia;
    
    @Autowired
    private ISjaNovedadService serviceNovedad;

    //crear mensajes
    @RequestMapping(value = "/create",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> crearMensajes(
            @RequestParam(value = "token", required = true) String token,
            @RequestBody List<SgfMensajes> mensajesBody
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

        Map<String, Object> response = new HashMap<>();
        List<SgfMensajes> mensajesGuardados = new ArrayList<>();
        List<SjaNovedad> novedadesGuardadas = new ArrayList<>();

        try {
            // Obtener la secuencia actual
            SjaControlSecuencia ctr = serviceSecuencia.findOne(usr.getId().getCodEmpresa());

            for (SgfMensajes mensaje : mensajesBody) {
                // Incrementar la secuencia para cada mensaje
                long secuenciaMensaje = ctr.getNumSecNovedad() + 1;
                mensaje.setNumMensaje(secuenciaMensaje);

                try {
                    // Guardar el mensaje en la base de datos
                    SgfMensajes nuevoMensaje = service.create(mensaje);
                    mensajesGuardados.add(nuevoMensaje);
                    
                    
                    
                    
                    
                    SjaNovedad novedad = new SjaNovedad();
                    SjaNovedadId novedadId = new SjaNovedadId();
                    novedadId.setCodEmpresa(usr.getId().getCodEmpresa());
                    novedadId.setCodMedidor(mensaje.getCodCuenta()); 
                    novedadId.setFecNovedad(new Date());

                novedad.setId(novedadId);
                novedad.setFecUsrMod(new Date());
                novedad.setCodUsrMod(usr.getCodEmpleado()); 
                novedad.setTxtNovedad( mensaje.getTxtObservacion());
                novedad.setCodUsuario(usr.getId().getCodUsuario());
                novedad.setStsNovedad(true);
                novedad.setIdNovedad(secuenciaMensaje);

                
                serviceNovedad.create(novedad);
                novedadesGuardadas.add(novedad);
                    
                    
                    
                    

                    
                    ctr.setNumSecNovedad(secuenciaMensaje);
                    serviceSecuencia.update(ctr);

                } catch (Exception e) {
                    System.out.println("Mensaje duplicado: " + mensaje);
                    response.put("error", "Mensaje duplicado");
                    return Response.get(Status.ERROR.get(), Message.ERROR.get(), mensaje, HttpStatus.OK);
                }
            }

            response.put("status", Status.OK.get());
            response.put("message", Message.OK.get());
            response.put("mensajesGuardados", mensajesGuardados);
            response.put("novedadesGuardadas", novedadesGuardadas);
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            response.put("status", Status.ERROR.get());
            response.put("message", "Error al procesar los mensajes");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
