package com.ms_mascotas_eventos.services.interfaces;

import java.util.List;

import com.ms_mascotas_eventos.dtos.ComunaDTO;


public interface IComunaService {
    //Crear los metodos de la interfaz comuna

    //Obtener todas las comunas
    public List<ComunaDTO> findAll();

    //Obtener una comuna por id
    public ComunaDTO findById(Long id);

    //Guardar una comuna
    public ComunaDTO save(ComunaDTO comuna);

    //Actualizar una comuna
    public ComunaDTO update(ComunaDTO comuna);

    //Eliminar una comuna
    public void delete(Long id);
}
