package com.ms_mascotas_eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms_mascotas_eventos.entities.Comuna;

@Repository
public interface ComunaRepository extends JpaRepository<Comuna, Long> {

}
