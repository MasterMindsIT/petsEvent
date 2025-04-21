package com.ms_mascotas_eventos.dtos.request;

import java.io.Serializable;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
@Builder
public record RegionRequest(
    Long id,
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 255, message = "El nombre no puede tener más de 255 caracteres")
    String nombre,
    List<ComunaRequest> comunas
) implements Serializable{}