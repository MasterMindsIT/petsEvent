package com.ms_mascotas_eventos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.ms_mascotas_eventos.dtos.RegionDTO;
import com.ms_mascotas_eventos.entities.Region;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RegionMapper {
    RegionMapper INSTANCE = Mappers.getMapper(RegionMapper.class);

    RegionDTO toRegionDTO(Region region);

    //Region toRegion(RegionDTO region);
}
