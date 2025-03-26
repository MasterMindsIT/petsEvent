package com.ms_mascotas_eventos.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms_mascotas_eventos.entities.Participante;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
    /* List<Participante> findByNombre(String nombre);
    List<Participante> findByTipoMascota(String tipoMascota);
    List<Participante> findByRaza(String raza);
    List<Participante> findByNombreAndTipoMascota(String nombre, String tipoMascota);
    List<Participante> findByNombreAndRaza(String nombre, String raza);
    List<Participante> findByTipoMascotaAndRaza(String tipoMascota, String raza);
    List<Participante> findByNombreAndTipoMascotaAndRaza(String nombre, String tipoMascota, String raza); */
}
