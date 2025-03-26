package com.ms_mascotas_eventos.services.interfaces;

import java.util.List;

import com.ms_mascotas_eventos.entities.Region;

public interface IRegionService {
    //crear crud de region

    //crear metodo para obtener todas regiones
    public List<Region> findAll();

    //crear metodo para obtener region por id
    public Region findById(Long id);

    //crear metodo para guardar region
    public Region save(Region region);

    //crear metodo para actualizar region
    public Region update(Region region);

    //crear metodo para eliminar region
    public void delete(Long id);
}
