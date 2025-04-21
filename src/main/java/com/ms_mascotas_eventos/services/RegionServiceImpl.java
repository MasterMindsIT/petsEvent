package com.ms_mascotas_eventos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ms_mascotas_eventos.Errors.RegionNotFoundException;
import com.ms_mascotas_eventos.mappers.RegionMapper;
import com.ms_mascotas_eventos.repositories.RegionRepository;
import com.ms_mascotas_eventos.request.RegionDTO;
import com.ms_mascotas_eventos.services.interfaces.IRegionService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@AllArgsConstructor
@Slf4j
public class RegionServiceImpl implements IRegionService{

    private final RegionRepository regionRepository;

    @Override
    public List<RegionDTO> findAll() {
        log.info("Service Todas las Regiones");
        return regionRepository.findAll()
                                .stream()
                                .map(region -> RegionMapper.toRegionDTO(region))
                                .toList();
    }

    @Override
    public RegionDTO findById(Long id) {
        log.info("Service Obtener por ID la region");
       return RegionMapper.toRegionDTO(regionRepository.findById(id).orElseThrow(()-> new RegionNotFoundException(id)));
    }

    @Override
    public RegionDTO save(RegionDTO region) {
        return RegionMapper.toRegionDTO(regionRepository.save(RegionMapper.toRegion(region)));
    }

    @Override
    public RegionDTO update(Long id, RegionDTO region) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

}
