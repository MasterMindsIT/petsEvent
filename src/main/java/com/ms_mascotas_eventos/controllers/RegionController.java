package com.ms_mascotas_eventos.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms_mascotas_eventos.dtos.RegionDTO;
import com.ms_mascotas_eventos.services.interfaces.IRegionService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@RequestMapping("regiones")
@Slf4j
public class RegionController {
    private final IRegionService regionService;

    @GetMapping
    public ResponseEntity<List<RegionDTO>> findAll() {
        log.info("Controller todas las regiones");
        return ResponseEntity.ok(regionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegionDTO> findById(@PathVariable Long id) {
        log.info("Controller regiones por ID");
        return ResponseEntity.ok(regionService.findById(id));
    }
       
}
