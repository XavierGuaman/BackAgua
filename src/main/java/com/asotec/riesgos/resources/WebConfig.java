/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.resources;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author josesanchez
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.asotec.riesgos.controller"})
public class WebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    /**
     * Constructor
     */
    public WebConfig() {
        super();
    }
    /**
     * Constructor parametrizado
     *
     * @param applicationContext objeto contexto
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(final ApplicationContext applicationContext)
            throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void addCorsMappings(final CorsRegistry registry) {
        super.addCorsMappings(registry);
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET, POST, OPTIONS")
                .allowedHeaders("Origin")
                .exposedHeaders("Access-Control-Allow-Origin")
                .allowCredentials(false)
                .maxAge(60);
        System.out.println("ejecuta cors riesgos");
    }
}
