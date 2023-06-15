package com.hame.gepexapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hame.gepexapi.model.Escola;

public interface EscolaRepository extends JpaRepository<Escola, UUID> {

    boolean existsByNome(String nome);

}
