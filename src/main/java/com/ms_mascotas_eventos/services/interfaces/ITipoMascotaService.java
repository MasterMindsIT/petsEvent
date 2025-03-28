package com.ms_mascotas_eventos.services.interfaces;

import java.util.List;

import com.ms_mascotas_eventos.dtos.TipoMascotaDTO;

public interface ITipoMascotaService {
    //Realizar crud de tipo mascota

    //Listar todos los tipos de mascotas
    public List<TipoMascotaDTO> findAll();

    //Listar un tipo de mascota por id
    public TipoMascotaDTO findById(Long id);

    //Crear un tipo de mascota
    public TipoMascotaDTO save(TipoMascotaDTO tipoMascota);

    //Actualizar un tipo de mascota
    public TipoMascotaDTO update(Long id, TipoMascotaDTO tipoMascota);

    //Eliminar un tipo de mascota
    public void delete(Long id);
}
