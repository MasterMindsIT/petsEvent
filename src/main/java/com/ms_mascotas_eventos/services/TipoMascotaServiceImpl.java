package com.ms_mascotas_eventos.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.ms_mascotas_eventos.entities.TipoMascota;
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
    public List<TipoMascota> findAll() {
        log.info("Service Todos los Tipo de mascotas");
        return tipoMascotaRepository.findAll();
    }



    @Override
    public TipoMascota findById(Long id) {
        log.info("Service buscar po ID Tipo de mascotas");
        return tipoMascotaRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }



    @Override
    public TipoMascota save(TipoMascota tipoMascota) {
        return null;
    }



    @Override
    public TipoMascota update(Long id, TipoMascota tipoMascota) {
        return null;
    }

    @Override
    public void delete(Long id) {
        
    }

}
