/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcalag.springboot.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author dchavez
 */
@Controller
public class MainController {

    @RequestMapping(value = "/")
    public String inicio() {
        return "inicio";
    }          
    
    @RequestMapping(value = "/about")
    public String about() {        
        return "about";
    }  
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }  
}
