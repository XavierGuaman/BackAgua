/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.entity.SgfMensajes;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author rolan
 */
@Service
public class EmailService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private ServletContext servletContext;
    
    
    private static final int PAGE_SIZE = 10;  
    private int pageNumber = 0;

    @Transactional
    @Scheduled(fixedDelay = 60000) // Ejecutar cada 60 segundos
    public void checkAndSendEmails() {
        List<SgfMensajes> mensajes = entityManager.createQuery(
                "SELECT m FROM SgfMensajes m WHERE m.stsEnviado = false", SgfMensajes.class)
                //.setFirstResult(pageNumber * PAGE_SIZE)  // Establecer la página y el tamaño del lote
                //.setMaxResults(PAGE_SIZE)  // Número de mensajes a traer en este ciclo
                .getResultList();

        if (!mensajes.isEmpty()) {
            for (SgfMensajes mensaje : mensajes) {
                String alerta = crearAlerta(mensaje);

                try {

                    String plantilla = cargarPlantilla("email-template.html");


                    String contenido = plantilla
                            .replace("{{nombreJunta}}", mensaje.getTxtOficina()) // Nombre de la Junta de Agua
                            .replace("{{nombre}}", mensaje.getNomSocio()) // Nombre del socio
                            .replace("{{mensaje}}", mensaje.getTxtObservacion()) // Mensaje personalizado
                            .replace("{{alerta}}", alerta);
                    MimeMessage mimeMessage = mailSender.createMimeMessage();
                    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

                    helper.setTo(mensaje.getDirCorreo());
                    helper.setSubject("NOTIFICACIÓN DE " + mensaje.getTxtOficina()); 
                    helper.setText(contenido, true);
                    mailSender.send(mimeMessage);
                    mensaje.setStsEnviado(true);
                    entityManager.merge(mensaje);

                } catch (MessagingException e) {
                    throw new RuntimeException("Error al enviar el correo", e);
                }
                 pageNumber++;
            }
        }
    }

    private String cargarPlantilla(String ruta) {
        try {
            String realPath = servletContext.getRealPath("/" + ruta);
            if (realPath == null) {
                throw new RuntimeException("Ruta no válida o archivo no encontrado: " + ruta);
            }
            byte[] bytes = FileCopyUtils.copyToByteArray(new java.io.File(realPath));
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("Error al cargar la plantilla: " + ruta, e);
        }
    }
    
     private String crearAlerta(SgfMensajes mensaje) {
        String mensajeObservacion = mensaje.getTxtObservacion().toLowerCase();
        String alerta = "";
        
        if (mensajeObservacion.contains("corte")) {
            alerta = "<div class='alert alert-danger'>"
                    + "<div class='alert-title'>⚠️ ¡ATENCIÓN! El servicio ha sido suspendido</div>"
                    + "<p><strong>Importante:</strong> Su servicio de agua ha sido suspendido por falta de pago.</p>"
                    + "</div>";
        } else if (mensajeObservacion.contains("deuda") || mensajeObservacion.contains("debe")) {
            alerta = "<div class='alert alert-warning'>"
                    + "<div class='alert-title'>💰 ¡AVISO IMPORTANTE! Pagos pendientes</div>"
                    + "<p><strong>Aviso:</strong> Tiene pagos pendientes. Por favor, regularice su deuda.</p>"
                    + "</div>";
        } else {
            alerta = "<div class='alert alert-success'>"
                    + "<div class='alert-title'>✅ Información importante</div>"
                    + "<p>Este es un aviso informativo de su cuenta.</p>"
                    + "</div>";
        }

        return alerta;
    }

}
