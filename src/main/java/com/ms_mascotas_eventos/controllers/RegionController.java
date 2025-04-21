package com.ms_mascotas_eventos.controllers;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms_mascotas_eventos.dtos.request.RegionRequest;
import com.ms_mascotas_eventos.dtos.responses.RegionResponse;
import com.ms_mascotas_eventos.dtos.responses.ResponseWrapperEntity;
import com.ms_mascotas_eventos.dtos.responses.ResponseWrapperList;
import com.ms_mascotas_eventos.dtos.responses.ResponseWrapperMessage;
import com.ms_mascotas_eventos.services.interfaces.IRegionService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@AllArgsConstructor
@RequestMapping("regiones")
@Slf4j
public class RegionController {

    private final IRegionService regionService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        log.info("Controller todas las regiones");
        List<RegionResponse> list = regionService.findAll();
        if(list.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay peliculas para mostrar");
        return ResponseEntity.ok( new ResponseWrapperList<RegionResponse>("Ok", list.size(), list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        log.info("Controller regiones por ID");
        return ResponseEntity.ok(new ResponseWrapperEntity<>("ok", 1,  regionService.findById(id)));
    }
    
    @PostMapping
    public ResponseEntity<?> save(@RequestBody RegionRequest region) {
        log.info("Controller guardar region");
        return ResponseEntity.ok(new ResponseWrapperEntity<>("ok", 1,  regionService.save(region)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody RegionRequest region) {
        log.info("Controller actualizar region por ID");
        return  ResponseEntity.ok(new ResponseWrapperEntity<>("ok", 1,  regionService.update(id, region)));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        log.info("Controller eliminar region por ID");

        return ResponseEntity.ok(new ResponseWrapperMessage<>("ok", 1,  "Se elimino la region con ID: "+id));
    }
}
