package com.ms_mascotas_eventos.mappers;

import org.springframework.stereotype.Component;

import com.ms_mascotas_eventos.dtos.ParticipanteDTO;
import com.ms_mascotas_eventos.entities.Participante;

@Component
public class ParticipanteMapper {

    public static ParticipanteDTO toParticipanteDTO(Participante participante) {
        return new ParticipanteDTO(participante.getId(), participante.getNombre(),participante.getEmail());
    }

    public static Participante toParticipante(ParticipanteDTO participanteDTO) {
        return new Participante(participanteDTO.id(), participanteDTO.nombre(), participanteDTO.email());
    }
}

