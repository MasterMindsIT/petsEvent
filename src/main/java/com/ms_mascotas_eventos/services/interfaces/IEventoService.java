package com.ms_mascotas_eventos.services.interfaces;

import java.util.List;

import com.ms_mascotas_eventos.dtos.request.EventoRequest;
public interface IEventoService {
    //Crear metodos para la clase Evento

    //Metodo para listar todos los eventos
    public List<EventoRequest> findAll();

    //Metodo para buscar un evento por id
    public EventoRequest findById(Long id);

    //Metodo para guardar un evento
    public EventoRequest save(EventoRequest evento);

    //Metodo para actualizar un evento
    public EventoRequest update(Long id, EventoRequest evento);

    //Metodo para eliminar un evento
    public void delete(Long id);
}
