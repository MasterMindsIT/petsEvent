package com.ms_mascotas_eventos.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms_mascotas_eventos.request.ParticipanteDTO;
import com.ms_mascotas_eventos.services.interfaces.IParticipanteService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("participantes")
@AllArgsConstructor
public class ParticipanteController {
private final IParticipanteService participanteService;

    @GetMapping
    public ResponseEntity<List<ParticipanteDTO>> GetAll() {
        log.info("Controller todos los participante");
        return ResponseEntity.ok(participanteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticipanteDTO> getById(@PathVariable long id) {
        log.info("Controller participante por ID");
        return ResponseEntity.ok(participanteService.findById(id));
    }
}
