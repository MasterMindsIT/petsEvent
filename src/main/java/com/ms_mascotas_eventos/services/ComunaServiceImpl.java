package com.ms_mascotas_eventos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ms_mascotas_eventos.dtos.ComunaDTO;
import com.ms_mascotas_eventos.entities.Comuna;
import com.ms_mascotas_eventos.repositories.ComunaRepository;
import com.ms_mascotas_eventos.services.interfaces.IComunaService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ComunaServiceImpl implements IComunaService{

    private final ComunaRepository comunaRepository;
    //private final ComunaMapper comunaMapper;


    @Override
    public List<ComunaDTO> findAll() {
        
        return null;
    }

    @Override
    public ComunaDTO findById(Long id) {
        //Comuna comuna = 
        return null;
    }

    @Override
    public ComunaDTO save(ComunaDTO comuna) {
        return null;
    }

    @Override
    public ComunaDTO update(ComunaDTO comuna) {
        return null;
    }

    @Override
    public void delete(Long id) {
        
    }

}
