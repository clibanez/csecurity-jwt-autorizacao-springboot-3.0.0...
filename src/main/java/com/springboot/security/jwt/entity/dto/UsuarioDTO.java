package com.springboot.security.jwt.entity.dto;


import com.springboot.security.jwt.entity.Usuario;
import com.springboot.security.jwt.entity.enuns.RoleEnum;
import com.springboot.security.jwt.springsecurity_jwt.GeneralUtilies;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;



public record UsuarioDTO(
                         @NotNull @NotEmpty String username,
                         @NotNull @NotEmpty String password,

                         @NotNull @NotEmpty RoleEnum role

){
    public Usuario addAdmin(UsuarioDTO userDTO) {
        return new Usuario(null,
                this.username,
                GeneralUtilies.encode(this.password),
                RoleEnum.ROLE_ADMINISTRADOR);
    }

    public Usuario addTreasurer(UsuarioDTO userDTO) {
        return new Usuario(null,
                this.username,
                GeneralUtilies.encode(this.password),
                RoleEnum.ROLE_USUARIO);
    }
}
