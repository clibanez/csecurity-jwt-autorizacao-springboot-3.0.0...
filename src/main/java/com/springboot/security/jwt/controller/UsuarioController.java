package com.springboot.security.jwt.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @GetMapping
    public String findById() {
        return "Essa rota precisa da autorização de USUARIOS! \nVocê está acessando a rota usuarios. ";
    }
}
