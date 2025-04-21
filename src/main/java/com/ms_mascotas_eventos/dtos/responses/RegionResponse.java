package com.ms_mascotas_eventos.dtos.responses;

import java.io.Serializable;
import java.util.List;

public record RegionResponse(
    Long id,
    String nombre,
    List<ComunaResponseSimple> comunas
) implements Serializable {}
