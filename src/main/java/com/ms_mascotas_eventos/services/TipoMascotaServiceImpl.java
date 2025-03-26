package com.ms_mascotas_eventos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ms_mascotas_eventos.entities.TipoMascota;
import com.ms_mascotas_eventos.repositories.TipoMascotaRepository;
import com.ms_mascotas_eventos.services.interfaces.ITipoMascotaService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class TipoMascotaServiceImpl implements ITipoMascotaService{

    private final TipoMascotaRepository tipoMascotaRepository;

    @Override
    public List<TipoMascota> findAll() {
        return null;
    }

    @Override
    public TipoMascota findById(Long id) {
        return null;
    }

    @Override
    public TipoMascota save(TipoMascota tipoMascota) {
        return null;
    }

    @Override
    public TipoMascota update(TipoMascota tipoMascota) {
        return null;
    }

    @Override
    public void delete(Long id) {
        
    }

}
