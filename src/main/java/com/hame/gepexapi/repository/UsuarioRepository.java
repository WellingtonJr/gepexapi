package com.hame.gepexapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hame.gepexapi.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    Usuario findByUsername(String username);

}
