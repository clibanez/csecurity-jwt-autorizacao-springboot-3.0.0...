package com.springboot.security.jwt.springsecurity_jwt;


import com.springboot.security.jwt.entity.Usuario;
import org.springframework.security.core.context.SecurityContextHolder;


public class UsuarioAutenticadoUtil {

    public static Usuario authenticated() {
        try {
            return (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        catch (Exception e) {
            return null;
        }
    }
}
