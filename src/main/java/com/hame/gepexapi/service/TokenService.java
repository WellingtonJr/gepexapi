package com.hame.gepexapi.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.hame.gepexapi.model.Usuario;

@Service
public class TokenService {

    public String gerarToken(Usuario usuario) {
        return JWT.create()
                .withIssuer("Escolas")
                .withSubject(usuario.getUsername())
                .withClaim("id", usuario.getId().toString())
                .withExpiresAt(Date.from(LocalDateTime.now()
                        .plusMinutes(30)
                        .toInstant(ZoneOffset.of("-03:00"))))
                .sign(Algorithm.HMAC256("secreta"));

    }

    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256("secreta"))
                .withIssuer("Escolas")
                .build().verify(token).getSubject();
    }

}
