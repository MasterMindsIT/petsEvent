package com.ms_mascotas_eventos.mappers;

import org.springframework.stereotype.Component;

import com.ms_mascotas_eventos.dtos.request.ComunaRequest;
import com.ms_mascotas_eventos.dtos.responses.ComunaResponse;
import com.ms_mascotas_eventos.dtos.responses.ComunaResponseSimple;
import com.ms_mascotas_eventos.entities.Comuna;
import com.ms_mascotas_eventos.entities.Region;

@Component
public class ComunaMapper {

    public static ComunaResponse toComunaResponse(Comuna comuna) {
        return new ComunaResponse(
            comuna.getId(),
            comuna.getNombre(),
            comuna.getRegion().getNombre()
        );
    }

    public static ComunaResponseSimple toResponseSimple(Comuna comuna) {
        return new ComunaResponseSimple(comuna.getId(), comuna.getNombre());
    }

    public static Comuna toEntity(ComunaRequest dto, Region region) {
        Comuna comuna = new Comuna();
        comuna.setNombre(dto.nombre());
        comuna.setRegion(region); // Este region lo resuelves antes en el servicio
        return comuna;
    }

}
