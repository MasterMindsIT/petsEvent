package com.ms_mascotas_eventos.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.ms_mascotas_eventos.entities.Participante;
import com.ms_mascotas_eventos.repositories.ParticipanteRepository;
import com.ms_mascotas_eventos.services.interfaces.IParticipanteService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@AllArgsConstructor
@Slf4j
public class ParticipanteServiceImpl implements IParticipanteService{

    private final ParticipanteRepository participanteRepository;

    @Override
    public List<Participante> findAll() {
        log.info("Service Todos los participantes");
        return participanteRepository.findAll();
    }

    @Override
    public Participante findById(Long id) {
        log.info("Service buscar participantes por ID");
        return participanteRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Participante save(Participante participante) {
        return null;
    }

    @Override
    public Participante update(Long id, Participante participante) {
        return null;
    }

    @Override
    public void delete(Long id) {
        
    }

}
