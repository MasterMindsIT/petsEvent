package com.ms_mascotas_eventos.services.interfaces;

import java.util.List;

import com.ms_mascotas_eventos.dtos.request.RegionRequest;
import com.ms_mascotas_eventos.dtos.responses.RegionResponse;

public interface IRegionService {
    //crear crud de region

    //crear metodo para obtener todas regiones
    public List<RegionResponse> findAll();

    //crear metodo para obtener region por id
    public RegionResponse findById(Long id);

    //crear metodo para guardar region
    public RegionResponse save(RegionRequest region);

    //crear metodo para actualizar region
    public RegionResponse update(Long id, RegionRequest region);

    //crear metodo para eliminar region
    public boolean delete(Long id);
}
