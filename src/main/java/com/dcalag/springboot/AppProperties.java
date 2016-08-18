/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcalag.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Clase para leer propiedades del archivo application.properties. Se trata de
 * propiedades personalizadas para el proyecto.
 *
 * @author daniel
 */
@Component
public class AppProperties {
    
    @Value("${spring.datasource.driverClassName}")
    private String databaseDriverClassName;

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.username}")
    private String databaseUsername;

    @Value("${spring.datasource.password}")
    private String databasePassword;
    
    @Value("${server.contextPath}")
    private String contextPath;

      /**
     * @return the databaseDriverClassName
     */
    public String getDatabaseDriverClassName() {
        return databaseDriverClassName;
    }

    /**
     * @return the datasourceUrl
     */
    public String getDatasourceUrl() {
        return datasourceUrl;
    }

    /**
     * @return the databaseUsername
     */
    public String getDatabaseUsername() {
        return databaseUsername;
    }

    /**
     * @return the databasePassword
     */
    public String getDatabasePassword() {
        return databasePassword;
    }

    /**
     * @return the contextPath
     */
    public String getContextPath() {
        return contextPath;
    }

    /**
     * @param contextPath the contextPath to set
     */
    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

}
