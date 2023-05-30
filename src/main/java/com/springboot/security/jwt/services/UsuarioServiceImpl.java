package com.springboot.security.jwt.services;

import com.springboot.security.jwt.entity.Usuario;
import com.springboot.security.jwt.entity.dto.UsuarioDTO;

import org.springframework.data.domain.Page;


public interface UsuarioServiceImpl {
    Page<Usuario> getUser(int page, int size);
    Usuario postUser(UsuarioDTO userDTO, String role);
    Usuario getUser(String username);

    Usuario findById();
}