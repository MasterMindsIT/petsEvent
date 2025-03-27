package com.ms_mascotas_eventos.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ms_mascotas_eventos.dtos.RegionDTO;
import com.ms_mascotas_eventos.entities.Region;
@Component
public class RegionMapper {
    
    //recibe una entidad y devuelve un dto
    public static RegionDTO toRegionDTO(Region region){
        return new RegionDTO(region.getId(), region.getNombre());
    }

    //recibe un dto y devuelve una entidad
    public static Region toRegion(RegionDTO region){
        return new Region(region.id(), region.nombre(), null);
    }

    //recibe una lista de entidades y devuelve una lista de dtos
    public static List<RegionDTO> toDtoList(List<Region> regiones){
        return regiones.stream().map(region -> toRegionDTO(region)).collect(Collectors.toList());
    }
    
    //recibe una lista de dtos y devuelve una lista de entidades
    public static List<Region> toEntityList(List<RegionDTO> regiones){
        return regiones.stream().map(region -> toRegion(region)).collect(Collectors.toList());
    }
}
