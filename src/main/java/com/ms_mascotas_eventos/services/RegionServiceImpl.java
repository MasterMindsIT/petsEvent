package com.ms_mascotas_eventos.services;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.ms_mascotas_eventos.Errors.RegionNotFoundException;
import com.ms_mascotas_eventos.dtos.RegionDTO;
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
        return regionMapper.toRegionDTO(regionRepository.findById(id).orElseThrow(() -> new RegionNotFoundException("Region not found with id: " + id))); 
    }

    @Override
    public RegionDTO save(RegionDTO region) {
        return null;
    }

    @Override
    public RegionDTO update(RegionDTO region) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

}
