package com.ms_mascotas_eventos.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.ms_mascotas_eventos.mappers.ParticipanteMapper;
import com.ms_mascotas_eventos.repositories.ParticipanteRepository;
import com.ms_mascotas_eventos.request.ParticipanteDTO;
import com.ms_mascotas_eventos.services.interfaces.IParticipanteService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@AllArgsConstructor
@Slf4j
public class ParticipanteServiceImpl implements IParticipanteService{

    private final ParticipanteRepository participanteRepository;

    @Override
    public List<ParticipanteDTO> findAll() {
        log.info("Service Todos los participantes");
        return participanteRepository.findAll()
                                    .stream()
                                    .map(ParticipanteMapper::toParticipanteDTO)
                                    .toList();
    }

    @Override
    public ParticipanteDTO findById(Long id) {
        log.info("Service buscar participantes por ID");
        return ParticipanteMapper.toParticipanteDTO(participanteRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @Override
    public ParticipanteDTO save(ParticipanteDTO participante) {
        return null;
    }

    @Override
    public ParticipanteDTO update(Long id, ParticipanteDTO participante) {
        return null;
    }

    @Override
    public void delete(Long id) {
        
    }

}
