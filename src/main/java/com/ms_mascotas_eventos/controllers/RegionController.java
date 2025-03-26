package com.ms_mascotas_eventos.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms_mascotas_eventos.dtos.RegionDTO;
import com.ms_mascotas_eventos.services.interfaces.IRegionService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/regiones")
public class RegionController {
    private final IRegionService regionService;

    @GetMapping("/{id}")
    public ResponseEntity<RegionDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(regionService.findById(id));
    }
       
}
