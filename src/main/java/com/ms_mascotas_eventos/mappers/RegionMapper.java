package com.ms_mascotas_eventos.mappers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ms_mascotas_eventos.dtos.request.RegionRequest;
import com.ms_mascotas_eventos.dtos.responses.ComunaResponseSimple;
import com.ms_mascotas_eventos.dtos.responses.RegionResponse;
import com.ms_mascotas_eventos.entities.Region;
@Component
public class RegionMapper {
    
    public static RegionResponse toRegionResponse(Region region) {
        if (!region.getComunas().isEmpty()){
            List<ComunaResponseSimple> comunas = region.getComunas().stream()
            .map(ComunaMapper::toResponseSimple)
            .collect(Collectors.toList());
            return new RegionResponse(region.getId(), region.getNombre(), comunas);
        } else{
            return new RegionResponse(region.getId(), region.getNombre(), Collections.emptyList());
        }
        
    }

    public static Region toEntity(RegionRequest dto) {
        Region region = new Region();
        region.setNombre(dto.nombre());
        return region;
    }
    
    
}
