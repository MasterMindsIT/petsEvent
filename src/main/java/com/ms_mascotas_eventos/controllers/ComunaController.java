package com.ms_mascotas_eventos.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms_mascotas_eventos.request.ComunaDTO;
import com.ms_mascotas_eventos.services.interfaces.IComunaService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<ComunaDTO>> getAll() {
        log.info("Controller todas las comunas");
        return ResponseEntity.ok(comunaService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ComunaDTO> getById(@PathVariable long id) {
        log.info("Controller comunas por ID");
        return ResponseEntity.ok(comunaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ComunaDTO> save(@RequestBody ComunaDTO comuna) {
        return ResponseEntity.status(HttpStatus.CREATED).body(comunaService.save(comuna));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ComunaDTO> update(@PathVariable Long id, @RequestBody ComunaDTO comuna) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(comunaService.update(id, comuna));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(comunaService.delete(id));
    }
}
