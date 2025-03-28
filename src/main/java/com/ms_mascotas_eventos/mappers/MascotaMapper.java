package com.ms_mascotas_eventos.mappers;

import org.springframework.stereotype.Component;

import com.ms_mascotas_eventos.dtos.MascotaDTO;
import com.ms_mascotas_eventos.entities.Mascota;

@Component
public class MascotaMapper {

    public static MascotaDTO toMascotaDTO(Mascota mascota){
        return new MascotaDTO(mascota.getId(),mascota.getNombre(),mascota.getTipoMascota().getId(),mascota.getParticipante().getId());
    }

    public static Mascota toMascota(MascotaDTO mascotaDTO) {
        return new Mascota(mascotaDTO.id(), mascotaDTO.nombre(),mascotaDTO.tipoMascotaId(), mascotaDTO.participanteId());
    }

    
    
}
