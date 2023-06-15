package com.hame.gepexapi.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.hame.gepexapi.dto.EscolaDto;
import com.hame.gepexapi.model.Escola;

public interface EscolaService {

    Escola save(Escola escola);

    List<Escola> findAll();

    Optional<Escola> findById(UUID id);

    Escola update(Escola escola, EscolaDto escolaDto);

    void delete(Escola escola);

    boolean existsByNome(String nome);

}
