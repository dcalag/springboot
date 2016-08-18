/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcalag.springboot.model;

/**
 * Clase que se puede usar como base de los modelos que son recuperados/almacenados
 * en la bd.
 * @author dchavez
 */
public class BaseWebModel {
    // la propiedad 'error' no se recupera ni se almacena en la base de datos, 
    // sólo se usa para enviar posibles errores al front-end (browser).
    private String error = "";
    private String mensaje = "";
 
    /**
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
