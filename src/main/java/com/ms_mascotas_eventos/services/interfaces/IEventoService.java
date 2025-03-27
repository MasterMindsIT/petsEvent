package com.ms_mascotas_eventos.services.interfaces;

import java.util.List;

import com.ms_mascotas_eventos.dtos.EventoDTO;
public interface IEventoService {
    //Crear metodos para la clase Evento

    //Metodo para listar todos los eventos
    public List<EventoDTO> findAll();

    //Metodo para buscar un evento por id
    public EventoDTO findById(Long id);

    //Metodo para guardar un evento
    public EventoDTO save(EventoDTO evento);

    //Metodo para actualizar un evento
    public EventoDTO update(Long id, EventoDTO evento);

    //Metodo para eliminar un evento
    public void delete(Long id);
}
