package com.ms_mascotas_eventos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ms_mascotas_eventos.Errors.RegionNotFoundException;
import com.ms_mascotas_eventos.dtos.RegionDTO;
import com.ms_mascotas_eventos.entities.Region;
import com.ms_mascotas_eventos.mappers.RegionMapper;
import com.ms_mascotas_eventos.repositories.RegionRepository;
import com.ms_mascotas_eventos.services.interfaces.IRegionService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class RegionServiceImpl implements IRegionService{

    private final RegionRepository regionRepository;
    private final RegionMapper regionMapper;

    @Override
    public List<RegionDTO> findAll() {
        return null;
    }

    @Override
    public RegionDTO findById(Long id) {
        Optional <Region> region = regionRepository.findById(id);
        if(region.isEmpty()) {
            return null;
        }
        return RegionMapper.toRegionDTO(regionRepository.findById(id).orElseThrow(RegionNotFoundException::new));
    }

    @Override
    public RegionDTO save(RegionDTO region) {
        Region regionEntity = regionMapper.toRegion(region);
        return regionMapper.toRegionDTO(regionRepository.save(regionEntity));
    }

    @Override
    public RegionDTO update(RegionDTO region) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

}
