/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcalag.springboot.controller;

import com.dcalag.springboot.model.BaseWebModel;
import com.dcalag.springboot.model.UsuarioTransaction;
import com.dcalag.springboot.model.UserRole;
import com.dcalag.springboot.model.UserRoleRepo;
import com.dcalag.springboot.model.Usuario;
import com.dcalag.springboot.model.UsuarioRepo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author daniel
 */
@RestController
@RequestMapping("/admin")
public class AdminApiController {

    @Autowired
    private UsuarioRepo userRepo;

    @Autowired
    private UsuarioTransaction userTrans;

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public List<Usuario> listaAlertas() {
        List<Usuario> list = new ArrayList<>();
        Iterator<Usuario> iter = userRepo.findAll().iterator();

        while (iter.hasNext()) {
            list.add(iter.next());
        }

        return list;
    }
    
    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public Usuario usuarioGet(@PathVariable("id") String id, HttpServletResponse response) {
        Usuario usuario = new Usuario();
        
        try {
            Long idLong = Long.parseLong(id);
            usuario = userRepo.findOne(idLong);
        } catch (Exception e) {
            response.setStatus(500);
            usuario.setError(e.getMessage());
            return (usuario);
        }

        response.setStatus(200);
        return usuario;
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public BaseWebModel usuarioPost(@RequestBody Usuario usuario, HttpServletResponse response) {
        BaseWebModel respuesta = new BaseWebModel();

        try {
            userTrans.saveUser(usuario);
        } catch (Exception e) {
            response.setStatus(500);
            respuesta.setError(e.getMessage());
            return (respuesta);
        }

        response.setStatus(200);
        return respuesta;
    }
    
     @RequestMapping(value = "/usuario/{id}", method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public BaseWebModel usuarioPut(@PathVariable("id") String id, 
            @RequestBody Usuario usuario, HttpServletResponse response) {
        BaseWebModel respuesta = new BaseWebModel();

        try {
            usuario.setId(Long.parseLong(id));
            userTrans.saveUser(usuario);
        } catch (Exception e) {
            response.setStatus(500);
            respuesta.setError(e.getMessage());
            return (respuesta);
        }

        response.setStatus(200);
        return respuesta;
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public BaseWebModel usuarioDelete(@PathVariable("id") String id, HttpServletResponse response) {
        BaseWebModel respuesta = new BaseWebModel();
        try {
            userTrans.deleteUser(id);
        } catch (Exception e) {
            response.setStatus(500);
            respuesta.setError(e.getMessage());
            return respuesta;
        }

        response.setStatus(200);
        return respuesta;
    }
}
