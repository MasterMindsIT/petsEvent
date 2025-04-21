package com.ms_mascotas_eventos.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.ms_mascotas_eventos.dtos.request.TipoMascotaRequest;
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
    public List<TipoMascotaRequest> findAll() {
        log.info("Service Todos los Tipo de mascotas");
        return tipoMascotaRepository.findAll()
                                    .stream()
                                    .map(TipoMascotaMapper::toTipoMascotaDTO)
                                    .toList();
    }



    @Override
    public TipoMascotaRequest findById(Long id) {
        log.info("Service buscar po ID Tipo de mascotas");
        return TipoMascotaMapper.toTipoMascotaDTO(tipoMascotaRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }



    @Override
    public TipoMascotaRequest save(TipoMascotaRequest tipoMascota) {
        return null;
    }



    @Override
    public TipoMascotaRequest update(Long id, TipoMascotaRequest tipoMascota) {
        return null;
    }

    @Override
    public void delete(Long id) {
        
    }

}
