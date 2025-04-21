package com.ms_mascotas_eventos.dtos.responses;

import java.io.Serializable;

public record ComunaResponseSimple(
    Long id,
    String nombre
) implements Serializable {}