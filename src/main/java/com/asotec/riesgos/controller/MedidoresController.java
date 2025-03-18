/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.controller;

import com.asotec.riesgos.entity.GenUsuario;
import com.asotec.riesgos.entity.GenUsuarioId;
import com.asotec.riesgos.entity.ObtenerMedidores;
import com.asotec.riesgos.entity.SjaMedidor;
import com.asotec.riesgos.entity.SjaMedidorId;
import com.asotec.riesgos.service.IGenUsuarioService;
import com.asotec.riesgos.service.IObtenerMedidoresService;
import com.asotec.riesgos.service.ISjaMedidorService;
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
 * @author ASOTEC
 */
@RestController

@RequestMapping("/medidores")
public class MedidoresController {

    @Autowired
    private IGenUsuarioService srvUsuario;
    @Autowired
    private ISjaMedidorService service;
    
    @Autowired
    private IObtenerMedidoresService serviceMedidores;

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> getAbonados(
            @RequestParam(value = "token", required = true) String token,
            @RequestParam(value = "sector", required = true) long sector
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

        List<ObtenerMedidores> resp;
        try {
            resp = serviceMedidores.filterBySector(usr.getId().getCodEmpresa(),sector);
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
            @RequestBody List<SjaMedidor> medidoresBody
    ) {
        if (medidoresBody == null || medidoresBody.isEmpty()) {
            System.out.println("La lista esta vacia");
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
        System.out.println("Tamaño de lista de medidores: "+medidoresBody.size());
        
        service.updateStsMedidorByEmpresa(usr.getId().getCodEmpresa(), "C");
        List<SjaMedidor> medidoresParaInsertar = new ArrayList<>();
        List<SjaMedidor> medidoresParaActualizar = new ArrayList<>();

        for (SjaMedidor medidor : medidoresBody) {
            SjaMedidorId id = medidor.getId();
            SjaMedidor medidorBuscado = service.filterByEmpresaAndCodMedidor(id.getCodEmpresa(), id.getCodMedidor());

            if (medidorBuscado == null) {
                medidoresParaInsertar.add(medidor);
            } else {
                SjaMedidor medidorActualizar = medidor;
                medidorActualizar.setTxtLongitud(medidorBuscado.getTxtLongitud());
                medidorActualizar.setTxtLatitud(medidorBuscado.getTxtLatitud());
                medidorActualizar.setPeriodo(medidorBuscado.getPeriodo());
                medidorActualizar.setStsLectura(medidorBuscado.getStsLectura());
                medidoresParaActualizar.add(medidorActualizar);
            }
        }

        // Crear y actualizar en batch
        if (!medidoresParaInsertar.isEmpty()) {
            service.createBatch(medidoresParaInsertar);
        }

        if (!medidoresParaActualizar.isEmpty()) {
            service.updateBatch(medidoresParaActualizar);
        }

        return Response.get(Status.OK.get(), Message.OK.get(), "Medidores procesados correctamente", HttpStatus.OK);
    }

    @RequestMapping(value = "/prueba",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> pruebaMedidores(
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

        SjaMedidor nuevo = service.filterByEmpresaAndCodMedidor(1, "00390744");
        if (nuevo != null) {
            System.out.println("Información de medidor " + nuevo);
        } else {
            System.out.println("Medidor no encontrado");
        }
        System.out.println("");

        String msg = "";
        return Response.get(Status.OK.get(), Message.OK.get(), msg, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/movil",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> getMedidoresMovil(
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

        List<SjaMedidor> resp;
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
