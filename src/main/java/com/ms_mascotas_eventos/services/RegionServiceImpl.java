package com.ms_mascotas_eventos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ms_mascotas_eventos.dtos.request.RegionRequest;
import com.ms_mascotas_eventos.dtos.responses.RegionResponse;
import com.ms_mascotas_eventos.entities.Region;
import com.ms_mascotas_eventos.exceptions.EntityNotFoundException;
import com.ms_mascotas_eventos.mappers.RegionMapper;
import com.ms_mascotas_eventos.repositories.RegionRepository;
import com.ms_mascotas_eventos.services.interfaces.IRegionService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@AllArgsConstructor
@Slf4j
public class RegionServiceImpl implements IRegionService{

    private final RegionRepository regionRepository;

    @Override
    public List<RegionResponse> findAll() {
        log.info("Service Todas las Regiones");
        List<Region> regiones = regionRepository.findAll(); //busco todas las regiones
        return regiones.stream()
        .map(RegionMapper::toRegionResponse)
        .collect(Collectors.toList()); // mapeo la lista de regiones a una lista de RegionResponse de respuestas dto
    }

    @Override
    public RegionResponse findById(Long id) {
        log.info("Service Obtener por ID la region");
       return regionRepository.findById(id) //busco la region por id
        .map(RegionMapper::toRegionResponse) //mapeo la region a RegionResponse
        .orElseThrow(() -> new EntityNotFoundException(Region.class, id)); //si no existe lanzo una excepcion
    }

    @Override
    public RegionResponse save(RegionRequest region) {
        log.info("Service save region");
        return RegionMapper.toRegionResponse(regionRepository.save(RegionMapper.toEntity(region))); //guardo la region
    }
    @Override
    public RegionResponse update(Long id, RegionRequest region) {
        log.info("Service update region");
        Region regionUpdate = regionRepository.findById(id) //busco la region por id
        .orElseThrow(() -> new EntityNotFoundException(Region.class, id)); //si no existe lanzo una excepcion
        regionUpdate.setNombre(region.nombre()); //actualizo el nombre de la region
        return RegionMapper.toRegionResponse(regionUpdate); //mapeo la region a RegionResponse
    }

    @Override
    public boolean delete(Long id) {
        log.info("Service delete por ID la region");
        if (!regionRepository.existsById(id)) {
            throw new EntityNotFoundException(Region.class, id); //si no existe lanzo una excepcion
        }
        Region regionDelete = regionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Region.class, id));
        if(!regionDelete.getComunas().isEmpty())
            return false;
        regionRepository.deleteById(id);
        return true;
    }

}
