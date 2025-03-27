package com.ms_mascotas_eventos.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.ms_mascotas_eventos.entities.Mascota;
import com.ms_mascotas_eventos.repositories.MascotaRepository;
import com.ms_mascotas_eventos.services.interfaces.IMascotaService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@AllArgsConstructor
@Slf4j
public class MascotaServiceImpl implements IMascotaService{

    private final MascotaRepository mascotaRepository;

    @Override
    public List<Mascota> findAll() {
        log.info("Service Todas las mascotas");
        return mascotaRepository.findAll();
    }

    @Override
    public Mascota findById(Long id) {
        log.info("Service buscar por ID las Mascotas");
        return mascotaRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Mascota save(Mascota mascota) {
        return null;
    }

    @Override
    public Mascota update(Long id, Mascota mascota) {
        return null;
    }

    @Override
    public void delete(Long id) {
        
    }

}
