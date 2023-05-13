package com.springboot.security.jwt.controller;


import com.springboot.security.jwt.entity.dto.AutenticacaoDTO;
import com.springboot.security.jwt.entity.dto.UsuarioDTO;
import com.springboot.security.jwt.services.AutenticacaoService;
import com.springboot.security.jwt.springsecurity_jwt.GeneralUtilies;
import lombok.RequiredArgsConstructor;

import com.springboot.security.jwt.entity.dto.TokenDeResposta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

@Controller
@RequestMapping("/autenticacao")
@RequiredArgsConstructor
public class AutenticacaoController extends TokenDeResposta {

    @Autowired
    private AutenticacaoService authService;


    @PostMapping("/registrar/{role}")
    public ResponseEntity<TokenDeResposta> register(@RequestBody UsuarioDTO userDTO, @PathVariable String role) {
        URI uri = GeneralUtilies.toUri("/register/{role}");
        return ResponseEntity.created(uri).body(authService.register(userDTO, role));
    }


    @PostMapping("/login")
    public ResponseEntity<TokenDeResposta> login(@RequestBody AutenticacaoDTO authDTO) {
        return ResponseEntity.ok().body(authService.login(authDTO));
    }
}