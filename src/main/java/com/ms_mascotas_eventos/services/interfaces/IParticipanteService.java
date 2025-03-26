package com.ms_mascotas_eventos.services.interfaces;

import java.util.List;

import com.ms_mascotas_eventos.entities.Participante;

public interface IParticipanteService {
    //realizar crud de participantes

    //Obtener todos los participantes
    public List<Participante> findAll();

    //Obtener un participante por id
    public Participante findById(Long id);

    //Crear un participante
    public Participante save(Participante participante);

    //Actualizar un participante
    public Participante update(Participante participante);

    //Eliminar un participante
    public void delete(Long id);
}
