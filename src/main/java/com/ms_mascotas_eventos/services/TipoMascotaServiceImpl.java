package com.ms_mascotas_eventos.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.ms_mascotas_eventos.dtos.TipoMascotaDTO;
import com.ms_mascotas_eventos.entities.TipoMascota;
import com.ms_mascotas_eventos.mappers.TipoMascotaMapper;
import com.ms_mascotas_eventos.repositories.TipoMascotaRepository;
import com.ms_mascotas_eventos.services.interfaces.ITipoMascotaService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@AllArgsConstructor
@Slf4j
public class TipoMascotaServiceImpl implements ITipoMascotaService{

    private final TipoMascotaRepository tipoMascotaRepository;

    @Override
    public List<TipoMascotaDTO> findAll() {
        log.info("Service Todos los Tipo de mascotas");
        return tipoMascotaRepository.findAll()
                                    .stream()
                                    .map(TipoMascotaMapper::toTipoMascotaDTO)
                                    .toList();
    }



    @Override
    public TipoMascotaDTO findById(Long id) {
        log.info("Service buscar po ID Tipo de mascotas");
        return TipoMascotaMapper.toTipoMascotaDTO(tipoMascotaRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }



    @Override
    public TipoMascotaDTO save(TipoMascotaDTO tipoMascota) {
        return null;
    }



    @Override
    public TipoMascotaDTO update(Long id, TipoMascotaDTO tipoMascota) {
        return null;
    }

    @Override
    public void delete(Long id) {
        
    }

}
