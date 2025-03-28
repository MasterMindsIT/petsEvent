package com.ms_mascotas_eventos.repositories;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ms_mascotas_eventos.entities.Evento;

public class EventoData {
    List<Evento> eventos = new ArrayList<>();

    //Llenado de datos
    public EventoData(){
        eventos.add(new Evento(1L, "Feria Can", "Evento para amantes de los perros", LocalDateTime.of(2025, 3, 25, 14, 30, 0), LocalDateTime.of(2025, 3, 27, 14, 30, 0),"41.40338, 2.17403", 1L));
        eventos.add(new Evento(1L, "Feria Gatos", "Evento para amantes de los Gatos", LocalDateTime.of(2025, 3, 25, 14, 30, 0), LocalDateTime.of(2025, 3, 27, 14, 30, 0),"41.40338, 2.17403", 2L));
        eventos.add(new Evento(1L, "Feria Aves", "Evento para amantes de los Aves", LocalDateTime.of(2025, 3, 25, 14, 30, 0), LocalDateTime.of(2025, 3, 27, 14, 30, 0),"41.40338, 2.17403", 3L));
        
    }

    //Obtener todas las Eventos
    public List<Evento> getAll() {
        return eventos;
    }
    //Obtener Evento por Id
    public Evento getById(int id) {
        for (Evento evento : eventos) {
            if (evento.getId() == id) {
                return evento;
            }
        }
        return null;
    }
}
