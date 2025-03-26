package com.ms_mascotas_eventos.services.interfaces;

import java.util.List;

import com.ms_mascotas_eventos.entities.Comuna;

public interface IComunaService {
    //Crear los metodos de la interfaz comuna

    //Obtener todas las comunas
    public List<Comuna> findAll();

    //Obtener una comuna por id
    public Comuna findById(Long id);

    //Guardar una comuna
    public Comuna save(Comuna comuna);

    //Actualizar una comuna
    public Comuna update(Comuna comuna);

    //Eliminar una comuna
    public void delete(Long id);
}
