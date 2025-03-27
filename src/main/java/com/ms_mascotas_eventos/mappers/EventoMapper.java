package com.ms_mascotas_eventos.mappers;

import org.springframework.stereotype.Component;

import com.ms_mascotas_eventos.dtos.EventoDTO;
import com.ms_mascotas_eventos.entities.Evento;

@Component
public class EventoMapper {

    public static EventoDTO toEventoDTO(Evento evento) {
        return new EventoDTO(evento.getId(), evento.getNombre(), evento.getDescripcion(), evento.getFechaInicio(), evento.getFechaFin(), evento.getUbicacion(), evento.getComuna().getId());
    }


    public static Evento toEvento(EventoDTO eventoDTO){
        return new Evento(eventoDTO.id(), eventoDTO.nombre(), eventoDTO.descripcion(), eventoDTO.fechaInicio(), eventoDTO.fechaFin(), eventoDTO.ubicacion(), eventoDTO.comunaId() );
    }
}
