package com.springboot.security.jwt.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/administradores")
public class AdministradorController {


    @GetMapping
    public String findById() {
        return "Essa rota precisa da autorização de ADMINISTRADOR! \nVocê está acessando a rota administrador. ";
    }
}
