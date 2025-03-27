package com.ms_mascotas_eventos.services.interfaces;

import java.util.List;

import com.ms_mascotas_eventos.dtos.RegionDTO;

public interface IRegionService {
    //crear crud de region

    //crear metodo para obtener todas regiones
    public List<RegionDTO> findAll();

    //crear metodo para obtener region por id
    public RegionDTO findById(Long id);

    //crear metodo para guardar region
    public RegionDTO save(RegionDTO region);

    //crear metodo para actualizar region
    public RegionDTO update(Long id, RegionDTO region);

    //crear metodo para eliminar region
    public void delete(Long id);
}
