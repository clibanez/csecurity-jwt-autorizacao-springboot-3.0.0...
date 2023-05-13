package com.springboot.security.jwt.springsecurity_jwt;

import com.springboot.security.jwt.entity.Usuario;
import com.springboot.security.jwt.entity.dto.UsuarioDTO;
import com.springboot.security.jwt.entity.enuns.RoleEnum;
import com.springboot.security.jwt.repository.UsuarioRepository;
import com.springboot.security.jwt.services.AutenticacaoService;
import com.springboot.security.jwt.services.UsuarioService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ContextConfiguration {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(UserDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService UserDetailsService() {
        return nomeDoUsuario->(
                  usuarioRepository.findByUsername(nomeDoUsuario)
        ).orElseThrow(
                () -> new UsernameNotFoundException("Usuario não foi encontrado!.")
        );
    }

}
