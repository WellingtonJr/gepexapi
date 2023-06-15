package com.hame.gepexapi.service.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hame.gepexapi.dto.EscolaDto;
import com.hame.gepexapi.model.Escola;
import com.hame.gepexapi.repository.EscolaRepository;
import com.hame.gepexapi.service.EscolaService;

@Service
public class EscolaServiceImpl implements EscolaService {

    @Autowired
    private EscolaRepository escolaRepository;

    @Override
    public Escola save(Escola escola) {
        return escolaRepository.save(escola);
    }

    @Override
    public List<Escola> findAll() {
        return escolaRepository.findAll();
    }

    @Override
    public Optional<Escola> findById(UUID id) {
        return escolaRepository.findById(id);
    }

    @Override
    public Escola update(Escola escola, EscolaDto escolaDto) {
        BeanUtils.copyProperties(escolaDto, escola);
        return escolaRepository.save(escola);
    }

    @Override
    public void delete(Escola escola) {
        escolaRepository.delete(escola);
    }

    @Override
    public boolean existsByNome(String nome) {
        return escolaRepository.existsByNome(nome);
    }

}
