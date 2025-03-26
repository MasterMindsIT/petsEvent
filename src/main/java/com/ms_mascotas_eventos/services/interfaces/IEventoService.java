package com.ms_mascotas_eventos.services.interfaces;

import java.util.List;

import com.ms_mascotas_eventos.entities.Evento;

public interface IEventoService {
    //Crear metodos para la clase Evento

    //Metodo para listar todos los eventos
    public List<Evento> findAll();

    //Metodo para buscar un evento por id
    public Evento findById(Long id);

    //Metodo para guardar un evento
    public Evento save(Evento evento);

    //Metodo para actualizar un evento
    public Evento update(Evento evento);

    //Metodo para eliminar un evento
    public void delete(Long id);
}
