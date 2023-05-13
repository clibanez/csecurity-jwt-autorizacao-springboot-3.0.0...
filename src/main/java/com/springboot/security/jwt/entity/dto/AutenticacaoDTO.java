package com.springboot.security.jwt.entity.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AutenticacaoDTO(
        Long id , @NotNull @NotEmpty
        String login, @NotNull @NotEmpty
        String password) {

}
