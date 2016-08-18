/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcalag.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dchavez
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @RequestMapping(value = "/pageUsuarios")
    public String pageUsuarios() {
        return "usuarios";        
    }
    
    @RequestMapping(value = "/pageUsuario")
    public String pageNuevoUsuario() {
        return "usuario"; 
    }

}
