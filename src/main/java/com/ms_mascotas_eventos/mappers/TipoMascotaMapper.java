package com.ms_mascotas_eventos.mappers;

import org.springframework.stereotype.Component;

import com.ms_mascotas_eventos.dtos.request.TipoMascotaRequest;
import com.ms_mascotas_eventos.entities.TipoMascota;

@Component
public class TipoMascotaMapper {

    public static TipoMascotaRequest toTipoMascotaDTO(TipoMascota tipoMascota){
        return new TipoMascotaRequest(tipoMascota.getId(),tipoMascota.getNombre());
    }

    public static TipoMascota toTipoMascota(TipoMascotaRequest tipoMascotaDTO){
        return new TipoMascota(tipoMascotaDTO.id(), tipoMascotaDTO.nombre());
    }

}
