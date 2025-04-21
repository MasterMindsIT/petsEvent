package com.ms_mascotas_eventos.mappers;

import org.springframework.stereotype.Component;

import com.ms_mascotas_eventos.entities.Comuna;
import com.ms_mascotas_eventos.request.ComunaDTO;

@Component
public class ComunaMapper {

    public static ComunaDTO toComunaDTO(Comuna comuna){
        return new ComunaDTO(comuna.getId(), comuna.getNombre(),comuna.getRegion().getId());
    }

    public static Comuna toComuna(ComunaDTO comunaDTO) {
        return new Comuna(comunaDTO.id(), comunaDTO.nombre(), comunaDTO.regionId());
    }

}
