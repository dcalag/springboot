/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcalag.springboot.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dchavez
 */
@Service
public class UsuarioTransactionService implements UsuarioTransaction {

    @Autowired
    private UsuarioRepo userRepo;

    @Autowired
    private UserRoleRepo userRoleRepo;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveUser(Usuario usuario) {
        userRepo.save(usuario);

        if (usuario.getRoles() == null) {
            return;
        }

        usuario.loadIdInRoles();
        for (int i = 0; i < usuario.getRoles().size(); i++) {
            userRoleRepo.save(usuario.getRoles().get(i));
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteUser(String id) {
        Usuario usuario;
        usuario = userRepo.findOne(Long.parseLong(id));
        usuario.loadIdInRoles();

        int count = usuario.getRoles().size();
        count--;
        for (int i = count; i >= 0; i--) {
            UserRole role = usuario.getRoles().get(i);
            userRoleRepo.delete(role);
        }
        userRepo.delete(usuario);
    }
}
