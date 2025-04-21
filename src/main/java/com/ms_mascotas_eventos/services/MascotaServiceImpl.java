package com.ms_mascotas_eventos.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.ms_mascotas_eventos.mappers.MascotaMapper;
import com.ms_mascotas_eventos.repositories.MascotaRepository;
import com.ms_mascotas_eventos.request.MascotaDTO;
import com.ms_mascotas_eventos.services.interfaces.IMascotaService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@AllArgsConstructor
@Slf4j
public class MascotaServiceImpl implements IMascotaService{

    private final MascotaRepository mascotaRepository;

    @Override
    public List<MascotaDTO> findAll() {
        log.info("Service Todas las mascotas");
        return mascotaRepository.findAll()
                                .stream()
                                .map(MascotaMapper::toMascotaDTO)
                                .toList();
    }

    @Override
    public MascotaDTO findById(Long id) {
        log.info("Service buscar por ID las Mascotas");
        return MascotaMapper.toMascotaDTO(mascotaRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @Override
    public MascotaDTO save(MascotaDTO mascota) {
        return null;
    }

    @Override
    public MascotaDTO update(Long id, MascotaDTO mascota) {
        return null;
    }

    @Override
    public void delete(Long id) {
        
    }

}
