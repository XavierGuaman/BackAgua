/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.resources;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author josesanchez
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/admin").hasAuthority("ROLE_ADMIN") // (1)
                .antMatchers("/consultas").hasAnyAuthority("ROLE_ADMIN", "ROLE_CONSULTAS") // (2)
                .antMatchers("/ahorros").hasAnyAuthority("ROLE_ADMIN", "ROLE_CONSULTAS") // (2)
                .antMatchers("/socio").hasAnyAuthority("ROLE_ADMIN", "ROLE_CONSULTAS") // (2)
                .anyRequest().authenticated() // (3)
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

}
