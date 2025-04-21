package com.ms_mascotas_eventos.mappers;

import org.springframework.stereotype.Component;

import com.ms_mascotas_eventos.dtos.request.EventoRequest;
import com.ms_mascotas_eventos.entities.Evento;

@Component
public class EventoMapper {

    public static EventoRequest toEventoDTO(Evento evento) {
        return new EventoRequest(evento.getId(), evento.getNombre(), evento.getDescripcion(), evento.getFechaInicio(), evento.getFechaFin(), evento.getUbicacion(), evento.getComuna().getId());
    }


    public static Evento toEvento(EventoRequest eventoDTO){
        return new Evento(eventoDTO.id(), eventoDTO.nombre(), eventoDTO.descripcion(), eventoDTO.fechaInicio(), eventoDTO.fechaFin(), eventoDTO.ubicacion(), eventoDTO.comunaId() );
    }
}
