/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.controller;

import com.asotec.riesgos.entity.GenUsuario;
import com.asotec.riesgos.entity.GenUsuarioId;
import com.asotec.riesgos.entity.NovedadesAbonados;
import com.asotec.riesgos.entity.ObtenerInformacion;
import com.asotec.riesgos.entity.SgfMensajes;
import com.asotec.riesgos.entity.SjaControlSecuencia;
import com.asotec.riesgos.entity.SjaNovedad;
import com.asotec.riesgos.entity.SjaSector;
import com.asotec.riesgos.service.IGenUsuarioService;
import com.asotec.riesgos.service.INovedadesAbonadoService;
import com.asotec.riesgos.service.IObtenerInformacionService;
import com.asotec.riesgos.service.ISgfMensajesService;
import com.asotec.riesgos.service.ISjaControlSecuenciaIService;
import com.asotec.riesgos.service.ISjaNovedadService;
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
import org.springframework.transaction.annotation.Transactional;
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
@RequestMapping("/novedadesLector")
public class SjaNovedadController {

    @Autowired
    private ISjaNovedadService service;

    @Autowired
    private IGenUsuarioService srvUsuario;

    @Autowired
    private INovedadesAbonadoService srvNovedades;

    @Autowired
    private IObtenerInformacionService serviceInformacion;

    @Autowired
    private ISjaControlSecuenciaIService serviceSecuencia;

    @Autowired
    private ISgfMensajesService serviceMensajes;

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> getNovedades(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "fecInicial", required = true) String fecInicial,
            @RequestParam(value = "fecFinal", required = true) String fecFinal
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

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaInicialDate = null;
        Date fechaFinalDate = null;
        try {
            fechaInicialDate = sdf.parse(fecInicial);
            fechaFinalDate = sdf.parse(fecFinal);
        } catch (ParseException e) {
            return Response.get(Status.ERROR.get(), "Formato de fecha incorrecto", null, HttpStatus.BAD_REQUEST);
        }

        List<NovedadesAbonados> resp;

        try {
            resp = srvNovedades.obtenerNovedadesAboandos(usr.getId().getCodEmpresa(), fechaInicialDate, fechaFinalDate);
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

    //crear una nueva novedad
    @RequestMapping(value = "/create",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Transactional
    public ResponseEntity<Map<String, Object>> crearNovedad(
            @RequestParam(value = "token", required = true) String token,
            @RequestBody SjaNovedad novedadBody,
            @RequestParam(value = "oficina", required = true) String oficina
    ) {
        token = token.replace(" ", "+"); // Reemplaza espacios en blanco por '+'
        String[] valida = Token.validar(token);
        if (valida[0].equals("0")) { // Token ha expirado
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

        ObtenerInformacion obj = serviceInformacion.getInfoSocio(novedadBody.getId().getCodMedidor(), usr.getId().getCodEmpresa());
        SjaControlSecuencia ctr = serviceSecuencia.findOne(usr.getId().getCodEmpresa());
        long secuenciaMensaje = ctr.getNumSecNovedad() + 1;

        // 1. Guardar SjaNovedad
        SjaNovedad nuevo = novedadBody;
        nuevo.setIdNovedad(secuenciaMensaje);
        try {
            nuevo = service.create(nuevo);
        } catch (Exception e) {
            System.out.println("Novedad duplicada");
            return Response.get(Status.ERROR.get(), "Error al guardar novedad: " + e.getMessage(), nuevo, HttpStatus.OK);
        }

        // 2. Guardar SgfMensajes
        SgfMensajes mensaje = new SgfMensajes();
        mensaje.setNumMensaje(secuenciaMensaje);
        mensaje.setCodSocio(obj.getCodAbonado());
        mensaje.setCodTipoId(obj.getCodTipoId());
        mensaje.setNumId(obj.getNumId());
        mensaje.setNomSocio(obj.getNomAbonado());
        mensaje.setTelCelular(obj.getTxtTelefono());
        mensaje.setDirCorreo(obj.getTxtCorreo());
        mensaje.setCodCuenta(novedadBody.getId().getCodMedidor());
        mensaje.setTxtObservacion(novedadBody.getTxtNovedad());
        mensaje.setValSubtotal1(obj.getValSaldo());
        mensaje.setValTotal(obj.getValSaldo());
        mensaje.setNumDiasMora(obj.getNumMesPendientes());
        mensaje.setTxtOficina(oficina);

        try {
            mensaje = serviceMensajes.create(mensaje);
        } catch (Exception e) {
            System.out.println("Mensaje duplicado");
            throw new RuntimeException("Error al guardar el mensaje: " + e.getMessage());
        }

        // 3. Actualizar la secuencia si todo ha ido bien
        ctr.setNumSecNovedad(secuenciaMensaje);
        serviceSecuencia.update(ctr);

        // 4. Respuesta final si todo fue exitoso
        return Response.get(Status.OK.get(), Message.OK.get(), nuevo, HttpStatus.OK);
    }

    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> actualizarNovedad(
            @RequestParam(value = "token", required = true) String token,
            @RequestBody SjaNovedad novedadBody
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
        //actualizar novedad
        String msg;
        SjaNovedad actualiza = service.update(novedadBody);
        if (actualiza == null) {

            msg = "Error, novedad no actualizada";
            return Response.get(Status.ERROR.get(), msg, null, HttpStatus.OK);
        }
        //actualizar novedad;
        SgfMensajes mensajeBuscado = serviceMensajes.filterByIdNovedad(novedadBody.getIdNovedad());
        mensajeBuscado.setTxtObservacion(novedadBody.getTxtNovedad());
        SgfMensajes actualizaMensaje = serviceMensajes.update(mensajeBuscado);
        if (actualizaMensaje == null) {
            msg = "Error, mensaje no actualizado";
            return Response.get(Status.ERROR.get(), msg, null, HttpStatus.OK);
        }
        return Response.get(Status.OK.get(), Message.OK.get(), actualizaMensaje, HttpStatus.OK);

    }

}
