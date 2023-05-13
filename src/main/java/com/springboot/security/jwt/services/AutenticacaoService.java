package com.springboot.security.jwt.services;


import com.springboot.security.jwt.entity.Usuario;
import com.springboot.security.jwt.entity.dto.AutenticacaoDTO;
import com.springboot.security.jwt.entity.dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;

import com.springboot.security.jwt.entity.dto.TokenDeResposta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutenticacaoService {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private UsuarioService UsuarioService;
    @Autowired
    private UserDetailsService userDetailsService;


    public TokenDeResposta register(UsuarioDTO userDTO, String role) {
        Usuario user = UsuarioService.postUser(userDTO, role);
        String jwt = jwtService.generateToken(user);
        return TokenDeResposta.builder().token(jwt).build();
    }

    public TokenDeResposta login(AutenticacaoDTO authDTO) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(authDTO.login(), authDTO.password())
        );
        var user = this.userDetailsService.loadUserByUsername(authDTO.login());
        String jwtToken = jwtService.generateToken(user);
        return TokenDeResposta.builder().token(jwtToken).build();
    }


}

