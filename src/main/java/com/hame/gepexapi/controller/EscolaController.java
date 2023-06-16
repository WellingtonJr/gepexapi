package com.hame.gepexapi.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hame.gepexapi.dto.EscolaDto;
import com.hame.gepexapi.model.Escola;
import com.hame.gepexapi.service.EscolaService;

@RestController
@RequestMapping("/escola")
public class EscolaController {

    @Autowired
    private EscolaService escolaService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid EscolaDto dto) {
        System.out.println(dto.toString());
        // if (escolaService.existsByNome(dto.getNome())) {
        // return ResponseEntity.status(HttpStatus.CONFLICT).body("Already exists.");
        // }
        var escola = new Escola();
        BeanUtils.copyProperties(dto, escola);

        return ResponseEntity.status(HttpStatus.CREATED).body(escolaService.save(escola));
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(escolaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") UUID id) {

        var escola = escolaService.findById(id);
        if (!escola.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(escola.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") UUID id, @RequestBody @Valid EscolaDto dto) {
        var escola = escolaService.findById(id);
        if (!escola.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(escolaService.update(escola.get(), dto));

    }

    @DeleteMapping
    public ResponseEntity<Object> delete(@PathVariable("id") UUID id) {
        var escola = escolaService.findById(id);
        if (!escola.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found.");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully.");
    }

}
