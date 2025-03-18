/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.exception;

import com.asotec.riesgos.util.Response;
import com.asotec.riesgos.util.Status;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/**
 * Clase para el manejo de excepciones del controlador
 *
 * @author edwin
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja la excepcion de carga de archivos (commons-fileupload)
     *
     * @param e instancia de excepcion
     * @return mensaje de error
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<Map<String, Object>> handleError(MaxUploadSizeExceededException e) {
        return Response.get(Status.ERROR.get(), e.getCause().getMessage(), null, HttpStatus.OK);
    }

}
