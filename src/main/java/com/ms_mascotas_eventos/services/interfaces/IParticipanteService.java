package com.ms_mascotas_eventos.services.interfaces;

import java.util.List;

import com.ms_mascotas_eventos.request.ParticipanteDTO;

public interface IParticipanteService {
    //realizar crud de participantes

    //Obtener todos los participantes
    public List<ParticipanteDTO> findAll();

    //Obtener un participante por id
    public ParticipanteDTO findById(Long id);

    //Crear un participante
    public ParticipanteDTO save(ParticipanteDTO participante);

    //Actualizar un participante
    public ParticipanteDTO update(Long id, ParticipanteDTO participante);

    //Eliminar un participante
    public void delete(Long id);
}
