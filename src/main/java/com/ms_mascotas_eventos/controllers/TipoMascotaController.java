package com.ms_mascotas_eventos.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms_mascotas_eventos.dtos.TipoMascotaDTO;
import com.ms_mascotas_eventos.services.interfaces.ITipoMascotaService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@RestController
@AllArgsConstructor
@RequestMapping("tiposmascotas")
@Slf4j
public class TipoMascotaController {

    private final ITipoMascotaService tipoMascotaService;

    @GetMapping
    public ResponseEntity<List<TipoMascotaDTO>> findAll() {
        log.info("Controller todos las tipos de mascotas");
        return ResponseEntity.ok(tipoMascotaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoMascotaDTO> findById(@PathVariable Long id) {
        log.info("Controller tipos de mascotas por ID");
        return ResponseEntity.ok(tipoMascotaService.findById(id));
    }
}
