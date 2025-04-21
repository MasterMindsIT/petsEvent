package com.ms_mascotas_eventos.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms_mascotas_eventos.dtos.request.EventoRequest;
import com.ms_mascotas_eventos.services.interfaces.IEventoService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@Slf4j
@RequestMapping("eventos")
@AllArgsConstructor
public class EventoController {

    private final IEventoService eventoService;

    @GetMapping
    public ResponseEntity<List<EventoRequest>> GetAll() {
        log.info("Controller todos evento");
        return ResponseEntity.ok(eventoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoRequest> getById(@PathVariable long id) {
        log.info("Controller evento por ID");
        return ResponseEntity.ok(eventoService.findById(id));
    }
    
    

}
