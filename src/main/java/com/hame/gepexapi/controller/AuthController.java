package com.hame.gepexapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hame.gepexapi.dto.LoginDto;
import com.hame.gepexapi.model.Usuario;
import com.hame.gepexapi.service.TokenService;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public String login(@RequestBody LoginDto login) {

        var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(login.getUsername(),
                login.getPassword());

        var authenticate = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        var usuario = (Usuario) authenticate.getPrincipal();

        return tokenService.gerarToken(usuario);

    }

}
