/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.resources;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.google.common.base.Preconditions;
import java.io.IOException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 *
 * @author josesanchez
 */
@Configuration
@EnableTransactionManagement
@PropertySource({"classpath:persistence.properties"}) //tipo de ambiente
@ComponentScan({"com.asotec"})
//@EnableJpaRepositories(basePackages = "ruta.dao")
public class PersistenceConfig {
    /**
     * Variables del sistema
     */
    @Autowired
    private Environment env;

    /**
     * Constructor
     */
    public PersistenceConfig() {
        super();
    }

    /**
     * Configura el objeto entity manager
     *
     * @return Object
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean myEmf = new LocalContainerEntityManagerFactoryBean();
        myEmf.setDataSource(dataSource());
        myEmf.setPackagesToScan(new String[]{"com.asotec.riesgos.entity"}); //ruta pojos
        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        myEmf.setJpaVendorAdapter(vendorAdapter);
        myEmf.setJpaProperties(additionalProperties());
        return myEmf;
    }

    /**
     * Define los parametros de la conexion con la base
     *
     * @return data source
     */
    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource myDataSource = new DriverManagerDataSource();
        myDataSource.setDriverClassName(Preconditions.checkNotNull(env.getProperty("jdbc.driverClassName")));
        myDataSource.setUrl(Preconditions.checkNotNull(env.getProperty("jdbc.url")));
        myDataSource.setUsername(Preconditions.checkNotNull(env.getProperty("jdbc.user")));
        myDataSource.setPassword(Preconditions.checkNotNull(env.getProperty("jdbc.pass")));
        return myDataSource;
    }

    /**
     * Asigna la instancia del entity manager para las transacciones
     *
     * @return Object
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        final JpaTransactionManager myTransactionManager = new JpaTransactionManager();
        myTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject()); //asigna myEmf
        return myTransactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    /**
     * Parametros adicionales de hibernate
     *
     * @return Object
     */
    final Properties additionalProperties() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        hibernateProperties.setProperty("hibernate.cache.use_second_level_cache", env.getProperty("hibernate.cache.use_second_level_cache"));
        hibernateProperties.setProperty("hibernate.cache.use_query_cache", env.getProperty("hibernate.cache.use_query_cache"));
        hibernateProperties.setProperty("hibernate.jdbc.batch_size", env.getProperty("hibernate.jdbc.batch_size"));
        //hibernateProperties.setProperty("hibernate.jdbc.time_zone", env.getProperty("hibernate.jdbc.time_zone"));
        return hibernateProperties;
    }

    /**
     * Establece el tamanio maximo de archivos para la carga
     *
     * @return Object
     */
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver getCommonsMultipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(20971520); // 20MB
        multipartResolver.setMaxInMemorySize(1048576);	// 1MB
        return multipartResolver;
    }
    
     /**
     * Carga configuración
     */
    private void getConfig() {
        try {
            org.springframework.core.io.Resource resource = new ClassPathResource("/configuracion.properties");
            Properties props = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException ex) {
            String msg = "Error en archivo config: " + ex.getMessage();
           //Logger.getLogger(MensajeController.class.getName()).log(Level.WARNING, msg);
        }
    }
}
