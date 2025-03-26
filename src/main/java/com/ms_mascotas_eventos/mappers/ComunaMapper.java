package com.ms_mascotas_eventos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

/* import com.ms_mascotas_eventos.dtos.ComunaDTO;
import com.ms_mascotas_eventos.entities.Comuna; */

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ComunaMapper {
    ComunaMapper INSTANCE = Mappers.getMapper(ComunaMapper.class);

    // ComunaDTO toComunaDTO(Comuna comuna);
    //Comuna toComuna(ComunaDTO comuna);

}
