package com.ms_mascotas_eventos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ms_mascotas_eventos.dtos.request.ComunaRequest;
import com.ms_mascotas_eventos.dtos.responses.ComunaResponse;
import com.ms_mascotas_eventos.entities.Comuna;
import com.ms_mascotas_eventos.entities.Region;
import com.ms_mascotas_eventos.exceptions.EntityNotFoundException;
import com.ms_mascotas_eventos.mappers.ComunaMapper;
import com.ms_mascotas_eventos.repositories.ComunaRepository;
import com.ms_mascotas_eventos.repositories.RegionRepository;
import com.ms_mascotas_eventos.services.interfaces.IComunaService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@AllArgsConstructor
@Slf4j
public class ComunaServiceImpl implements IComunaService{

    private final ComunaRepository comunaRepository;
    private final RegionRepository regionRepository;
    
    @Override
    public List<ComunaResponse> findAll() {
        log.info("Service Todas los comunas");
        List<Comuna> comunas = comunaRepository.findAll();
        return comunas.stream()
                .map(ComunaMapper::toComunaResponse)
                .toList();
    }

    @Override
    public ComunaResponse findById(Long id) {
        log.info("Service buscar comunas porID");
        return comunaRepository.findById(id)
                .map(ComunaMapper::toComunaResponse)
                .orElseThrow(() -> new EntityNotFoundException(Comuna.class, id));
    }

    @Override
    public ComunaResponse save(ComunaRequest comuna) {
        log.info("Service guardar comuna");
        Region region = regionRepository.findById(comuna.regionId())
                        .orElseThrow(()->new EntityNotFoundException(Region.class, comuna.regionId())); // Aquí debes resolver la región antes de guardar
        Comuna newComuna = ComunaMapper.toEntity(comuna, region);
        ComunaResponse comunaResponse = ComunaMapper.toComunaResponse(comunaRepository.save(newComuna));
        return comunaResponse;
    }

    @Override
    public ComunaResponse update(Long id, ComunaRequest comuna) {
        log.info("Service actualizar comuna por ID");
        Comuna traerComuna = comunaRepository.findById(id) //comprobamos la comuna
                            .orElseThrow(() -> new EntityNotFoundException(Comuna.class, id));
        Region region = regionRepository.findById(comuna.regionId()) //comprobamos la region
                            .orElseThrow(() -> new EntityNotFoundException(Region.class, comuna.regionId()));
        traerComuna.setNombre(comuna.nombre()); //seteamos los datos
        traerComuna.setRegion(region);
        ComunaResponse comunaResponse = ComunaMapper.toComunaResponse(comunaRepository.save(traerComuna));
        return comunaResponse;
    }

    @Override
    public boolean delete(Long id) {
        log.info("Service eliminar comuna por ID");
        if(!comunaRepository.existsById(id)){
            log.error("No existe la comuna con ID: {}", id);
            throw new EntityNotFoundException(Comuna.class, id);
        }else{
            comunaRepository.deleteById(id);
            return true;
        }
    }

}
