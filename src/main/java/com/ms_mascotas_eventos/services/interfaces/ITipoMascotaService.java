package com.ms_mascotas_eventos.services.interfaces;

import java.util.List;

import com.ms_mascotas_eventos.entities.TipoMascota;

public interface ITipoMascotaService {
    //Realizar crud de tipo mascota

    //Listar todos los tipos de mascotas
    public List<TipoMascota> findAll();

    //Listar un tipo de mascota por id
    public TipoMascota findById(Long id);

    //Crear un tipo de mascota
    public TipoMascota save(TipoMascota tipoMascota);

    //Actualizar un tipo de mascota
    public TipoMascota update(Long id, TipoMascota tipoMascota);

    //Eliminar un tipo de mascota
    public void delete(Long id);
}
