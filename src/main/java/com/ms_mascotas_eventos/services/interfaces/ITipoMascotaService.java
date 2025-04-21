package com.ms_mascotas_eventos.services.interfaces;

import java.util.List;

import com.ms_mascotas_eventos.dtos.request.TipoMascotaRequest;

public interface ITipoMascotaService {
    //Realizar crud de tipo mascota

    //Listar todos los tipos de mascotas
    public List<TipoMascotaRequest> findAll();

    //Listar un tipo de mascota por id
    public TipoMascotaRequest findById(Long id);

    //Crear un tipo de mascota
    public TipoMascotaRequest save(TipoMascotaRequest tipoMascota);

    //Actualizar un tipo de mascota
    public TipoMascotaRequest update(Long id, TipoMascotaRequest tipoMascota);

    //Eliminar un tipo de mascota
    public void delete(Long id);
}
