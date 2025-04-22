package com.ms_mascotas_eventos.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms_mascotas_eventos.dtos.request.ComunaRequest;
import com.ms_mascotas_eventos.dtos.responses.ComunaResponse;
import com.ms_mascotas_eventos.dtos.responses.ResponseWrapperEntity;
import com.ms_mascotas_eventos.dtos.responses.ResponseWrapperList;
import com.ms_mascotas_eventos.dtos.responses.ResponseWrapperMessage;
import com.ms_mascotas_eventos.services.interfaces.IComunaService;

import jakarta.validation.Valid;
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
    public ResponseEntity<?> getAll() {
        log.info("Controller todas las comunas");
        List<ComunaResponse> list = comunaService.findAll();
        if(list.isEmpty())
            return ResponseEntity.ok(new ResponseWrapperMessage<>("204", 0,  "No se encontraron datos para mostrar"));
        return ResponseEntity.ok( new ResponseWrapperList<ComunaResponse>("Ok", list.size(), list));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        log.info("Controller comunas por ID");
        return ResponseEntity.ok( new ResponseWrapperEntity<ComunaResponse>("200", 1, comunaService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ComunaRequest comuna) {
        log.info("Controller crear comuna");
        return ResponseEntity.ok(new ResponseWrapperEntity<ComunaResponse>("201", 1,  comunaService.save(comuna)));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@Valid @RequestBody ComunaRequest comuna) {
        log.info("Controller actualizar comunas");
        return ResponseEntity.ok(new ResponseWrapperEntity<ComunaResponse>("202", 1,  comunaService.update(id, comuna)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        log.info("Controller eliminar comunas");
        if(comunaService.delete(id))
        return ResponseEntity.ok(new ResponseWrapperMessage<>("204", 1,  "Se elimino la comuna con ID: "+id));
        return ResponseEntity.ok(new ResponseWrapperMessage<>("204", 0,  "No se elimino la comuna con ID: "+id));

    }
}
