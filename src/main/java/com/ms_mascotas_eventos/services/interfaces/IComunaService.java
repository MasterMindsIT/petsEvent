package com.ms_mascotas_eventos.services.interfaces;

import java.util.List;

import com.ms_mascotas_eventos.dtos.request.ComunaRequest;
import com.ms_mascotas_eventos.dtos.responses.ComunaResponse;


public interface IComunaService {
    //Crear los metodos de la interfaz comuna

    //Obtener todas las comunas
    public List<ComunaResponse> findAll();

    //Obtener una comuna por id
    public ComunaResponse findById(Long id);

    //Guardar una comuna
    public ComunaResponse save(ComunaRequest comuna);

    //Actualizar una comuna
    public ComunaResponse update(Long id, ComunaRequest comuna);

    //Eliminar una comuna
    public boolean delete(Long id);
}
