package com.ms_mascotas_eventos.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ComunaDTO(
    Long id,
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 255, message = "El nombre no puede tener más de 255 caracteres")
    String nombre,
    @NotNull(message = "La región no puede ser nula")
    Long regionId
) {}