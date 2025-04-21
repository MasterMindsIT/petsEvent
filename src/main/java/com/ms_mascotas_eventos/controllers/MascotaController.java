package com.ms_mascotas_eventos.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms_mascotas_eventos.dtos.request.MascotaRequest;
import com.ms_mascotas_eventos.services.interfaces.IMascotaService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("mascotas")
@AllArgsConstructor
public class MascotaController {

    private final IMascotaService mascotaService;

    @GetMapping
    public ResponseEntity<List<MascotaRequest>> GetAll() {
        log.info("Controller getAll");
        return ResponseEntity.ok(mascotaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MascotaRequest> getById(@PathVariable long id) {
        log.info("Controller mascota por ID");
        return ResponseEntity.ok(mascotaService.findById(id));
    }


}
