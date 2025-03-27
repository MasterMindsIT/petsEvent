package com.ms_mascotas_eventos.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.ms_mascotas_eventos.dtos.EventoDTO;
import com.ms_mascotas_eventos.mappers.EventoMapper;
import com.ms_mascotas_eventos.repositories.EventoRepository;
import com.ms_mascotas_eventos.services.interfaces.IEventoService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@AllArgsConstructor
@Slf4j
public class EventoServiceImpl implements IEventoService{

    private final EventoRepository eventoRepository;

    @Override
    public List<EventoDTO> findAll() {
        log.info("Service Todos los Eventos");
        return eventoRepository.findAll()
                                .stream()
                                .map(EventoMapper::toEventoDTO)
                                .toList();
    }

    @Override
    public EventoDTO findById(Long id) {
        log.info("Service los eventos por ID");
        return EventoMapper.toEventoDTO(eventoRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @Override
    public EventoDTO save(EventoDTO evento) {
        return null;
    }

    @Override
    public EventoDTO update(Long id, EventoDTO evento) {
        return null;
    }

    @Override
    public void delete(Long id) {
        
    }

}
