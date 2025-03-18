package com.asotec.riesgos.exception;
import com.asotec.riesgos.util.Response;
import com.asotec.riesgos.util.Status;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
@RestControllerAdvice
public class RestExceptionHandler {
    /**
     * Maneja las excepciones del controlador
     *
     * @param ex instancia de la excepcion
     * @param request objeto request
     * @return
     */
    @ExceptionHandler(value = { InvalidAttributeException.class})
    protected ResponseEntity<Map<String, Object>> handleException(NoResultException ex, WebRequest request) {
        return Response.get(Status.ERROR.get(), ex.getMessage(), null, HttpStatus.OK);
        //String bodyOfResponse = "This should be application specific";
        /*return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);*/
    }

    protected ResponseEntity<Map<String, Object>> handleException(InvalidAttributeException ex, WebRequest request) {
        return Response.get(Status.ERROR.get(), ex.getMessage(), null, HttpStatus.OK);
    }
}
