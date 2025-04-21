package com.ms_mascotas_eventos.mappers;

import org.springframework.stereotype.Component;

import com.ms_mascotas_eventos.dtos.request.ParticipanteRequest;
import com.ms_mascotas_eventos.entities.Participante;

@Component
public class ParticipanteMapper {

    public static ParticipanteRequest toParticipanteDTO(Participante participante) {
        return new ParticipanteRequest(participante.getId(), participante.getNombre(),participante.getEmail());
    }

    public static Participante toParticipante(ParticipanteRequest participanteDTO) {
        return new Participante(participanteDTO.id(), participanteDTO.nombre(), participanteDTO.email());
    }
}

