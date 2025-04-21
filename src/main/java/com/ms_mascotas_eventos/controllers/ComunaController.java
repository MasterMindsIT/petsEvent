package com.ms_mascotas_eventos.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms_mascotas_eventos.dtos.request.ComunaRequest;
import com.ms_mascotas_eventos.services.interfaces.IComunaService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@Slf4j
@RequestMapping("comunas")
@AllArgsConstructor
public class ComunaController {
    private final IComunaService comunaService;

    @GetMapping
    public ResponseEntity<List<ComunaRequest>> getAll() {
        log.info("Controller todas las comunas");
        return null;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ComunaRequest> getById(@PathVariable long id) {
        log.info("Controller comunas por ID");
        return null;
    }

    @PostMapping
    public ResponseEntity<ComunaRequest> save(@RequestBody ComunaRequest comuna) {
        return null;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ComunaRequest> update(@PathVariable Long id, @RequestBody ComunaRequest comuna) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        return null;
    }
}
