package com.ms_mascotas_eventos.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms_mascotas_eventos.entities.Evento;
@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    /* List<Evento> findByNombre(String nombre);
    List<Evento> findByFecha(LocalDateTime fecha);
    List<Evento> findByUbicacion(String ubicacion);
    List<Evento> findByNombreAndFecha(String nombre, LocalDateTime fecha);
    List<Evento> findByNombreAndUbicacion(String nombre, String ubicacion);
    List<Evento> findByFechaAndUbicacion(LocalDateTime fecha, String ubicacion);
    List<Evento> findByNombreAndFechaAndUbicacion(String nombre, LocalDateTime fecha, String ubicacion); */
}
