package com.ms_mascotas_eventos.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.ms_mascotas_eventos.dtos.ComunaDTO;
import com.ms_mascotas_eventos.entities.Comuna;
import com.ms_mascotas_eventos.mappers.ComunaMapper;
import com.ms_mascotas_eventos.repositories.ComunaRepository;
import com.ms_mascotas_eventos.services.interfaces.IComunaService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@AllArgsConstructor
@Slf4j
public class ComunaServiceImpl implements IComunaService{

    private final ComunaRepository comunaRepository;
    
    @Override
    public List<ComunaDTO> findAll() {
        log.info("Service Todas los comunas");
        return comunaRepository.findAll()
                                .stream()
                                .map(ComunaMapper::toComunaDTO)
                                .toList();
    }

    @Override
    public ComunaDTO findById(Long id) {
        log.info("Service buscar comunas porID");
        return ComunaMapper.toComunaDTO(comunaRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @Override
    public ComunaDTO save(ComunaDTO comuna) {
        return null;
    }

    @Override
    public ComunaDTO update(Long id, ComunaDTO comuna) {
    
        return null;
    }

    @Override
    public boolean delete(Long id) {
        Comuna deleteComuna = ComunaMapper.toComuna(this.findById(id));
        comunaRepository.delete(deleteComuna);
        return true;
    }

}
