package com.ms_mascotas_eventos.services.interfaces;

import java.util.List;

import com.ms_mascotas_eventos.dtos.request.ParticipanteRequest;

public interface IParticipanteService {
    //realizar crud de participantes

    //Obtener todos los participantes
    public List<ParticipanteRequest> findAll();

    //Obtener un participante por id
    public ParticipanteRequest findById(Long id);

    //Crear un participante
    public ParticipanteRequest save(ParticipanteRequest participante);

    //Actualizar un participante
    public ParticipanteRequest update(Long id, ParticipanteRequest participante);

    //Eliminar un participante
    public void delete(Long id);
}
