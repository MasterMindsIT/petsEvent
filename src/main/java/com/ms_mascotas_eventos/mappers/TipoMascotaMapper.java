package com.ms_mascotas_eventos.mappers;

import org.springframework.stereotype.Component;

import com.ms_mascotas_eventos.entities.TipoMascota;
import com.ms_mascotas_eventos.request.TipoMascotaDTO;

@Component
public class TipoMascotaMapper {

    public static TipoMascotaDTO toTipoMascotaDTO(TipoMascota tipoMascota){
        return new TipoMascotaDTO(tipoMascota.getId(),tipoMascota.getNombre());
    }

    public static TipoMascota toTipoMascota(TipoMascotaDTO tipoMascotaDTO){
        return new TipoMascota(tipoMascotaDTO.id(), tipoMascotaDTO.nombre());
    }

}
