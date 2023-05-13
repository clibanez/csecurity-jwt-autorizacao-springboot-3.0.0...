package com.springboot.security.jwt.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @GetMapping
    public String findById() {
        return "Essa rota não precisa de autorização! \nVocê está acessando a rota de clientes. ";
    }

}
